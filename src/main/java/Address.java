import java.util.Objects;

public class Address {
    private String town;
    private String street;
    private String home;

    public Address(String town, String street, String home) {
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

    public String getHome() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(town, address.town) && Objects.equals(street, address.street) && Objects.equals(home, address.home);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, street, home);
    }
}

