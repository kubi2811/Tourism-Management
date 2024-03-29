﻿use ManageTourist
go


-- Tạo index
Select * from dbo.Staff where FullName = 'Chu Thùy Vân'
select * from Staff  where Admin = 'Admin667'
Select * from dbo.Client where Email = 'client34698@gmail.com';
SELECT * FROM Tour WHERE DayStart = '2022-08-20'
-- Index cho nhân viên
CREATE NONCLUSTERED INDEX TimKiemNhanVien ON Staff(
	Admin ASC,
	Fullname ASC)	

--DROP INDEX TimKiemNhanVien ON Staff

--Index cho khách hàng
CREATE NONCLUSTERED INDEX TimKiemKhachHang ON Client
(	Fullname ASC,
	Email ASC)

--DROP INDEX TimKiemKhachHang ON Client

CREATE NONCLUSTERED INDEX TimKiemDiaChiKH ON UserAddress 
(	Username ASC,
	number,
	street,  
	ward,
	city,
	provience)  


-- Index cho danh sách Tour
CREATE NONCLUSTERED INDEX TimKiemTour ON Tour (DayStart ASC, DayEnd ASC)

-- Index cho nơi tham quan
CREATE INDEX TimKiemLocationVisit_byLocation ON LocationVisit (VisitPlace ASC)

CREATE INDEX TimKiemLocationVisit_byTour ON LocationVisit (Tour ASC)

-- Index cho phương tiện
CREATE INDEX TimKiemPhuongTien ON Vehicle (Tour ASC, Transport)

-- Index cho đơn hàng
CREATE NONCLUSTERED INDEX TimKiemOrder ON OrderTour(IdClient ASC, createDate ASC)
CREATE NONCLUSTERED INDEX TimKiemOrderDetail ON OrderDetail(IdOrder ASC, IdClient ASC, Tour ASC)

-- Index cho trang thái đơn hàng
CREATE NONCLUSTERED INDEX TimKiemOrderStatus ON OrderStatus (IdOrder ASC, Status ASC)

-- Index cho lịch sử đơn hàng
CREATE NONCLUSTERED INDEX TimKiemOrderHistory ON History (IdOrder ASC, paidDate ASC)

-- Index cho Description
CREATE NONCLUSTERED INDEX TimKiemDescription ON Descriptions (Tour ASC, createDate ASC)
CREATE NONCLUSTERED INDEX TimKiemDescriptionDetail ON DescriptionDetail (IdDescription ASC, nameDescription ASC)