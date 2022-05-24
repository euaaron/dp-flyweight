import utils.NullChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CampusFactory {
    private final static CampusFactory instance = new CampusFactory();
    private final Map<String, Campus> campi = new HashMap<>();

    private CampusFactory() {}

    public static CampusFactory getInstance() {
        return instance;
    }

    public Campus fetch(String name, String city, String state, String country, String website) throws IllegalArgumentException{
        boolean invalid = NullChecker.isNull(name, city, state, country, website);
        if (invalid) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        String key = name + city + state + country;
        Campus campus = campi.get(key);
        if (campus == null) {
            campus = new Campus(name, city, state, country, website);
            campi.put(key, campus);
        }
        return campus;
    }

    public int getTotal() {
        return campi.size();
    }

    public void clear() {
        campi.clear();
    }
}
