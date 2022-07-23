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

--Phân quyền
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
	(N'Vận chuyển ABC', N'Lý Hoài An', N'Hồ Chí Minh', N'Quận 5', 3, N'202 Trần Hưng Đạo','0898902112', 'abc@abc.com','020220118412'),
    (N'Giao hàng nhanh', N'Trần Văn Minh', N'Hồ Chí Minh', N'Quận 1', 4, N'355 Nguyễn Chí Thanh','0568900122', 'ghn@gmail.com','045734557843'),
    (N'Vận chuyển siêu tốc', N'Hoàng Ly Ly', N'Hà Nội', N'Quận Từ Liêm', 2, N'112 Lê Lợi','0608711558', 'delivery@sieutoc.com.vn','124687654877'),
    (N'Giao hàng hoả tốc', N'Phùng Văn Tín', N'Đà Nẵng', N'Quận Hải Châu', 3, N'98 Hoàng Văn Thụ','0658515044', 'giaohanghoatoc@gmail.com','023544435643');
go

insert into Contract(numberOfRegisteredAgency, representative, partnerId, startDate, expireDate, taxcode, commissionPercentage, activation)
values
	(3, N'Hà Tôn Quyền', 1,'2022/1/1', '2022/12/31','020220118412',10, 1),
    (4, N'Nguyễn Văn A', 2,'2020/5/20', '2022/11/20','045734557843',10, 1),
    (2, N'Phạm Thị Bảy', 3, '2021/6/1', '2023/6/1','124687654877', 10, 1),
    (3, N'Lưu Hồng Ân', 4, '2021/12/12', '2024/6/12','023544435643',10, 1);
go
select * from Contract


insert into Client(fullName, telephone, email)
values
	(N'Trần Minh Tâm', '0916500202', 'tmtam@gmail.com'),
    (N'Lưu Tuyết Nhi', '0956667543', 'trantuyetnhi123@gmail.com'),
    (N'Phùng Văn Tín', '0234567665', 'tintin35@yahoo.com'),
    (N'Nguyễn Hoàng Minh', '0909548332', 'hoangminhnguyen222@gmail.com'),
    (N'La Trí Trung', '0378828394', 'trungtrila394@outlook.com');
go
select * from Client


insert into Product (productName)
values
	(N'Bông Lan Cam'),
    (N'Mì ăn liền ABC'),
    (N'Bột giặt Omo'),
    (N'Kem đánh răng PS'),
    (N'Kem ốc quế sầu riêng'),
    (N'Cháo ăn liền');
go
select * from Product


insert into Deliver (identityNumber, deliverName, address, plateNumber, telephone, email, bankAccount, areaOfOperation)
values
	(113578, N'Bảo Khánh',N'551 Lạc Long Quân, Quận 11', '59Y2-12345', '09623453', 'hai@gmail.com', '1123453 VCB', N'Quận 3'),
    (122467, N'Lê Thị Lựu', N'21 Âu Lạc, Quận 8', '79Y2-70000', '03477878', 'lethiluu@gmail.com', '64566445 SCB', N'Quận 5'),
	(553442, N'Nguyễn Phương Trang', N'1009 Trần Phú, Quận Ba Đình', '15Z4-66457', '033266647', 'phuongtrang@gmail.com', '5553356 VCB', N'Quận Phú Nhuận'),
    (157678, N'Lê Thành Bưởi', N'345 Hồ Gươm, Quận Cẩm Lệ', '39B5-70576', '07976050', 'thanhbuoi@gmail.com', '3443255433 MB', N'Quận Quận 5');
go
select * from Deliver

insert into Orders (clientId, deliverId, partnerId, paymentType, deliveryAddress, status, confirm, orderDate)
values
	(1, 1, 1, N'COD', N'123 Nguyễn Kiệm, Quận Phú Nhuận', 'to Pay', 1, cast('20220318 10:34:09' as datetime)),
    (2, 2, 1, N'COD', N'223 Hoàng Diệu, Quận 4', 'to Receive', 1, cast('20220318 14:04:29' as datetime)),
	(3, 3, 1, N'credit', N'735 Trần Phú, Quận 5', 'to Pay', 1, cast('20220312 09:24:19' as datetime)),
	(4, 3, 1, N'credit', N'735 Trần Phú, Quận 5', 'to Pay', 1, cast('20220314 10:20:00' as datetime)),
    (3, 3, 2, N'credit', N'735 Trần Phú, Quận 5', 'to Pay', 1, cast('20220210 09:24:19' as datetime)),
    (4, 1, 3, N'COD', N'67 Phạm Văn Hai, Quận 3', 'to Ship', 1, cast('20220210 11:10:40' as datetime)),
    (5, 4, 4, N'Credit', N'79 Trần Văn Đang, Quận 3', 'to Pay', 1, cast('20220312 12:04:10' as datetime));
go
select * from Partner

insert into Agency (partnerId, agencyAddress)
values
	(1, N'7 Lê Lai, Quận 1'),
    (1, N'2 Trần Bình Trọng, Quận 5'),
    (1, N'12 Minh Phụng, Quận 11'),
    (2, N'78 Hàn Hải Nguyên Quận 11'),
    (2, N'50 Phan Đăng Lưu Quận Bình Thạnh'),
    (2, N'40 Phố Đá, Quận Từ Liêm'),
    (2, N'40 Hàng Tre, Quận Đống Đa'),
    (3, N'40 Hàng Tranh, Quận Hoàng Mai'),
    (3, N'56 Đề Thám, Quận Cẩm Lệ'),
    (4, N'123 Hoàng Sơn, Quận Hải Châu'),
    (4, N'355 Nguyễn Huệ, Quận Ngũ Hành Sơn'),
	(4, N'245 Trần Hưng Đạo')
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

