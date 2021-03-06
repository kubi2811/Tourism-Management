create database ManageOderAndShippingOnline
go

use ManageOderAndShippingOnline
go

-- Create Partner table
create table Partner (
	partnerId int identity(1,1) ,
	partnerName nvarchar(255),
	representativeName nvarchar(255),
	city nvarchar(255),
	district nvarchar(255),
	numberOfAgency int,
	numberOfOrdersPerDay int,
	addressBusiness nvarchar(255),
	telephoneNumber char(10),
	email varchar(255),
	taxcode varchar(255),
	primary key (partnerId)
);
go

-- Create PartnerAccount table
create table PartnerAccount (
	username varchar(20),
	password varchar(20),
	partnerId int,
	status bit
	primary key (username)
);
go

--Create Employee table
create table Employee(
	employeeId int identity(1,1),
	employeeName nvarchar(255),
	address nvarchar(255)
	primary key(employeeId)
);
go

--Create Employee table
create table EmployeeAccount(
	username varchar(20),
	password varchar(20),
	employeeId int,
	status bit
	primary key (username)
);
go

-- Create Contract table
create table Contract(
	contractId int identity(1,1),
	commissionPercentage float,
	taxCode varchar(255),
	numberOfRegisteredAgency int,
	representative nvarchar(255),
	employeeId int,
	partnerId int,
	startDate date,
	expireDate date,
	activation bit
	primary key(contractId)
);
go

-- Create Client table
create table Client(
	clientId int identity(1,1),
	fullName nvarchar(255),
	telephone varchar(255),
	email varchar(255)
	primary key(clientId)
);
go

-- Create ClientAccount table
create table ClientAccount (
	username varchar(20),
	password varchar(20),
	clientId int,
	status varchar(10)
	primary key (username)
);
go

-- Create Product table
create table Product(
	productId int identity(1,1),
	productName nvarchar(255)
	primary key(productId)
);
go

-- Create Order Product table
create table Orders(
	orderId int identity(1,1),
	partnerId int,
	clientId int,
	deliverId int,
	paymentType varchar(255),
	deliveryAddress nvarchar(255),
	status varchar(255),
	totalPrice int,
	orderDate datetime,
	confirm bit
	primary key (orderId),
	unique (orderId, deliverId)
);
go

-- Create Order Detail table
create table OrderDetail(
	productId int ,
	orderId int ,
	agencyId int,
	quantity int,
	totalPrice int
	primary key (productId, orderId)
)
go

-- Create Deliver table
create table Deliver(
	deliverId int identity(1,1),
	identityNumber int,
    deliverName nvarchar(255),
	address nvarchar(255),
	plateNumber nvarchar(255),
	telephone varchar(255),
	email varchar(255),
	bankAccount varchar(255),
	areaOfOperation nvarchar(255),
	primary key (DeliverId)
);
go

-- Create DeliverAccount table
create table DeliverAccount (
	username varchar(20),
	password varchar(20),
	deliverId int,
	status varchar(10)
	primary key (username)
);
go

-- Create Agency table
 create table Agency(
	agencyId int identity(1,1),
	partnerId int,
	agencyAddress nvarchar(255)
	primary key (agencyId)
)
go

-- Create AgencyProductDetail table
 create table AgencyProductDetail(
	agencyId int,
	productId int,
	value int
	primary key(agencyId,productId)
);
go

create table DeliverIncome (
	orderId int,
	deliverId int,
	amount int,
	time datetime
	primary key (orderId, deliverId)
);
go


alter table Contract
add constraint FK_Contract_Partner foreign key (partnerId) references Partner(partnerId)

alter table Orders
add constraint FK_Orders_Client foreign key (clientId) references Client(clientId)

alter table Orders
add constraint FK_Orders_Partner foreign key (partnerId) references Partner(partnerId)

alter table Orders
add constraint FK_Orders_Deliver foreign key (DeliverId) references Deliver(DeliverId)

alter table OrderDetail
add constraint FK_OrderDetail_Product foreign key (productId) references Product(productId)

alter table OrderDetail
add constraint FK_OrderDetail_Orders foreign key (orderId) references Orders(orderId)

alter table OrderDetail
add constraint FK_OrderDetail_AgencyProductDetail foreign key (agencyId, productId) references AgencyProductDetail(agencyId, productId)

alter table Agency
add constraint FK_Agency_Partner foreign key (partnerId) references Partner(partnerId)

