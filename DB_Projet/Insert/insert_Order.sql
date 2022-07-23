use ManageTourist
go

insert into dbo.OrderTour values(1, getdate(),300000)
insert into dbo.OrderTour values(2, getdate(),200000)

select* from Client
select* from OrderTour