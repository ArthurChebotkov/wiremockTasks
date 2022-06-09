package Addresses;

public class Address {
    public Address() {
    }
    public String country;

    public String city;

    public String street;

    public int houseNumber;

    public int floor;

    public int apartmentNumber;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", floor=" + floor +
                ", apartmentNumber=" + apartmentNumber +
                '}';
    }


    public Address(String country, String city, String street, int houseNumber, int floor, int apartmentNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
    }
}
