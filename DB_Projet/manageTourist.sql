create database ManageTourist
go

use ManageTourist
go


--use master 
--go
--drop database ManageTourist
--go

-- Admin
create table Admin (
	IdAdmin INT IDENTITY(1,1) primary key,
	Username varchar(50),
	Password varchar(50),
)
go

--Staff
create table Staff (
	IdStaff INT IDENTITY(1,1) primary key,
	IdAdmin int, 
	Firstname nvarchar(50),
	Lastname nvarchar(50),
	Username varchar(50),
	Password varchar(50),
)
go

--khách hàng
create table Client (
	IdClient INT IDENTITY(1,1) primary key,
	Firstname nvarchar(50),
	Lastname nvarchar(50),
	Address nvarchar(50),
	NumPerson varchar(50),
	PhoneNumber varchar(50),
	Username varchar(50),
	Password varchar(50)
)
go


-- Thông tin tour
create table Tour ( 
)


-- Đặt tour
create table OrderTour (
	IdOrder INT IDENTITY(1,1) primary key,
	IdClient int,
	NameOrder nvarchar(50),
	CounterPerson int,
	InforTour varchar (max),
	Transport varchar(50),
	TotalMoney float,
)
go

-- Chi tiết chuyến đi
create table OrderDetail (
	IdOrderDetail INT IDENTITY(1,1) primary key,
	IdOrder int,
	Tour varchar(max),
	Adults int,
	Children int,
	Room int,
	Times date,
	CountDay int,
	IdLocation int,
	
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
	IdStatusTour INT IDENTITY(1,1) primary key,
	IdOrder int,
	Status varchar(10),
	Note varchar(max)
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