alter table AgencyProductDetail
add constraint FK_AgencyProductDetail_Agency foreign key(agencyId) references Agency(agencyId)

alter table AgencyProductDetail
add constraint FK_AgencyProductDetail_Product foreign key (productId) references Product(productId)

alter table PartnerAccount
add constraint FK_PartnerAccount_Partner foreign key (partnerId) references Partner(partnerId)

alter table ClientAccount
add constraint FK_ClientAccount_Client foreign key (clientId) references Client(clientId)

alter table DeliverAccount
add constraint FK_DeliverAccount_Deliver foreign key (deliverId) references Deliver(deliverId)

alter table DeliverIncome
add constraint FK_DeliverIncome_Order foreign key (orderId, deliverId) references Orders(orderId, deliverId)

alter table Contract
add constraint Check_EndDate_Later_Than_StartDate check(expireDate >= startDate)

alter table Orders
add constraint Check_Status check(status = 'To pay' or status = 'To ship' or status = 'To receive' or status = 'Completed')

------------------------------------------------------------------------------------------------------------------

--Ph??n quy???n
create login employee with password = 'employee', check_policy = off;
go
create login partner with password = 'partner', check_policy = off;
go
create login client with password = 'client', check_policy = off;
go
create login deliver with password = 'deliver', check_policy = off;
go

create user employee for login employee
go
create user partner for login partner
go
create user client for login client
go
create user deliver for login deliver
go

create role employeeGroup
go
alter role employeeGroup add member employee
go
create role partnerGroup
go
alter role partnerGroup add member partner
go
create role clientGroup
go
alter role clientGroup add member client
go
create role deliverGroup
go
alter role deliverGroup add member deliver
go

grant select, insert, update on Contract to employeeGroup
go
grant select, insert, update, delete on Agency to partnerGroup
go
grant select, update on Orders to partnerGroup
go
grant select on Orders to clientGroup
go
grant select, update on Orders to deliverGroup
go

-----------------------------------------
--Trigger
create trigger OrderDetail_TotalOrderValue
on OrderDetail
after insert, update, delete
as
begin
	update Orders set Orders.totalPrice = (select SUM(totalPrice) from OrderDetail where Orders.orderId = OrderDetail.orderId group by orderId)
end
go

create trigger Product_TotalOrderValue
on Product
after insert, update, delete
as
begin
	update Orders set Orders.totalPrice = (select SUM(totalPrice) from OrderDetail where Orders.orderId = OrderDetail.orderId group by orderId)
end
go

