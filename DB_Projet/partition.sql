USE ManageTourist
GO

-- DROP DATABASE DB_OrderTour_Partition

-- Tạo các FILE GROUP

ALTER DATABASE ManageTourist ADD FILEGROUP FG1
ALTER DATABASE ManageTourist ADD FILEGROUP FG2
ALTER DATABASE ManageTourist ADD FILEGROUP FG3

ALTER DATABASE ManageTourist ADD FILE (NAME = N'F1', FILENAME = N'F:\Partition\OrderTour\DB_OrderTour_Partition_F1.ndf', SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 1MB) TO FILEGROUP FG1
ALTER DATABASE ManageTourist ADD FILE (NAME = N'F2', FILENAME = N'F:\Partition\OrderTour\DB_OrderTour_Partition_F2.ndf', SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 1MB) TO FILEGROUP FG2
ALTER DATABASE ManageTourist ADD FILE (NAME = N'F3', FILENAME = N'F:\Partition\OrderTour\DB_OrderTour_Partition_F3.ndf', SIZE = 5MB, MAXSIZE = 100MB, FILEGROWTH = 1MB) TO FILEGROUP FG3


-- Tạo Partition Function
CREATE PARTITION FUNCTION IdOrderPartition (int)
AS 
RANGE RIGHT 
FOR VALUES (100, 200)
GO

-- Tạo Partition Scheme
CREATE PARTITION SCHEME IdOrderPartitionScheme
AS
PARTITION IdOrderPartition
TO (FG1, FG2, FG3 )
GO


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
