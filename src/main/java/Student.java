public class Student {
    private final String name;
    private final String email;
    private final Address address;

    public Student(String name, String email, String city, String state, String country) {
        this.name = name;
        this.email = email;
        this.address = AddressFactory.getInstance().fetch(city, state, country);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + this.getName() + "',email='" + this.getEmail() + "',address='" + this.getAddress() + "'}";
    }
}
