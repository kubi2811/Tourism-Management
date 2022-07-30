use ManageTourist
go


-- Tạo index

Select * from dbo.Admin where Username = 'Admin78';

Select * from dbo.Staff where Admin = 'Admin667';
Select * from dbo.Staff where dbo.Staff.FullName = 'Tòng Mỹ Loan';
Select * from dbo.Staff where Username = 'Staff667';

Select * from dbo.Client where FullName = 'Hoa An Nhiên';

-- Index cho Admin
CREATE INDEX TimKiemAdmin ON Admin(Username ASC)

--Drop Index TimKiemAdmin ON Admin

-- Index cho nhân viên
CREATE NONCLUSTERED INDEX TimKiemNhanVien ON Staff(
	Admin ASC,
	Fullname ASC,
	Username ASC)

--DROP INDEX TimKiemNhanVien ON Staff

--Index cho khách hàng
CREATE NONCLUSTERED INDEX TimKiemKhachHang ON Client
(	Fullname ASC,
	Username ASC,
	Phone ASC,
	Email ASC)


-- DROP INDEX TimKiemKhachHang ON Client

-- Index cho danh sách Tour
CREATE NONCLUSTERED INDEX TimKiemTour ON Tour (TourName ASC, DayStart ASC, DayEnd ASC)

-- Index cho nơi bắt đầu
CREATE INDEX TimKiemLocationStart_byLocation ON LocationStart (Province ASC)

CREATE INDEX TimKiemLocationStart_byTour ON LocationStart (Tour ASC)

-- Index cho nơi tham quan
CREATE INDEX TimKiemLocationVisit_byLocation ON LocationVisit (VisitPlace ASC)

CREATE INDEX TimKiemLocationVisit_byTour ON LocationVisit (Tour ASC)


-- Index cho phương tiện
CREATE INDEX TimKiemPhuongTien ON Vehicle (Transport)

-- Index cho đơn hàng
CREATE NONCLUSTERED INDEX TimKiemOrder ON OrderTour(IdClient ASC, createDate ASC)

-- Index cho trang thái đơn hàng
CREATE NONCLUSTERED INDEX TimKiemOrderStatus ON OrderStatus (IdOrder ASC, OrderStatus ASC)
