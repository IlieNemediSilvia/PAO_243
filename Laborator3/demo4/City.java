package unibuc.demo4;

import java.util.Objects;

public class City {
    private String name;
    private String district;
    private int inhabitants;

    public City(String name, String district, int inhabitants){
        this.name = name;
        this.district = district;
        this.inhabitants = inhabitants;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || object.getClass() != getClass()) return false;
        City city = (City) object;
        return inhabitants == city.inhabitants && district.equals(city.district) && name.equals(city.name);
    }
    public int hashCode(){
        return Objects.hash(name, district, inhabitants);
    }
}
