/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class OrderStatus {
    private String idRandomStatus;
    private String idOrder;
    private String status;

    public OrderStatus(String idRandomStatus, String idOrder, String status) {
        this.idRandomStatus = idRandomStatus;
        this.idOrder = idOrder;
        this.status = status;
    }

    public String getIdRandomStatus() {
        return idRandomStatus;
    }

    public void setIdRandomStatus(String idRandomStatus) {
        this.idRandomStatus = idRandomStatus;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
