/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
    
/**
 *
 * @author hieut
 */
public class LocationStart {
    private String idRandomStart;
    private String province;
    private String tour;

    public LocationStart(String idRandomStart, String province, String tour) {
        this.idRandomStart = idRandomStart;
        this.province = province;
        this.tour = tour;
    }

    public String getIdRandomStart() {
        return idRandomStart;
    }

    public void setIdRandomStart(String idRandomStart) {
        this.idRandomStart = idRandomStart;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    
    
}
