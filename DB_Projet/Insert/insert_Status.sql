use ManageTourist
go

insert into dbo.OrderStatus values(1, 'Đã thanh toán')
insert into dbo.OrderStatus values(2, 'Chờ thanh toán')

select* from OrderTour
select* from OrderStatus