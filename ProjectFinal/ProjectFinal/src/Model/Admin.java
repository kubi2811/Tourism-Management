package Model;

public class Admin {
    private String IdAdmin;
    private String Username;
    private String Password;

    public Admin(String idAdmin, String username, String password) {
        IdAdmin = idAdmin;
        Username = username;
        Password = password;
    }

    public Admin() {
    }

    public String getIdAdmin() {
        return IdAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        IdAdmin = idAdmin;
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


//	IdAdmin char(10),
//            Username varchar(50),
//            Password varchar(50),