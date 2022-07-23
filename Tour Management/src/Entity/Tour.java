/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.awt.List;
import java.sql.Date;

/**
 *
 * @author hieut
 */
public class Tour {
    private String idTour;
    private String tour;
    private Date dayStart;
    private Date dayEnd;
    private String discription;
    private float costAdo;
    private float costChild;

    public Tour(String idTour, String tour, Date dayStart, Date dayEnd, String discription, float costAdo, float costChild) {
        this.idTour = idTour;
        this.tour = tour;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.discription = discription;
        this.costAdo = costAdo;
        this.costChild = costChild;
    }

    public Tour() {
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public float getCostAdo() {
        return costAdo;
    }

    public void setCostAdo(float costAdo) {
        this.costAdo = costAdo;
    }

    public float getCostChild() {
        return costChild;
    }

    public void setCostChild(float costChild) {
        this.costChild = costChild;
    }


   
}
