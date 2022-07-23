/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class History {
    private String  idOrder;
    private String timeOrder;

    public History(String idOrder, String timeOrder) {
        this.idOrder = idOrder;
        this.timeOrder = timeOrder;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }
    
    
}
