USE ManageTourist
GO

-- DROP DATABASE DB_OrderTour_Partition

-- Tạo các FILE GROUP

ALTER DATABASE ManageTourist ADD FILEGROUP OrderTour_2021
ALTER DATABASE ManageTourist ADD FILEGROUP OrderTour_2022

ALTER DATABASE ManageTourist ADD FILE ( NAME = N'OrderTour_2021',
										FILENAME = N'F:\Partition\OrderTour_Year\OrderTour_2021.ndf', 
										SIZE = 10MB, 
										MAXSIZE = UNLIMITED, 
										FILEGROWTH = 1024 KB)
 TO FILEGROUP OrderTour_2021
ALTER DATABASE ManageTourist ADD FILE ( NAME = N'OrderTour_2022', 
										FILENAME = N'F:\Partition\OrderTour_Year\OrderTour_2022.ndf', 
										SIZE = 10MB, 
										MAXSIZE = UNLIMITED, 
										FILEGROWTH = 1024 KB) 
TO FILEGROUP OrderTour_2022
-- Tạo Partition Function
CREATE PARTITION FUNCTION OrderTour_by_Year_Function (datetime)
AS 
RANGE LEFT 
FOR VALUES ('2020-12-31','2021-12-31')
GO

-- Tạo Partition Scheme
CREATE PARTITION SCHEME OrderTour_by_Year_Scheme
AS
PARTITION OrderTour_by_Year_function
TO ([PRIMARY], OrderTour_2021, OrderTour_2022 )
GO



CREATE CLUSTERED INDEX ix_OrderTour_by_Year
ON dbo.OrderTour
(
	[createDate]
) ON [OrderTour_by_Year_scheme]([createDate])

SELECT 
	p.partition_number AS partition_number,
	f.name AS file_group, 
	p.rows AS row_count
FROM sys.partitions p
JOIN sys.destination_data_spaces dds ON p.partition_number = dds.destination_id
JOIN sys.filegroups f ON dds.data_space_id = f.data_space_id
WHERE OBJECT_NAME(OBJECT_ID) = 'OrderTour'
group by p.partition_number,f.name,p.rows
order by partition_number;

--ds filegroup
SELECT name as [PRIMARY]
FROM sys.filegroups
WHERE type = 'FG'
GO 

--xem các partition đã tạo
SELECT name as [ManageTour],physical_name 
FROM sys.database_files
where type_desc = 'ROWS'
GO


--<2021
SELECT * FROM OrderTour
WHERE $PARTITION.OrderTour_by_Year_Function(createDate) = 1;
-->2019 và <2020
SELECT * FROM HoaDon
WHERE $PARTITION.OrderTour_by_Year_Function(createDate) = 2;
-->2020
SELECT * FROM HoaDon
WHERE $PARTITION.OrderTour_by_Year_Function(createDate) = 3;
-- Tạo Partition Table

--CREATE TABLE OrderTour_Partition_Table
--(
--	IdOrder INT IDENTITY(1,1) primary key,
--	IdClient int,
--	createDate datetime default getdate(),
--	Total float,
--	isDeleted int default 0)
--ON IdOrderPartitionScheme (IdOrder);
--GO
