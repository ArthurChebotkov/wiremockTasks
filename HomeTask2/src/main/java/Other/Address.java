package Other;

public class Address {
    public String country;
    public String city;
    public String street;
    public int numberOfHouse;
    public int numberOfFloor;
    public int numberOfFlat;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfHouse=" + numberOfHouse +
                ", numberOfFloor=" + numberOfFloor +
                ", numberOfFlat=" + numberOfFlat +
                '}';
    }

    public Address(String country, String city, String street, int numberOfHouse, int numberOfFloor, int numberOfFlat) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
        this.numberOfFloor = numberOfFloor;
        this.numberOfFlat = numberOfFlat;
    }
}
