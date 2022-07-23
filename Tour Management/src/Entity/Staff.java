/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author hieut
 */
public class Staff {
    private String IdStaff;
    private String FullName;
    private String Username;
    private String password;

    public Staff(String IdStaff, String FullName, String Username, String password) {
        this.IdStaff = IdStaff;
        this.FullName = FullName;
        this.Username = Username;
        this.password = password;
    }

    public String getIdStaff() {
        return IdStaff;
    }

    public void setIdStaff(String IdStaff) {
        this.IdStaff = IdStaff;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
           
}
