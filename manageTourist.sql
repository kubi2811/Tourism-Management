create database ManageTourist
go

use ManageTourist
go


--use master 
--go
--drop database ManageTourist
--go

--khách hàng
create table Client (
	IdClient char(10) not null primary key,
	Firstname nvarchar(50),
	Lastname nvarchar(50),
	Address nvarchar(50),
	NumPerson varchar(50),
	PhoneNumber varchar(50),
	Username varchar(50),
	Password varchar(50)
)
go

-- Đặt tour
create table OrderTour (
	IdOrder char(10),
	IdClient char(10),
	NameOrder nvarchar(50),
	CounterPerson int,
	InforTour varchar (max),
	Transport varchar(50),
	TotalMoney float,
	primary key(IdOrder)
)
go

-- Chi tiết chuyến đi
create table OrderDetail (
	IdOrderDetail char(10),
	IdOrder char(10),
	Tour varchar(max),
	Adults int,
	Children int,
	Room int,
	Times date,
	CountDay int,
	IdLocation int,
	primary key (IdOrderDetail)
)
go

-- Địa điểm
create table Location (
	IdLocation int,
	nameLocation nvarchar(50),
	primary key (IdLocation),
)
go

-- Tình trạng chuyến đi
create table StatusTour (
	IdStatusTour char(10),
	IdOrder char(10),
	Status varchar(10),
	Note varchar(max)
	primary key(IdStatusTour, IdOrder)
)
go

-- Admin
create table Admin (
	IdAdmin char(10),
	Username varchar(50),
	Password varchar(50),
	primary key (IdAdmin)
)
go

--Staff
create table Staff (
	IdStaff char(10),
	IdAdmin char(10),
	Firstname nvarchar(50),
	Lastname nvarchar(50),
	Username varchar(50),
	Password varchar(50),
	primary key (IdStaff)
)
go


alter table OrderTour
add foreign key(IdClient) references Client(IdClient)

alter table OrderDetail
add foreign key (IdOrder) references OrderTour (IdOrder)

alter table OrderDetail
add foreign key (IdLocation) references Location(IdLocation)

alter table StatusTour
add foreign key (IdOrder) references Ordertour(IdOrder)

alter table Staff
add foreign key (IdAdmin) references Admin(IdAdmin)