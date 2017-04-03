package hoa14110071.chieuthusau.foodyversion1.Object;


public class Street {
    int Id;
    private String StreetName;
    public Street() {
    }

    public Street(int id, String streetName) {
        Id = id;
        StreetName = streetName;
    }

    public int getId() {
        return Id;
    }

    public String getStreetName() {
        return StreetName;
    }
}
