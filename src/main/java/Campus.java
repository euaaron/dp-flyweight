public class Campus {
    private final String name;
    private final Address address;

    private final String website;

    public Campus(String name, String city, String state, String country, String website) {
        this.name = name;
        this.address = AddressFactory.getInstance().fetch(city, state, country);
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String toString() {
        return "Campus{name='" + this.getName() + "',address='" + this.getAddress() + "',website='" + this.getWebsite() + "'}";
    }
}
