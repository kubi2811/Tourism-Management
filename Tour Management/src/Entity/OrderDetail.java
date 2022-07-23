/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class OrderDetail {
    private String idRandom;
    private String idOrder;
    private String idClient;
    private String idTour;
    private int adluts;
    private int childs;

    public OrderDetail(String idRandom, String idOrder, String idClient, String idTour, int adluts, int childs) {
        this.idRandom = idRandom;
        this.idOrder = idOrder;
        this.idClient = idClient;
        this.idTour = idTour;
        this.adluts = adluts;
        this.childs = childs;
    }

    public String getIdRandom() {
        return idRandom;
    }

    public void setIdRandom(String idRandom) {
        this.idRandom = idRandom;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public int getAdluts() {
        return adluts;
    }

    public void setAdluts(int adluts) {
        this.adluts = adluts;
    }

    public int getChilds() {
        return childs;
    }

    public void setChilds(int childs) {
        this.childs = childs;
    }
    
}
