import utils.NullChecker;

import java.util.HashMap;
import java.util.Map;

public class AddressFactory {
    private final static AddressFactory instance = new AddressFactory();
    private final Map<String, Address> addresses = new HashMap<>();

    private AddressFactory() {}

    public static AddressFactory getInstance() {
        return instance;
    }

    public Address fetch(String city, String state, String country) throws IllegalArgumentException {
        boolean invalid = NullChecker.isNull(city, state, country);
        if (invalid) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        String key = city + state + country;
        Address address = addresses.get(key);
        if (address == null) {
            address = new Address(city, state, country);
            addresses.put(key, address);
        }
        return address;
    }

    public int getTotal() {
        return addresses.size();
    }

    public void clear() {
        addresses.clear();
    }
}
