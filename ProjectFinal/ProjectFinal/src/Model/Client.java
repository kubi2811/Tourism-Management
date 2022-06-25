package Model;

public class Client {
    private String IdClient;
    private String Firstname;
    private String Lastname;
    private String Address;
    private String NumPerson;
    private String PhoneNumber;
    private String Username;
    private String Password;

    public Client(String idClient, String firstname, String lastname, String address, String numPerson, String phoneNumber, String username, String password) {
        IdClient = idClient;
        Firstname = firstname;
        Lastname = lastname;
        Address = address;
        NumPerson = numPerson;
        PhoneNumber = phoneNumber;
        Username = username;
        Password = password;
    }

    public String getIdClient() {
        return IdClient;
    }

    public void setIdClient(String idClient) {
        IdClient = idClient;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumPerson() {
        return NumPerson;
    }

    public void setNumPerson(String numPerson) {
        NumPerson = numPerson;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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
