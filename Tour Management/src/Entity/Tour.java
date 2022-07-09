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
    private Date dayStart;
    private Date dayEnd;
    private String discription;
    private String idLocationStart;
    private String idLocationVisit;
    private float cost;
    private String idVehicle;

    public Tour(String idTour, Date dayStart, Date dayEnd, String discription, String idLocationStart, String idLocationVisit, float cost, String idVehicle) {
        this.idTour = idTour;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.discription = discription;
        this.idLocationStart = idLocationStart;
        this.idLocationVisit = idLocationVisit;
        this.cost = cost;
        this.idVehicle = idVehicle;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
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

    public String getIdLocationStart() {
        return idLocationStart;
    }

    public void setIdLocationStart(String idLocationStart) {
        this.idLocationStart = idLocationStart;
    }

    public String getIdLocationVisit() {
        return idLocationVisit;
    }

    public void setIdLocationVisit(String idLocationVisit) {
        this.idLocationVisit = idLocationVisit;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }
    
}
