import utils.NullChecker;

import java.util.HashMap;
import java.util.Map;

public class CourseFactory {
    private final static CourseFactory instance = new CourseFactory();
    public Map<String, Course> courses = new HashMap<>();
    private CourseFactory() {}

    public static CourseFactory getInstance() {
        return instance;
    }

    public Course fetch(String name, String degree, String campus, String city, String state, String country, String website) throws IllegalArgumentException{
        boolean invalid = NullChecker.isNull(name, degree, campus, city, state, country, website);
        if (invalid) {
            throw new IllegalArgumentException("Values cannot be null");
        }
        String key = name + campus + degree + city;
        Course course = courses.get(key);
        if (course == null) {
            course = new Course(name, degree, campus, city, state, country, website);
            courses.put(key, course);
        }
        return course;
    }

    public int getTotal() {
        return courses.size();
    }

    public void clear() {
        courses.clear();
    }
}
