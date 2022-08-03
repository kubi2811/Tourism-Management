use ManageTourist
go

insert into OrderTour values(1, GETDATE(), 1000000, 1)
insert into OrderTour values(2, GETDATE(), 1000000, 1)
insert into OrderTour values(3, GETDATE(), 3000000, 1)
insert into OrderTour values(4, GETDATE(), 5000000, 1)

select* from Client
select* from OrderTour