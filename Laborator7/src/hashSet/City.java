package hashSet;

public class City {
    private String name;
    private String district;

    public static String field = "name";

    public City(String[] values){
        name = values[0];
        district = values[1];
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof City
                && ("name".equalsIgnoreCase(field) && name.equalsIgnoreCase(((City) o).name)
                || ("district".equalsIgnoreCase(field) && district.equalsIgnoreCase(((City) o).district))
        );
    }

    @Override
    public int hashCode() {
      return "name".equalsIgnoreCase(field) ? name.hashCode() : district.hashCode();
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
