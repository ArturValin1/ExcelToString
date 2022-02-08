import java.util.Objects;

public class StreetHome {

    private String street;
    private int home;

    public StreetHome(String street, int home) {
        this.street = street;
        this.home = home;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "StreetHome{" +
                "street='" + street + '\'' +
                ", home=" + home +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetHome that = (StreetHome) o;
        return home == that.home &&
                street.equals(that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, home);
    }
}

