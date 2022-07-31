use ManageTourist
go


-- proc add Admin
create proc sp_insert_Admin
	@username nvarchar(50),
	@password nvarchar(50)
as
begin tran 
	begin try 
		insert into dbo.Admin values (@username, @password)
	end try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO

-- drop proc sp_insert_Admin

-- proc update Admin
create proc sp_update_Admin
	@newusername nvarchar(50),
	@newpassword nvarchar(50),
	@oldusername nvarchar(50),
	@oldpassword nvarchar(50),
	@idAdmin int
as
begin tran 
	begin try 
		if exists (select * from dbo.Admin where IdAdmin = @idAdmin and Username = @oldusername and Password = @oldpassword )
			if (@newpassword is null)
				update dbo.Admin set Username = @newusername where IdAdmin = @idAdmin
			else if (@newusername is null)
				update dbo.Admin set Password = @newpassword where IdAdmin = @idAdmin
			else if (@newpassword is not null and @newusername is not null)
				update dbo.Admin set Username = @newusername ,Password = @newpassword where IdAdmin = @idAdmin
			else
				raiserror ('Update information is null', 16, 1)
	end try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO

-- proc update Staff
create proc sp_update_Staff
	@newusername nvarchar(50),
	@newpassword varchar(50),
	@oldusername nvarchar(50),
	@oldpassword varchar(50),
	@idStaff int
as
begin tran 
	begin try 
		if exists (select * from dbo.Staff where IdStaff = @idStaff and Username = @oldusername and Password = @oldpassword )
			if (@newpassword is null)
				update dbo.Staff set Username = @newusername where IdStaff = @idStaff
			else if (@newusername is null)
				update dbo.Staff set Password = @newpassword where IdStaff = @idStaff
			else if (@newpassword is not null and @newusername is not null)
				update dbo.Staff set Username = @newusername ,Password = @newpassword where IdStaff = @idStaff
			else
				raiserror ('Update information is null', 16, 1)
	end try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO


-- proc add Staff
create proc sp_insert_Staff
	@username nvarchar(50),
	@password nvarchar(50),
	@fullname nvarchar(50),
	@admin nvarchar(50)
as
begin tran 
	begin try 
		if exists (select * from dbo.Admin where dbo.Admin.Username = @admin)
			insert into dbo.Staff values (@admin, @username, @password)
		else
			raiserror ('Failed Auth', 16, 1)
	end try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO

-- proc add Client 

create proc sp_insert_Client
	@FullName nvarchar(50),
	@Phone varchar(50),
	@Username varchar(50),
	@hashPassword varchar(50),
	@Email varchar(50),
	@number int,
	@street nvarchar(50), 
	@ward nvarchar(50),
	@city nvarchar(50),
	@provience nvarchar(50)
as
begin tran 
	begin try 
		insert into dbo.Client values (@FullName, @Phone, @Username, @hashPassword, @Email)
		insert into dbo.UserAddress values (@Username, @number, @street, @ward, @city, @provience)
	end try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO

-- proc update cost
create proc dbo.Tour @newCostAdults float, @newCostChilds float, @idTour int
AS
begin tran
	BEGIN Try
	IF not exists (SELECT * FROM dbo.Tour WHERE IdTour =  @idTour)
		raiserror ('Không tồn tại tour cần cập nhật', 16, 1)
	else
		begin
			update dbo.Tour
			set  CostAdo = @newCostAdults, CostChild = @newCostChilds
			where IdTour = @idTour
		end
	END Try
	begin catch
		ROLLBACK TRANSACTION;
		RETURN;
	end catch
COMMIT TRANSACTION
GO
