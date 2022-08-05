use ManageTourist
go

-- insert Admin

insert into Admin values ('minh-duonq', '123')

-- insert Staff 

insert into Staff values ('minh-duonq', 'Lê Trung Hiếu', 'hieu-lt', '123')

-- insert Client

insert into Client values ('Nguyễn Gia Minh', '0888399622', 'minh-ng', '123','giaminh@gmail.com')
insert into Client values ('Hiếu Lê', '0888399623', 'hieu-le', '123','hieul@gmail.com')

-- insert Address

insert into UserAddress values ('minh-ng', 2, 'Le Loi', 'Phuong 1', 'Quan 1', 'HCMC')
insert into UserAddress values ('minh-ng', 2, 'Le Duan', 'Phuong 1', 'Quan 1', 'HCMC')

-- insert Tour
insert into Tour values ('HN-HCM', '2022-07-10', '2022-07-13', 100000)
insert into Tour values ('Hà Nội - Hải Phòng', '2022-07-10', '2022-07-13', 100000)
insert into Tour values ('Hà Nội - Yên Bái', '2022-07-10', '2022-07-13', 200000)
insert into Tour values ('Hồ Chí Minh - Nha Trang', '2022-07-10', '2022-07-13', 1100000)
insert into Tour values ('Hồ Chí Minh - Phú Quốc', '2022-07-10', '2022-07-13', 2100000)
insert into Tour values ('Hồ Chí Minh - Phan Thiết ', '2022-07-10', '2022-07-13', 1000000)

-- insert LocationStart


insert into dbo.LocationStart values ('Hà Nội - Hải Phòng', 'Long Biên')
insert into dbo.LocationStart values ('Hà Nội - Hải Phòng', 'Thanh Xuân')
insert into dbo.LocationStart values ('HN-HCM', 'Long Biên')
insert into dbo.LocationStart values ('HN-HCM', 'Cầu Giấy')
insert into dbo.LocationStart values ('Hà Nội - Yên Bái', 'Long Biên')
insert into dbo.LocationStart values ('Hồ Chí Minh - Nha Trang', 'Quận 1')
insert into dbo.LocationStart values ('Hồ Chí Minh - Nha Trang', 'Quận 3')
insert into dbo.LocationStart values ('Hồ Chí Minh - Nha Trang', 'Quận 10')
insert into dbo.LocationStart values ('Hồ Chí Minh - Phú Quốc', 'Quận 1')
insert into dbo.LocationStart values ('Hồ Chí Minh - Phan Thiết ', 'Quận 3')

-- insert LocationVisit

insert into dbo.LocationVisit values ('Hà Nội - Hải Phòng', 'Cát Bà')
insert into dbo.LocationVisit values ('Hà Nội - Hải Phòng', 'Đồ Sơn')
insert into dbo.LocationVisit values ('HN-HCM', 'Vinh')
insert into dbo.LocationVisit values ('HN-HCM', 'Huế')
insert into dbo.LocationVisit values ('Hà Nội - Yên Bái', 'Ba Vì')
insert into dbo.LocationVisit values ('Hồ Chí Minh - Nha Trang', 'Đà Lạt')
insert into dbo.LocationVisit values ('Hồ Chí Minh - Nha Trang', 'Cam Ranh')
insert into dbo.LocationVisit values ('Hồ Chí Minh - Nha Trang', 'Vân Phong')
insert into dbo.LocationVisit values ('Hồ Chí Minh - Phú Quốc', 'Cần Thơ')
insert into dbo.LocationVisit values ('Hồ Chí Minh - Phan Thiết ', 'Vũng Tàu')

-- insert Vehicle

insert into Vehicle values ('Hà Nội - Hải Phòng', 'Tàu hỏa', 100)
insert into Vehicle values ('Hà Nội - Yên Bái', 'Xe khách', 50)
insert into Vehicle values ('HN-HCM', 'Máy bay', 100)
insert into Vehicle values ('HN-HCM', 'Tàu hỏa', 100)
insert into Vehicle values ('HN-HCM', 'Xe khách', 10)
insert into Vehicle values ('Hồ Chí Minh - Nha Trang', 'Tàu hỏa', 100)
insert into Vehicle values ('Hồ Chí Minh - Phan Thiết', 'Xe khách', 50)
insert into Vehicle values ('Hồ Chí Minh - Phú Quốc', 'Máy bay', 100)

-- insert Order

insert into dbo.OrderTour values(1, getdate(),300000)
insert into dbo.OrderTour values(2, getdate(),200000)

-- insert OrderDetail

insert into dbo.OrderDetail values(1, 'Hà Nội - Hải Phòng', 3, 0)
insert into dbo.OrderDetail values(2, 'Hà Nội - Yên Bái', 1, 0)

-- insert OrderStatus

insert into dbo.OrderStatus values(1, 'Đã thanh toán')
insert into dbo.OrderStatus values(2, 'Chờ thanh toán')

-- insert Description

insert into dbo.Descriptions values('Hà Nội - Hải Phòng' , 9000000)
insert into dbo.Descriptions values('Hà Nội - Yên Bái',2000000)


-- insert DescriptionDetail

insert into dbo.DescriptionDetail values(1, 'Tham quan phố cổ Hà Nội' , 2, 0, 300000, 900000)
insert into dbo.DescriptionDetail values(1, 'Tắm biển Đồ Sơn',2, 0, 0, 500000)
insert into dbo.DescriptionDetail values(1, 'Tham quan Cát Bà',2, 0, 0, 2000000)

select * from dbo.Admin
select * from dbo.Staff
select * from dbo.Client
select * from dbo.UserAddress
select * from dbo.Tour
select * from dbo.LocationStart
select * from dbo.LocationVisit
select * from dbo.Vehicle
select * from dbo.OrderTour
select * from dbo.OrderDetail
select * from dbo.OrderStatus
select * from dbo.Descriptions
select * from dbo.DescriptionDetail




