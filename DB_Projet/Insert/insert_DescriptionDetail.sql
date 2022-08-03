use ManageTourist
go

insert into dbo.DescriptionDetail values(1, N'Phố cổ Hà Nội' , 2, 0, 300000, 900000)
insert into dbo.DescriptionDetail values(1, N'Tắm biển Đồ Sơn',2, 0, 0, 500000)
insert into dbo.DescriptionDetail values(1, N'Đảo Cát Bà',2, 0, 0, 2000000)
insert into dbo.DescriptionDetail values(1, N'Lẩu dê Thái Bình',2, 0, 0, 2000000)
insert into dbo.DescriptionDetail values(4, N'Du thuyền VOYAGER OF THE SEAS',4, 0, 0, 2000000)
insert into dbo.DescriptionDetail values(3, N'Cắm trại hồ Ba Vì',4, 0, 0, 4000000)

select* from dbo.Tour
select* from dbo.LocationVisit
select* from dbo.Descriptions
select* from dbo.DescriptionDetail