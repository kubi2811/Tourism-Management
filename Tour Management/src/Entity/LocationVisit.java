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

    public LocationVisit(String idRandomVisit, String visitPlace) {
        this.idRandomVisit = idRandomVisit;
        this.visitPlace = visitPlace;
    }

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
            
}
