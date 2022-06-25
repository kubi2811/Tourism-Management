package Model;

import java.util.Date;

public class OrderDetail {
    private String IdOrderDetail;
    private String IdOrder;
    private String Tour;
    private int Adults;
    private int Children;
    private int Rooom;
    private Date Date;
    private int CountDay;
    private int IdLocation;

    public OrderDetail(String idOrderDetail, String idOrder, String tour, int adults, int children, int rooom, java.util.Date date, int countDay, int idLocation) {
        IdOrderDetail = idOrderDetail;
        IdOrder = idOrder;
        Tour = tour;
        Adults = adults;
        Children = children;
        Rooom = rooom;
        Date = date;
        CountDay = countDay;
        IdLocation = idLocation;
    }

    public String getIdOrderDetail() {
        return IdOrderDetail;
    }

    public void setIdOrderDetail(String idOrderDetail) {
        IdOrderDetail = idOrderDetail;
    }

    public String getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(String idOrder) {
        IdOrder = idOrder;
    }

    public String getTour() {
        return Tour;
    }

    public void setTour(String tour) {
        Tour = tour;
    }

    public int getAdults() {
        return Adults;
    }

    public void setAdults(int adults) {
        Adults = adults;
    }

    public int getChildren() {
        return Children;
    }

    public void setChildren(int children) {
        Children = children;
    }

    public int getRooom() {
        return Rooom;
    }

    public void setRooom(int rooom) {
        Rooom = rooom;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getCountDay() {
        return CountDay;
    }

    public void setCountDay(int countDay) {
        CountDay = countDay;
    }

    public int getIdLocation() {
        return IdLocation;
    }

    public void setIdLocation(int idLocation) {
        IdLocation = idLocation;
    }
}

//	IdOrderDetail char(10),
//            IdOrder char(10),
//            Tour varchar(max),
//            Adults int,
//            Children int,
//            Room int,
//            Times date,
//            CountDay int,
//            IdLocation int,