package hoa14110071.chieuthusau.foodyversion1.Object;

/**
 * Created by minhh on 4/3/2017.
 */

public class District {
    int Id;
    String Name;
    int CountStreet;
    int CityId;

    public District(int id, String name, int countStreet, int cityId) {
        Id = id;
        Name = name;
        CountStreet = countStreet;
        CityId = cityId;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getCountStreet() {
        return CountStreet;
    }

    public int getCityId() {
        return CityId;
    }
}
