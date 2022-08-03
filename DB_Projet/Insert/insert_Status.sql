use ManageTourist
go

insert into dbo.OrderStatus values (1, 'Client0',N'Chưa thanh toán')

insert into dbo.OrderStatus values (2, 'Client1',N'Chưa thanh toán')

insert into dbo.OrderStatus values (3, 'Client2',N'Chưa thanh toán')

insert into dbo.OrderStatus values (4, 'Client3',N'Chưa thanh toán')

select* from OrderTour
select* from OrderStatus
select* from Client where Client.IdClient = 4