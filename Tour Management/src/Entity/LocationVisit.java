/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class LocationVisit {
    private String idRandomVisit;
    private String  visitPlace;
    private String tour;

    public String getIdRandomVisit() {
        return idRandomVisit;
    }

    public void setIdRandomVisit(String idRandomVisit) {
        this.idRandomVisit = idRandomVisit;
    }

    public String getVisitPlace() {
        return visitPlace;
    }

    public void setVisitPlace(String visitPlace) {
        this.visitPlace = visitPlace;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public LocationVisit(String idRandomVisit, String visitPlace, String tour) {
        this.idRandomVisit = idRandomVisit;
        this.visitPlace = visitPlace;
        this.tour = tour;
    }

            
}
