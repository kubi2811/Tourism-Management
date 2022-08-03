use ManageTourist
go

insert into dbo.Descriptions values(N'Hà Nội - Hải Phòng', GETDATE(), 9000000)
insert into dbo.Descriptions values(N'Hà Nội - Hồ Chí Minh', GETDATE(), 90000000)
insert into dbo.Descriptions values(N'Hà Nội - Yên Bái', GETDATE(), 4000000)
insert into dbo.Descriptions values(N'Vũng Tàu - Móng Cái', GETDATE(), 100000000)

select* from dbo.Tour
select* from dbo.Descriptions