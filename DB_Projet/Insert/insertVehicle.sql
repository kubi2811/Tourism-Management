use ManageTourist
go

insert into Vehicle values (1, N'Tàu hỏa', 100)
insert into Vehicle values (1, N'Xe khách', 50)
insert into Vehicle values (2, N'Xe khách', 50)
insert into Vehicle values (3, N'Tàu hỏa', 100)
insert into Vehicle values (4, N'Tàu hỏa', 100)
insert into Vehicle values (5, N'Xe khách', 50)
insert into Vehicle values (6, N'Xe khách', 100)
insert into Vehicle values (7, N'Tàu hỏa', 100)
insert into Vehicle values (8, N'Xe khách', 100)
insert into Vehicle values (9, N'Xe khách', 100)
insert into Vehicle values (10, N'Xe khách', 50)
insert into Vehicle values (11, N'Tàu biển', 2000)

select * from Vehicle
select * from LocationStart
select dbo.LocationStart.Tour, dbo.LocationStart.LocationStart, dbo.Vehicle.Transport, dbo.Vehicle.Capacity
from (dbo.LocationStart INNER JOIN dbo.Vehicle ON dbo.LocationStart.IdLocationStart = Vehicle.IdLocationStart)