--Nhân viên đăng ký tài khoản
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

--Nhân viên đăng nhập
create procedure EmployeeSignIn @username varchar(20), @password varchar(20)
as
select employeeId from EmployeeAccount
where @username = username and @password = password
go

--Nhân viên xem danh sách hợp đồng chưa được duyệt để tiếp nhận và xử lý
create procedure EmployeeSelectContract
as
select * from Contract where employeeId = null
go

--Nhân viên xác nhận hợp đồng
create procedure EmployeeActivateContract @contractId int, @employeeId int
as
update Contract
set activation = 1,
	employeeId = @employeeId
where contractId = @contractId
go

--Nhân viên gia hạn hợp đồng cho đối tác
create procedure EmployeeReActivateContract @contractId int, @employeeId int, @commissionPercentage int, @expireDate date
as
update Contract
set commissionPercentage = @commissionPercentage,
	expireDate = @expireDate
where contractId = @contractId and employeeId = @employeeId
go

--Đối tác đăng ký tài khoản - partner
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

--Đối tác đăng nhập
create procedure PartnerSignIn @username varchar(20), @password varchar(20)
as
select partnerId from PartnerAccount
where @username = username and @password = password
go

--Đối tác tạo hợp đồng
create procedure PartnerCreateContract @taxcode varchar(20), @numberOfRegisteredAgency int, @representative nvarchar(255), @partnerId int, @startDate date, @expireDate date
as
insert into Contract (commissionPercentage, taxCode, numberOfRegisteredAgency, representative, partnerId, startDate, expireDate, activation)
values (10, @taxcode, @numberOfRegisteredAgency, @representative, @partnerId, @startDate, @expireDate, 0)
go

--Đối tác thêm chi nhánh
create procedure AddAgency @partnerId int, @agencyAddress nvarchar(255)
as
	insert into Agency(partnerId, agencyAddress)
	values (@partnerId, @agencyAddress)

	update Contract
	set numberOfRegisteredAgency = numberOfRegisteredAgency + 1
	where partnerId = @partnerId
go

--Khách hàng đăng ký tài khoản
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

--Khách hàng đăng nhập
create procedure ClientSignIn @username varchar(20), @password varchar(20)
as
select clientId from ClientAccount
where @username = username and @password = password
go

--Tài xế đăng ký tài khoản
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

--Tài xế đăng nhập
create procedure DeliverSignIn @username varchar(20), @password varchar(20)
as
select deliverId from DeliverAccount
where @username = username and @password = password
go

--Khách hàng đặt hàng
--Xem danh sách đối tác
create procedure FindPartner
as
select Partner.partnerId, partnerName, representativeName, city, district, numberOfAgency, addressBusiness, telephoneNumber, email from partner
left join Contract on Partner.partnerId = Contract.partnerId
where Contract.activation = 1;
go
--Chọn đối tác
create procedure SelectPartner @partnerName nvarchar(255)
as
select partnerId from Partner where partnerName = @partnerName
go
--Xem các sản phẩm của đối tác đã chọn
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
--Tạo đơn hàng
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

--Thêm hàng vào đơn hàng
create procedure AddProduct @orderId int, @productId int, @agencyId int, @quantity int
as

update OrderDetail
set productId = @productId, agencyId = @agencyId, quantity = @quantity
where orderId = @orderId

go

--Xóa hàng khỏi giỏ hàng
create procedure RemoveProduct @orderId int, @productId int, @agencyId int
as
delete from OrderDetail where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--Giảm số lượng hàng trong giỏ
create procedure DecreaseProductQuantity @orderId int, @productId int, @agencyId int, @quantity int
as
update OrderDetail
set quantity = quantity - @quantity
where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--Tăng số lượng hàng trong giỏ
create procedure IncreaseProductQuantity @orderId int, @productId int, @agencyId int, @quantity int
as
update OrderDetail
set quantity = quantity + @quantity
where orderId = @orderId and productId = @productId and agencyId = @agencyId
go

--Xác nhận đơn hàng
create procedure ClientAcceptOrder @orderId int
as
update Orders
set confirm = 1
where orderId = @orderId
go

--Tài xế xem danh sách đơn hàng
create procedure DeliverFindOrders @deliverId int
as
select * from Orders
where deliveryAddress like '%' + (select areaOfOperation from Deliver where deliverId = @deliverId) and status like '%' + 'To ship'
go

--Tài xế nhận đơn hàng
create procedure DeliverAcceptOrder @orderId int, @deliverId int
as
update Orders
set deliverId = @deliverId
where orderId = @orderId
go

--Khách hàng theo dõi đơn hàng
create procedure ClientOrderTracking @clientId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where clientId = @clientId
go

--Đối tác theo dõi đơn hàng
create procedure PartnerOrderTracking @partnerId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where partnerId = @partnerId and confirm = 1
go

--Đối tác cập nhật đơn hàng
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

--Tài xế theo dõi đơn hàng
create procedure DeliverOrderTracking @deliverId int
as
select paymentType, deliveryAddress, status, totalPrice from Orders
where deliverId = @deliverId
go

--Tài xế cập nhật đơn hàng
create procedure DeliverDelivering @orderId int
as
	if (select status from Orders where orderId = @orderId) like 'To ship'
		update Orders
		set status = 'To receive'
		where orderId = @orderId
go

--Khách hàng xác nhận đơn hàng đã giao thành công
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

--Tài xế xem thu nhập của mình
create procedure DeliverPersonalIncome @deliverId int
as
	select time, amount from DeliverIncome where deliverId = @deliverId
go

---------------------------------------------------------------------------------------------
--use master
--go
--drop database ManageOderAndShippingOnline
--go