create trigger OrderDetail_TotalProductValue
on OrderDetail
after insert, update, delete
as
begin
	select orderId, AgencyProductDetail.productId, AgencyProductDetail.agencyId, (AgencyProductDetail.value * OrderDetail.quantity) as totalPrice into #temp from (Product 
																																	inner join OrderDetail on Product.productId = OrderDetail.productId 
																																	inner join AgencyProductDetail on AgencyProductDetail.productId = OrderDetail.productId)
	update OrderDetail set totalPrice = (select totalPrice from #temp where OrderDetail.productId = #temp.productId and OrderDetail.agencyId = #temp.agencyId and OrderDetail.orderId = #temp.orderId)

	drop table #temp
end
go
create trigger Product_TotalProductValue
on Product
after insert, update, delete
as
begin
	select orderId, AgencyProductDetail.productId, AgencyProductDetail.agencyId, (AgencyProductDetail.value * OrderDetail.quantity) as totalPrice into #temp from (Product 
																																	inner join OrderDetail on Product.productId = OrderDetail.productId 
																																	inner join AgencyProductDetail on AgencyProductDetail.productId = OrderDetail.productId)

	update OrderDetail set totalPrice = (select totalPrice from #temp where OrderDetail.productId = #temp.productId and OrderDetail.agencyId = #temp.agencyId and OrderDetail.orderId = #temp.orderId)

	drop table #temp
end
go

create trigger Orders_AverageNumberOfOrdersPerDay
on Orders
after insert, update, delete
as
begin
	select partnerId, cast(orderDate as date) as time, count(*) as numberOfOrders into #EveryDayOrders from Orders group by partnerId, cast(orderDate as date)
	select partnerId, AVG(numberOfOrders) as avgOrderPerDay into #OrderPerDay from #EveryDayOrders group by partnerId

	update Partner
	set numberOfOrdersPerDay = (select avgOrderPerDay from #OrderPerDay
								where Partner.partnerId = #OrderPerDay.partnerId)

	drop table #EveryDayOrders
	drop table #OrderPerDay
end
go

------------------------------------------------------------------------------------------------
------ INSERT DATA TO DATABASE
insert into Partner (partnerName, representativeName, city, district, numberOfAgency, addressBusiness, telephoneNumber, email, taxcode)
values
	(N'V???n chuy???n ABC', N'L?? Ho??i An', N'H??? Ch?? Minh', N'Qu???n 5', 3, N'202 Tr???n H??ng ?????o','0898902112', 'abc@abc.com','020220118412'),
    (N'Giao h??ng nhanh', N'Tr???n V??n Minh', N'H??? Ch?? Minh', N'Qu???n 1', 4, N'355 Nguy???n Ch?? Thanh','0568900122', 'ghn@gmail.com','045734557843'),
    (N'V???n chuy???n si??u t???c', N'Ho??ng Ly Ly', N'H?? N???i', N'Qu???n T??? Li??m', 2, N'112 L?? L???i','0608711558', 'delivery@sieutoc.com.vn','124687654877'),
    (N'Giao h??ng ho??? t???c', N'Ph??ng V??n T??n', N'???? N???ng', N'Qu???n H???i Ch??u', 3, N'98 Ho??ng V??n Th???','0658515044', 'giaohanghoatoc@gmail.com','023544435643');
go

insert into Contract(numberOfRegisteredAgency, representative, partnerId, startDate, expireDate, taxcode, commissionPercentage, activation)
values
	(3, N'H?? T??n Quy???n', 1,'2022/1/1', '2022/12/31','020220118412',10, 1),
    (4, N'Nguy???n V??n A', 2,'2020/5/20', '2022/11/20','045734557843',10, 1),
    (2, N'Ph???m Th??? B???y', 3, '2021/6/1', '2023/6/1','124687654877', 10, 1),
    (3, N'L??u H???ng ??n', 4, '2021/12/12', '2024/6/12','023544435643',10, 1);
go
select * from Contract


insert into Client(fullName, telephone, email)
values
	(N'Tr???n Minh T??m', '0916500202', 'tmtam@gmail.com'),
    (N'L??u Tuy???t Nhi', '0956667543', 'trantuyetnhi123@gmail.com'),
    (N'Ph??ng V??n T??n', '0234567665', 'tintin35@yahoo.com'),
    (N'Nguy???n Ho??ng Minh', '0909548332', 'hoangminhnguyen222@gmail.com'),
    (N'La Tr?? Trung', '0378828394', 'trungtrila394@outlook.com');
go
select * from Client


insert into Product (productName)
values
	(N'B??ng Lan Cam'),
    (N'M?? ??n li???n ABC'),
    (N'B???t gi???t Omo'),
    (N'Kem ????nh r??ng PS'),
    (N'Kem ???c qu??? s???u ri??ng'),
    (N'Ch??o ??n li???n');
go
select * from Product


insert into Deliver (identityNumber, deliverName, address, plateNumber, telephone, email, bankAccount, areaOfOperation)
values
	(113578, N'B???o Kh??nh',N'551 L???c Long Qu??n, Qu???n 11', '59Y2-12345', '09623453', 'hai@gmail.com', '1123453 VCB', N'Qu???n 3'),
    (122467, N'L?? Th??? L???u', N'21 ??u L???c, Qu???n 8', '79Y2-70000', '03477878', 'lethiluu@gmail.com', '64566445 SCB', N'Qu???n 5'),
	(553442, N'Nguy???n Ph????ng Trang', N'1009 Tr???n Ph??, Qu???n Ba ????nh', '15Z4-66457', '033266647', 'phuongtrang@gmail.com', '5553356 VCB', N'Qu???n Ph?? Nhu???n'),
    (157678, N'L?? Th??nh B?????i', N'345 H??? G????m, Qu???n C???m L???', '39B5-70576', '07976050', 'thanhbuoi@gmail.com', '3443255433 MB', N'Qu???n Qu???n 5');
go
select * from Deliver

insert into Orders (clientId, deliverId, partnerId, paymentType, deliveryAddress, status, confirm, orderDate)
values
	(1, 1, 1, N'COD', N'123 Nguy???n Ki???m, Qu???n Ph?? Nhu???n', 'to Pay', 1, cast('20220318 10:34:09' as datetime)),
    (2, 2, 1, N'COD', N'223 Ho??ng Di???u, Qu???n 4', 'to Receive', 1, cast('20220318 14:04:29' as datetime)),
	(3, 3, 1, N'credit', N'735 Tr???n Ph??, Qu???n 5', 'to Pay', 1, cast('20220312 09:24:19' as datetime)),
	(4, 3, 1, N'credit', N'735 Tr???n Ph??, Qu???n 5', 'to Pay', 1, cast('20220314 10:20:00' as datetime)),
    (3, 3, 2, N'credit', N'735 Tr???n Ph??, Qu???n 5', 'to Pay', 1, cast('20220210 09:24:19' as datetime)),
    (4, 1, 3, N'COD', N'67 Ph???m V??n Hai, Qu???n 3', 'to Ship', 1, cast('20220210 11:10:40' as datetime)),
    (5, 4, 4, N'Credit', N'79 Tr???n V??n ??ang, Qu???n 3', 'to Pay', 1, cast('20220312 12:04:10' as datetime));
go
select * from Partner

insert into Agency (partnerId, agencyAddress)
values
	(1, N'7 L?? Lai, Qu???n 1'),
    (1, N'2 Tr???n B??nh Tr???ng, Qu???n 5'),
    (1, N'12 Minh Ph???ng, Qu???n 11'),
    (2, N'78 H??n H???i Nguy??n Qu???n 11'),
    (2, N'50 Phan ????ng L??u Qu???n B??nh Th???nh'),
    (2, N'40 Ph??? ????, Qu???n T??? Li??m'),
    (2, N'40 H??ng Tre, Qu???n ?????ng ??a'),
    (3, N'40 H??ng Tranh, Qu???n Ho??ng Mai'),
    (3, N'56 ????? Th??m, Qu???n C???m L???'),
    (4, N'123 Ho??ng S??n, Qu???n H???i Ch??u'),
    (4, N'355 Nguy???n Hu???, Qu???n Ng?? H??nh S??n'),
	(4, N'245 Tr???n H??ng ?????o')
go

select * from Agency

insert into AgencyProductDetail(productId, agencyId, value)
values
	(1, 1, 50000),
	(2, 2, 10000),
	(3, 3, 20000),
	(1, 4, 40000),
	(2, 5, 15000),
	(3, 6, 30000),
	(4, 7, 20000),
	(5, 8, 5000),
	(6, 9, 30000),
	(1, 10, 35000),
	(3, 11, 25000),
	(5, 12, 10000)
go
select * from AgencyProductDetail
go
insert into OrderDetail(productId, orderId, agencyId, quantity)
values	(1, 1, 1, 4),
		(2, 1, 2, 2),
		(2, 2, 5, 3)
go
select * from OrderDetail
go
select * from Orders
go
select * from DeliverIncome
go

--Stored procedure

--Nh??n vi??n ????ng k?? t??i kho???n
create procedure EmployeeSignUp	@username varchar(20),
								@password varchar(20),
								@employeeName nvarchar(255),
								@address nvarchar(255)
as
insert into Employee (employeeName, address)
values (@employeeName, @address)

declare @employeeId int
set @employeeId = @@IDENTITY

insert into EmployeeAccount(username, password, status)
values (@username, @password, 1)
go

--Nh??n vi??n ????ng nh???p
create procedure EmployeeSignIn @username varchar(20), @password varchar(20)
as
select employeeId from EmployeeAccount
where @username = username and @password = password
go

--Nh??n vi??n xem danh s??ch h???p ?????ng ch??a ???????c duy???t ????? ti???p nh???n v?? x??? l??
create procedure EmployeeSelectContract
as
select * from Contract where employeeId = null
go

--Nh??n vi??n x??c nh???n h???p ?????ng
create procedure EmployeeActivateContract @contractId int, @employeeId int
as
update Contract
set activation = 1,
	employeeId = @employeeId
where contractId = @contractId
go

--Nh??n vi??n gia h???n h???p ?????ng cho ?????i t??c
create procedure EmployeeReActivateContract @contractId int, @employeeId int, @commissionPercentage int, @expireDate date
as
update Contract
set commissionPercentage = @commissionPercentage,
	expireDate = @expireDate
where contractId = @contractId and employeeId = @employeeId
go

--?????i t??c ????ng k?? t??i kho???n - partner
create procedure PartnerSignUp	@username varchar(20), 
								@password varchar(20),
								@partnerName nvarchar(255),
								@representativeName nvarchar(255),
								@city nvarchar(255),
								@district nvarchar(255),
								@numberOfAgency int,
								@numberOfOrdersPerDay int,
								@addressBusiness nvarchar(255),
								@telephoneNumber char(15),
								@email varchar(255),
								@taxcode varchar(255)
as
insert into Partner (partnerName, representativeName, city, district, numberOfAgency, numberOfOrdersPerDay, addressBusiness, telephoneNumber, email, taxcode)
values (@partnerName, @representativeName, @city, @district, @numberOfAgency, @numberOfOrdersPerDay, @addressBusiness, @telephoneNumber, @email, @taxcode)

declare @partnerId int
set @partnerId = @@IDENTITY

insert into PartnerAccount(username, password, status, partnerId)
values (@username, @password, 1, @partnerId)

go

--?????i t??c ????ng nh???p
create procedure PartnerSignIn @username varchar(20), @password varchar(20)
as
select partnerId from PartnerAccount
where @username = username and @password = password
go

--?????i t??c t???o h???p ?????ng
create procedure PartnerCreateContract @taxcode varchar(20), @numberOfRegisteredAgency int, @representative nvarchar(255), @partnerId int, @startDate date, @expireDate date
as
insert into Contract (commissionPercentage, taxCode, numberOfRegisteredAgency, representative, partnerId, startDate, expireDate, activation)
values (10, @taxcode, @numberOfRegisteredAgency, @representative, @partnerId, @startDate, @expireDate, 0)
go

--?????i t??c th??m chi nh??nh
create procedure AddAgency @partnerId int, @agencyAddress nvarchar(255)
as
	insert into Agency(partnerId, agencyAddress)
	values (@partnerId, @agencyAddress)

	update Contract
	set numberOfRegisteredAgency = numberOfRegisteredAgency + 1
	where partnerId = @partnerId
go

--Kh??ch h??ng ????ng k?? t??i kho???n
create procedure ClientSignUp	@fullName nvarchar(255),
								@telephone varchar(255),
								@email varchar(255),
								@username varchar(20), 
								@password varchar(20),
								@status varchar(10)
as
insert into Client (fullName, telephone, email)
values (@fullName, @telephone, @email)

declare @clientId int
set @clientId = @@IDENTITY

insert into ClientAccount (username, password, status, clientId)
values (@username, @password, @status, @clientId)

go

--Kh??ch h??ng ????ng nh???p
create procedure ClientSignIn @username varchar(20), @password varchar(20)
as
select clientId from ClientAccount
where @username = username and @password = password
go

--T??i x??? ????ng k?? t??i kho???n
create procedure DeliverSignUp	@username varchar(20),
								@password varchar(20),
								@status varchar(10),
								@identityNumber int,
								@deliverName nvarchar(255),
								@address nvarchar(255),
								@plateNumber nvarchar(255),
								@telephone varchar(255),
								@email varchar(255),
								@bankAccount varchar(255),
								@areaOfOperation nvarchar(255)
as
insert into Deliver(identityNumber, deliverName, address, plateNumber, telephone, email, bankAccount, areaOfOperation)
values (@identityNumber, @deliverName, @address, @plateNumber, @telephone, @email, @bankAccount, @areaOfOperation)

declare @deliverId int
set @deliverId = @@IDENTITY

insert into DeliverAccount(username, password, status, deliverId)
values (@username, @password, @status, @deliverId)
go

--T??i x??? ????ng nh???p
create procedure DeliverSignIn @username varchar(20), @password varchar(20)
as
select deliverId from DeliverAccount
where @username = username and @password = password
go

--Kh??ch h??ng ?????t h??ng
--Xem danh s??ch ?????i t??c
create procedure FindPartner
as
select Partner.partnerId, partnerName, representativeName, city, district, numberOfAgency, addressBusiness, telephoneNumber, email from partner
left join Contract on Partner.partnerId = Contract.partnerId
where Contract.activation = 1;
go
--Ch???n ?????i t??c
create procedure SelectPartner @partnerName nvarchar(255)
as
select partnerId from Partner where partnerName = @partnerName
go
--Xem c??c s???n ph???m c???a ?????i t??c ???? ch???n
create procedure FindProductOfPartner @partnerId int
as

select Agency.agencyId, Agency.agencyAddress, AgencyProductDetail.productId, Product.productName, value
from Agency
left join Partner
on Agency.partnerId = Partner.partnerId
left join AgencyProductDetail
on Agency.agencyId = AgencyProductDetail.agencyId
left join Product
on AgencyProductDetail.productId = Product.productId
where Partner.partnerId = @partnerId

go
--T???o ????n h??ng
create procedure CreateOrder @clientId int, @partnerId int, @paymentType varchar(20), @deliveryAddress varchar(20)
as
insert into Orders (clientId, partnerId, paymentType, deliveryAddress, orderDate, confirm)
values (@clientId, @partnerId, @paymentType, @deliveryAddress, GETDATE(), 0)

declare @orderId int
set @orderId = @@IDENTITY

--insert into OrderDetail(orderId)
--values (@orderId)

select @orderId
go

--Th??m h??ng v??o ????n h??ng
create procedure AddProduct @orderId int, @productId int, @agencyId int, @quantity int
as

update OrderDetail
set productId = @productId, agencyId = @agencyId, quantity = @quantity
where orderId = @orderId

go

--X??a h??ng kh???i gi??? h??ng
create procedure RemoveProduct @orderId int, @productId int, @agencyId int
as
delete from OrderDetail where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--Gi???m s??? l?????ng h??ng trong gi???
create procedure DecreaseProductQuantity @orderId int, @productId int, @agencyId int, @quantity int
as
update OrderDetail
set quantity = quantity - @quantity
where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--T??ng s??? l?????ng h??ng trong gi???
create procedure IncreaseProductQuantity @orderId int, @productId int, @agencyId int, @quantity int
as
update OrderDetail
set quantity = quantity + @quantity
where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--X??c nh???n ????n h??ng
create procedure ClientAcceptOrder @orderId int
as
update Orders
set confirm = 1
where orderId = @orderId
go

--T??i x??? xem danh s??ch ????n h??ng
create procedure DeliverFindOrders @deliverId int
as
select * from Orders
where deliveryAddress like '%' + (select areaOfOperation from Deliver where deliverId = @deliverId) and status like '%' + 'To ship'
go

--T??i x??? nh???n ????n h??ng
create procedure DeliverAcceptOrder @orderId int, @deliverId int
as
update Orders
set deliverId = @deliverId
where orderId = @orderId
go

--Kh??ch h??ng theo d??i ????n h??ng
create procedure ClientOrderTracking @clientId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where clientId = @clientId
go

--?????i t??c theo d??i ????n h??ng
create procedure PartnerOrderTracking @partnerId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where partnerId = @partnerId and confirm = 1
go

--?????i t??c c???p nh???t ????n h??ng
create procedure PartnerReceiveOrder @orderId int
as
	if (select confirm from Orders where orderId = @orderId) = 1
		update Orders
		set status = 'To confirm'
		where orderId = @orderId;
go

create procedure PartnerWaitingToDeliver @orderId int
as
	if (select status from Orders where orderId = @orderId) like 'To pay'
		update Orders
		set status = 'To ship'
		where orderId = @orderId;
go

--T??i x??? theo d??i ????n h??ng
create procedure DeliverOrderTracking @deliverId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where deliverId = @deliverId
go

--T??i x??? c???p nh???t ????n h??ng
create procedure DeliverDelivering @orderId int
as
	if (select status from Orders where orderId = @orderId) like 'To ship'
		update Orders
		set status = 'To receive'
		where orderId = @orderId
go

--Kh??ch h??ng x??c nh???n ????n h??ng ???? giao th??nh c??ng
create procedure DeliverSuccessfully @orderId int
as
	if (select status from Orders where orderId = @orderId) like 'To receive'
		update Orders
		set status = 'Completed'
		where orderId = @orderId

		declare @deliverId int = (select deliverId from Orders where orderId = @orderId)
		insert into DeliverIncome(orderId, deliverId, amount, time)
		values (@orderId, @deliverId, 25000, GETDATE())
go

--T??i x??? xem thu nh???p c???a m??nh
create procedure DeliverPersonalIncome @deliverId int
as
	select time, amount from DeliverIncome where deliverId = @deliverId
go

---------------------------------------------------------------------------------------------
--use master
--go
--drop database ManageOderAndShippingOnline
--go
