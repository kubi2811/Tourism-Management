CREATE DATABASE DB_OrderTour_Partition
GO 
USE DB_OrderTour_Partition
GO


-- Tạo Partition Function
CREATE PARTITION FUNCTION OrderDatePartition (datetime)
AS 
RANGE RIGHT 
FOR VALUES ('2020-01-01', '2021-01-01')
GO

-- Tạo Partition Scheme
CREATE PARTITION SCHEME OrderDatePartitionScheme
AS
PARTITION OrderTourDatePartition
TO (FG1, FG2, FG3 )
GO

-- Tạo các FILE GROUP

ALTER DATABASE DB_OrderTour_Partition ADD FILEGROUP FG1
ALTER DATABASE DB_OrderTour_Partition ADD FILEGROUP FG2
ALTER DATABASE DB_OrderTour_Partition ADD FILEGROUP FG3

ALTER DATABASE PartDB ADD FILE (NAME = N'F1', FILENAME = N'F:\Tourism-Management\DB_Projet\Partition\OrderTour\DB_OrderTour_Partition_F1.ndf') TO FILEGROUP FG1
ALTER DATABASE PartDB ADD FILE (NAME = N'F2', FILENAME = N'F:\Tourism-Management\DB_Projet\Partition\OrderTour\DB_OrderTour_Partition_F2.ndf') TO FILEGROUP FG2
ALTER DATABASE PartDB ADD FILE (NAME = N'F3', FILENAME = N'F:\Tourism-Management\DB_Projet\Partition\OrderTour\DB_OrderTour_Partition_F3.ndf') TO FILEGROUP FG3

-- Tạo Partition Table

CREATE TABLE OrderTour_Partition_Table
(
	IdOrder INT IDENTITY(1,1) primary key,
	IdClient int,
	createDate datetime default getdate(),
	Total float)
ON OrderDatePartitionScheme (date);
GO

CREATE INDEX idx_date_order_partition
ON Order_Partition_Table (date);
GO