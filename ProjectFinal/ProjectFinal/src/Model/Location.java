package Model;

public class Location {
    private int IdLocation;
    private String nameLocation;

    public Location(int idLocation, String nameLocation) {
        IdLocation = idLocation;
        this.nameLocation = nameLocation;
    }

    public int getIdLocation() {
        return IdLocation;
    }

    public void setIdLocation(int idLocation) {
        IdLocation = idLocation;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }
}

//    create table Location (
//        IdLocation int,
//        nameLocation nvarchar(50),
//    primary key (IdLocation),
//)