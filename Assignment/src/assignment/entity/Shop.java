package assignment.entity;

public class Shop {
    private int shop_id;
    private int fk_city_id;
    private String shop_name;
    private String shop_category;
    private String shop_address;

    public Shop(int shop_id, int fk_city_id, String shop_name, String shop_category, String shop_address) {
        this.shop_id = shop_id;
        this.fk_city_id = fk_city_id;
        this.shop_name = shop_name;
        this.shop_category = shop_category;
        this.shop_address = shop_address;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getFk_city_id() {
        return fk_city_id;
    }

    public void setFk_city_id(int fk_city_id) {
        this.fk_city_id = fk_city_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_category() {
        return shop_category;
    }

    public void setShop_category(String shop_category) {
        this.shop_category = shop_category;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        //if (shop_id != shop.shop_id) return false;
        if (!shop_name.equals(shop.shop_name)) return false;
        return shop_category.equals(shop.shop_category);
    }

    @Override
    public int hashCode() {
        int result = shop_name.hashCode();
        result = 31 * result + shop_category.hashCode();
        //result = 31 * result + shop_id;
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", fk_city_id=" + fk_city_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_category='" + shop_category + '\'' +
                ", shop_address='" + shop_address + '\'' +
                '}';
    }
}
