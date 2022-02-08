public class Address {
    private String town;
    private String street;
    private Integer home;

    public Address(String town, String street, Integer home) {
        this.town = town;
        this.street = street;
        this.home = home;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                '}';
    }
}

