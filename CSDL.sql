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
	IdAdmin char(10) not null primary key,
	Username varchar(50),
	Password varchar(50)
)
--drop table admin
--khách hàng
create table Client (
	IdClient char(10) not null primary key,
	FullName nvarchar(50),
	Address nvarchar(50),
	Phone varchar(50),
	Username varchar(50),
	Password varchar(50),
	Email varchar(50)
)
go

-- Đặt tour
create table Tour (
	IdTour char(10) not null primary key,
	DayStart Date,
	DayEnd Date,
	Description nvarchar(500),
	IdLocationStart char(10),
	IdLocationVisit char(10),
	Cost float,
	IdVehicle char(10)
)
go

--Staff
create table Staff (
	IdStaff char(10) not null primary key,
	IdAdmin char(10),
	FullName nvarchar(50),
	Username varchar(50),
	Password varchar(50)
)
go
--drop table Staff

create table OrderTour (
	IdOrder char(10) not null primary key,
	IdClient char(10),
	Total float
)
	go
create table OrderDetail(
		IdRadom char(10) not null primary key,
		IdOrder char(10),
		IdClient char(10),
		IdTour char(10),
		--Tong so nguoi
		Adluts int,
		Childs int
	)
go
--drop table OrderDetail
create table LocationStart(
	IdRandomStart char(10) not null primary key,
	Province nvarchar(50)
)
go
create table LocationVisit(
	IdRandomVisit char(10) not null primary key,
	VisitPlace nvarchar(50)
)
go
create table Vehicle(
	IdRandomVehicle char(10) not null primary key,
	Transport varchar(50),
	Capacity int 
)

go
create table OrderStatus(
	IdRandomStatus char(10) not null primary key,
	IdOrder char(10),
	Status varchar(50)
)
go
create table Trash(
	IdRandomTrash char(10) not null primary key,
	IdOrder char(10)
)
go

create table History(
	IdRandomHis char(10) not null primary key,
	IdOrder char(10) ,
	TimeOrder Date
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





