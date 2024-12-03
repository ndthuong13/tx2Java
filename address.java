public class Address {
    private String street;
    private String city;

    // Constructor không tham số
    public Address() {}

    // Constructor đầy đủ tham số
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // toString method
    @Override
    public String toString() {
        return "Street: " + street + ", City: " + city;
    }
}
