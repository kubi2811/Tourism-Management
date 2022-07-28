/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class Descriptions {
    private int idDescription;
    private String tour;
    private double total;

    public Descriptions(int idDescription, String tour, double total) {
        this.idDescription = idDescription;
        this.tour = tour;
        this.total = total;
    }

    public Descriptions(String tour, double total) {
        this.tour = tour;
        this.total = total;
    }
    

    public int getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(int idDescription) {
        this.idDescription = idDescription;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
