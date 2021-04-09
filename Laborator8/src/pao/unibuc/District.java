package pao.unibuc;

public class District implements Comparable<District> {
    private String name;
    private int inhabitants;

    public District(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getInhabitants() {
        return inhabitants;
    }

    public void addCity(City city){
        if(name.equals(city.getDistrict())){
            inhabitants += city.getInhabitants();
        }
    }
    @Override
    public int compareTo(District o) {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s,%d", name, inhabitants);
    }
}
