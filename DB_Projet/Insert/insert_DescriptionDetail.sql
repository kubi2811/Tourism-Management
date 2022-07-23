use ManageTourist
go

insert into dbo.DescriptionDetail values(3, 'Tham quan phố cổ Hà Nội' , 2, 0, 300000, 900000)
insert into dbo.DescriptionDetail values(3, 'Tắm biển Đồ Sơn',2, 0, 0, 500000)
insert into dbo.DescriptionDetail values(3, 'Tham quan Cát Bà',2, 0, 0, 2000000)

select* from dbo.Tour
select* from dbo.Descriptions
select* from dbo.DescriptionDetail