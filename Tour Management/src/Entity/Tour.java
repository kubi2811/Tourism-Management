/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.awt.List;
import java.util.Date;

/**
 *
 * @author hieut
 */
public class Tour {
    private String idTour;
    private String tour;
    private Date dayStart;
    private Date dayEnd;

    private double costAdo;
    private double costChild;


    public Tour(String idTour, String tour, Date dayStart, Date dayEnd, double costAdo, double costChild) {
        this.idTour = idTour;
        this.tour = tour;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;

        this.costAdo = costAdo;
        this.costChild = costChild;
    }

    public Tour(String tour, Date dayStart, Date dayEnd,  double costAdo, double costChild) {
        this.tour = tour;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;

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

    public double getCostAdo() {
        return costAdo;
    }

    public void setCostAdo(double costAdo) {
        this.costAdo = costAdo;
    }

    public double getCostChild() {
        return costChild;
    }

    public void setCostChild(double costChild) {
        this.costChild = costChild;
    }
   
}
