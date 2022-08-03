use ManageTourist
go

insert into dbo.OrderDetail values(1, 1, N'Hà Nội - Yên Bái', 1, 0)
insert into dbo.OrderDetail values(2, 2, N'Hồ Chí Minh - Phan Thiết', 1, 0)
insert into dbo.OrderDetail values(3, 3, N'Hà Nội - Hải Phòng', 1, 1)
insert into dbo.OrderDetail values(4, 4, N'Vũng Tàu - Móng Cái', 2 ,1)

-- drop table OrderDetail
select* from Tour
select* from OrderTour
select* from OrderDetail