create database ManageTourist
go

use ManageTourist
go


--use master 
--go
----------------------drop database ManageTourist
--go


--admin
create table Admin(
	IdAdmin INT IDENTITY(1,1) primary key,
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL
)
--drop table admin

--Staff
create table Staff (
	IdStaff INT IDENTITY(1,1) primary key,
	IdAdmin int NOT NULL,
	FullName nvarchar(50),
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL
)
go
--drop table Staff

--khách hàng
create table Client (
	IdClient INT IDENTITY(1,1) primary key,
	FullName nvarchar(50),
	Address nvarchar(50),
	Phone varchar(50) UNIQUE,
	Username varchar(50) UNIQUE,
	Password varchar(50) NOT NULL,
	Email varchar(50)
)
go

-- Đặt tour
create table Tour (
	IdTour INT IDENTITY(1,1) primary key,
	TourName nvarchar(50) UNIQUE,
	DayStart Date,
	DayEnd Date,
	Cost float,
)
go

create table Description (
	
	IdDescription INT IDENTITY(1,1) primary key,
	Tour nvarchar(50) foreign key references Tour(TourName),
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
	Total float
)
	go
create table OrderDetail(
		IdOrderDetail INT IDENTITY(1,1) primary key,
		IdOrder int,
		IdClient int,
		IdTour int,
		--Tong so nguoi
		Adluts int NOT NULL,
		Childs int NOT NULL
	)
go
--drop table OrderDetail
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
	Tour nvarchar(50) FOREIGN KEY REFERENCES Tour(TourName), -- Lấy tour name từ bảng tour
	Transport varchar(50) NOT NULL,
	Capacity int NOT NULL
)

go
create table OrderStatus(
	IdOrderStatus INT IDENTITY(1,1) primary key,
	IdOrder int,
	Status varchar(50)
)
go
create table Trash(
	IdTrash INT IDENTITY(1,1) primary key,
	IdOrder int 
)
go

create table History(
	IdHistory INT IDENTITY(1,1) primary key,
	IdOrder int,
	TimeOrder datetime FOREIGN KEY REFERENCES OrderTour(createDate)
)


go
alter table Staff
add foreign key(IdAdmin) references Admin(IdAdmin)
go
alter table Tour
add foreign key(IdLocationStart) references LocationStart(IdRandomStart)
go
alter table Tour
add foreign key(IdLocationVisit) references LocationVisit(IdRandomVisit)
go
alter table OrderTour
add foreign key(IdClient) references Client(IdClient)
go
alter table OrderDetail
add foreign key(IdOrder) references OrderTour(IdOrder)
go
alter table OrderDetail
add foreign key(IdTour) references Tour(IdTour)
go
alter table OrderStatus
add foreign key(IdOrder) references OrderTour(IdOrder)
go
alter table Trash
add foreign key(IdOrder) references OrderTour(IdOrder)
go
alter table History
add foreign key(IdOrder) references OrderTour(IdOrder)
go
alter table Tour
add foreign key(IdVehicle) references Vehicle(IdRandomVehicle)





