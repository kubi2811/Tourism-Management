khách hàng
	đăng ký, đăng nhập, xem tất cả thông tin, đặt vé, hủy vé, tổng tiền tour
staff
	đăng nhập, xem tất cả thông tin khách hàng và tour, thêm xóa sửa tour, thống kê
admin
	đăng ký, đăng nhập, phân quyền cho staff, xem tất cả thông tin khách hàng và tour, 
thống kê


User
Đăng ký => Location => Danh sách lịch trình (a->b-c, c->a->b) => ngày đi/về 
=> số người (người lớn + trẻ em) => tính tiền theo đầu người => oke chốt => cọc
=> xem lại thông tin đã đặt => Notif 
//=> có quyền hủy trước 2 tuần trước ngày đi, sau 2 tuàn mất//

====== Pending/ Waiting for paying/ Accept/ Cancel =========== (drop-down)
=> Staff gọi xác nhận khách hàng dăng ký tuor, cọc tiền

user: Đăng ký 
Tên, họ, địa chỉ, cmnd, sdt, username, passw, id



Hóa đơn
Số lượng người, tuor, phương tiện => Tiền 

CT hóa đơn
tour a,....


chi tiết lịch trình => set cứng (lịch trình: text)

64id location(địa điểm: tỉnh) => tỉnh => value
1 tỉnh => list lịch trình (set cứng) => drop down

1 bảng trạng thái chuyến đi (id, tên người, tên tour, số người, giá tiền, tình trạng, ghi chú)=> user đặt =>auto fill


admin
Tên, họ, địa chỉ, cmnd, sdt, username, passw
phân quyền => tạo acc cho staff


staff
username, passw, xem all, thêm xóa sửa tour, thống kê
sửa bảng trạng thái chuyến đi (id, tên người, tên tour, số người, giá tiền, tình trạng, ghi chú)


DB:
Admin(IdAdmin, Username, Pass)
Staff(IdStaff, IdAdmin, Username, Pass)
Tour(IdTour, DayStart, DayEnd, Description, IdLocationStart, IdLocationVisit, Cost, IdVehicle)
Client(IdClient, Username, Password, FullName, Add, Phone, Email)
Order(IdOrder, IdClient, Total)
OrderDetail(Id, IdOrder, IdClient, Adults, Childs)
LocationStart(Id, Province)
LocationVisit(Id, Province)
Vehicle(Id, Type, Capacity)
OrderStatus(Id, IdOrder, Status)
RecycleBin(Id, IdOrder)
History(IdOrder, TimeOrder)
