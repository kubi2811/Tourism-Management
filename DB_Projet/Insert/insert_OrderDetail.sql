use ManageTourist
go

insert into dbo.OrderDetail values(1, 'Hà Nội - Hải Phòng', 3, 0)
insert into dbo.OrderDetail values(2, 'Hà Nội - Yên Bái', 1, 0)

select* from Tour
select* from OrderTour
select* from OrderDetail