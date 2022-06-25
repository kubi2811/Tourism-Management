package Model;

public class OrderTour {
    private String IdOrder;
    private String IdClient;
    private String NameOrder;
    private int CounterPerson;
    private String InforTour;
    private String Transport;
    private float TotalMoney;


    public OrderTour(String idOrder, String idClient, String nameOrder, int counterPerson, String inforTour, String transport, float totalMoney) {
        IdOrder = idOrder;
        IdClient = idClient;
        NameOrder = nameOrder;
        CounterPerson = counterPerson;
        InforTour = inforTour;
        Transport = transport;
        TotalMoney = totalMoney;
    }

    public String getIdOrder() {
        return IdOrder;
    }

    public void setIdOrder(String idOrder) {
        IdOrder = idOrder;
    }

    public String getIdClient() {
        return IdClient;
    }

    public void setIdClient(String idClient) {
        IdClient = idClient;
    }

    public String getNameOrder() {
        return NameOrder;
    }

    public void setNameOrder(String nameOrder) {
        NameOrder = nameOrder;
    }

    public int getCounterPerson() {
        return CounterPerson;
    }

    public void setCounterPerson(int counterPerson) {
        CounterPerson = counterPerson;
    }

    public String getInforTour() {
        return InforTour;
    }

    public void setInforTour(String inforTour) {
        InforTour = inforTour;
    }

    public String getTransport() {
        return Transport;
    }

    public void setTransport(String transport) {
        Transport = transport;
    }

    public float getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        TotalMoney = totalMoney;
    }
}
