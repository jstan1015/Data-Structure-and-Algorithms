package assignment.entity;

public class City {
    private int city_id;
    private int fk_state_id;
    private String city_name;
    private int city_postcode;

    public City(int city_id, int fk_state_id, String city_name, int city_postcode) {
        this.city_id = city_id;
        this.fk_state_id = fk_state_id;
        this.city_name = city_name;
        this.city_postcode = city_postcode;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getFk_state_id() {
        return fk_state_id;
    }

    public void setFk_state_id(int fk_state_id) {
        this.fk_state_id = fk_state_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public int getCity_postcode() {
        return city_postcode;
    }

    public void setCity_postcode(int city_postcode) {
        this.city_postcode = city_postcode;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", fk_state_id=" + fk_state_id +
                ", city_name='" + city_name + '\'' +
                ", city_postcode=" + city_postcode +
                '}';
    }
}

