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

    public LocationStart(String IdRandomStart, String Province) {
        this.idRandomStart = IdRandomStart;
        this.province = Province;
    }

    public String getIdRandomStart() {
        return idRandomStart;
    }

    public void setIdRandomStart(String IdRandomStart) {
        this.idRandomStart = IdRandomStart;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String Province) {
        this.province = Province;
    }
    
}
