package Model;

public class Staff {
    private String IdStaff;
    private String IdAdmin;
    private String Firstname;
    private String Lastname;
    private String Username;
    private String Password;

    public Staff(String idStaff, String idAdmin, String firstname, String lastname, String username, String password) {
        IdStaff = idStaff;
        IdAdmin = idAdmin;
        Firstname = firstname;
        Lastname = lastname;
        Username = username;
        Password = password;
    }

    public String getIdStaff() {
        return IdStaff;
    }

    public void setIdStaff(String idStaff) {
        IdStaff = idStaff;
    }

    public String getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        IdAdmin = idAdmin;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

//	IdStaff char(10),
//            IdAdmin char(10),
//            Firstname nvarchar(50),
//            Lastname nvarchar(50),
//            Username varchar(50),
//            Password varchar(50),