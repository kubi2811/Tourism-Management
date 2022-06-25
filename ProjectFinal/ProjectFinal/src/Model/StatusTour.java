package Model;

public class StatusTour {
    private String IdStatusTour;
    private String IdOrder;
    private String Status;
    private String Note;

    public StatusTour(String idStatusTour, String idOrder, String status, String note) {
        IdStatusTour = idStatusTour;
        IdOrder = idOrder;
        Status = status;
        Note = note;
    }

    public String getIdStatusTour() {
        return IdStatusTour;
    }

    public void setIdStatusTour(String idStatusTour) {
        IdStatusTour = idStatusTour;
    }

    public String getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(String idOrder) {
        IdOrder = idOrder;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
//	IdStatusTour char(10),
//            IdOrder char(10),
//            Status varchar(10),
//            Note varchar(max)
