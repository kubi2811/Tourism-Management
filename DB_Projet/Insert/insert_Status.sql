use ManageTourist
go

insert into dbo.OrderStatus values (1, 'Client0',N'Chưa thanh toán')
insert into dbo.OrderStatus values (2, 'Client0',N'Chưa thanh toán')

insert into dbo.OrderStatus values (6, 'Client0',N'Chưa thanh toán')
insert into dbo.OrderStatus values (7, 'Client1',N'Chưa thanh toán')

insert into dbo.OrderStatus values (8, 'Client2',N'Chưa thanh toán')

insert into dbo.OrderStatus values (9, 'Client3',N'Chưa thanh toán')

select* from OrderTour
select* from OrderDetail
select* from OrderStatus
select* from Client where Client.IdClient = 1

