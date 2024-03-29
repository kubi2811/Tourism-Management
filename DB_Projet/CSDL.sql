﻿create database ManageTourist
go

use ManageTourist
go


--use master 
--go
--drop database ManageTourist
--go


create table Admin(
	IdAdmin INT IDENTITY(1,1) primary key,
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL
)
go

create table Staff (
	IdStaff INT IDENTITY(1,1) primary key,
	Admin varchar(50) NOT NULL FOREIGN KEY REFERENCES Admin(Username),
	FullName nvarchar(50),
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL,
	Status int default 1
	-- Status 0 is Enable, Status 1 is Disable, ...
)
go

-- drop table Staff

create table Client (
	IdClient INT IDENTITY(1,1) primary key,
	FullName nvarchar(50),
	Phone varchar(50) UNIQUE,
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL,
	Email varchar(50)
)
go

create table UserAddress(
	Id INT IDENTITY(1,1) primary key,
	Username varchar(50) FOREIGN KEY REFERENCES Client(Username),
	number int,
	street nvarchar(50), 
	ward nvarchar(50),
	city nvarchar(50),
	provience nvarchar(50)
)
go

create table Tour (
	IdTour INT IDENTITY(1,1) primary key,
	TourName nvarchar(50) UNIQUE,
	DayStart Date,
	DayEnd Date,
	CostAdo float,
	CostChild float
)
go

create table LocationStart(
	IdLocationStart INT IDENTITY(1,1) primary key,
	Tour nvarchar(50) FOREIGN KEY REFERENCES Tour(TourName),
	Province nvarchar(50) NOT NULL
)
go

create table LocationVisit(
	IdLocationVisit INT IDENTITY(1,1) primary key,
	Tour nvarchar(50) FOREIGN KEY REFERENCES Tour(TourName),
	VisitPlace nvarchar(50) NOT NULL
)
go

create table Vehicle(
	IdVehicle INT IDENTITY(1,1) primary key,
	IdLocationStart int FOREIGN KEY REFERENCES LocationStart(IdLocationStart), -- Lấy tour name từ bảng tour
	Transport nvarchar(50) NOT NULL,
	Capacity int NOT NULL
)
go

create table Descriptions (
	IdDescription INT IDENTITY(1,1) primary key,
	Tour nvarchar(50) FOREIGN KEY REFERENCES Tour(TourName),
	CreateDate datetime default getdate(),
	Total float,
) 
go

create table DescriptionDetail (
	IdDescriptionDetail INT IDENTITY(1,1) primary key,
	IdDescription int FOREIGN KEY REFERENCES Descriptions(IdDescription),
	nameDescription nvarchar(50),
	Adults int, 
	Childs int,
	Incurred float,
	Total float
) 
go

create table OrderTour (
	IdOrder INT IDENTITY(1,1) primary key,
	IdClient int,
	createDate datetime default getdate(),
	Total float,
	isDeleted int default 0
)
go


create table OrderDetail(
		IdOrderDetail INT IDENTITY(1,1) primary key,
		IdOrder int,
		IdClient int,
		Tour nvarchar(50) FOREIGN KEY REFERENCES Tour(TourName),
		--Tong so nguoi
		Adluts int NOT NULL,
		Childs int NOT NULL
)
go

create table OrderStatus(
	IdOrderStatus INT IDENTITY(1,1) primary key,
	IdOrder int,
	ClientUserName varchar(50) FOREIGN KEY REFERENCES Client(Username),
	Status nvarchar(50)
)
go


create table History(
	IdHistory INT IDENTITY(1,1) primary key,
	IdOrder int,
	paidDate datetime default getdate(),
)
go
				

-- ALTER TABLE
alter table OrderTour
add foreign key(IdClient) references Client(IdClient)
go

alter table OrderDetail
add foreign key(IdOrder) references OrderTour(IdOrder)
go


alter table OrderStatus
add foreign key(IdOrder) references OrderTour(IdOrder)
go

alter table History
add foreign key(IdOrder) references OrderTour(IdOrder)
go

select * from OrderDetail
Select * from OrderTour
Select * from OrderStatus
-- Trigger order
drop trigger trg_OrderTour
CREATE TRIGGER trg_OrderTour ON OrderDetail  AFTER INSERT AS 
BEGIN
	UPDATE OrderTour
	SET Total = (SELECT Adluts from OrderDetail where IdOrder = OrderTour.IdOrder) * (SELECT CostAdo from Tour where TourName = Tour)  + 
	(Select Childs from OrderDetail where IdOrder = OrderTour.IdOrder) * (SELECT CostChild from Tour where TourName = Tour)
	FROM OrderTour
	JOIN inserted ON OrderTour.IdOrder = inserted.IdOrder
END
GO


CREATE TRIGGER trg_CapNhatOrderTour ON OrderDetail After Update as 
begin 
	UPDATE OrderTour
	SET Total = (SELECT Adluts from OrderDetail where IdOrder = OrderTour.IdOrder) * (SELECT CostAdo from Tour where TourName = Tour)  + 
	(Select Childs from OrderDetail where IdOrder = OrderTour.IdOrder) * (SELECT CostChild from Tour where TourName = Tour)
	FROM OrderTour
	JOIN deleted ON OrderTour.IdOrder = deleted.IdOrder
end
go

drop trigger trg_HuyOrderTour
CREATE TRIGGER trg_HuyOrderTour ON OrderDetail After delete as 
begin 
	UPDATE OrderTour
	SET Total = 0 
	FROM OrderTour	
	JOIN deleted ON OrderTour.IdOrder = deleted.IdOrder
end
go

--Trigger Descriptions
CREATE TRIGGER trg_description ON DescriptionDetail  AFTER INSERT AS 
BEGIN
	UPDATE Descriptions
	SET Total = (SELECT SUM(Total) as SUM
	FROM DescriptionDetail
	WHERE IdDescription = Descriptions.IdDescription )
	FROM Descriptions
	JOIN inserted ON Descriptions.IdDescription = inserted.IdDescription
END

GO

CREATE TRIGGER trg_descriptionupdate ON DescriptionDetail AFTER UPDATE AS 
BEGIN
	UPDATE Descriptions
	SET Total = (SELECT SUM(Total) as SUM
	FROM DescriptionDetail
	WHERE IdDescription = Descriptions.IdDescription )
	FROM Descriptions
	JOIN deleted ON Descriptions.IdDescription = deleted.IdDescription
END


CREATE TRIGGER trg_descriptiondelete ON DescriptionDetail AFTER DELETE AS 
BEGIN
	UPDATE Descriptions
	SET Total = (SELECT SUM(Total) as SUM
	FROM DescriptionDetail
	WHERE IdDescription = Descriptions.IdDescription )
	FROM Descriptions
	JOIN deleted ON Descriptions.IdDescription = deleted.IdDescription
END



select * from Staff
select * from LocationStart
select * from Vehicle

select * from OrderDetail
Select * from OrderTour
Select * from Tour
Select * from Descriptions
select * from DescriptionDetail
select * from Tour

select Username from Client where IdClient = 3

update OrderDetail set Adluts = 20 , Childs = 30 where IdOrder = 9
delete OrderDetail where IdOrder = 9
update OrderTour set IsDeleted = 1 where IdOrder = 10



