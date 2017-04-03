package hoa14110071.chieuthusau.foodyversion1.Object;

import java.util.List;

/**
 * Created by minhh on 4/3/2017.
 */

public class City {
    int Id;
    String Name;
    List<District> districts;


    public City(int id, String name, List<District> districts) {
        Id = id;
        Name = name;
        this.districts = districts;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public List<District> getDistricts() {
        return districts;
    }
}
