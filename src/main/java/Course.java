public class Course {
    private final String id;
    private final String name;
    private final Degree degree;
    private final Campus campus;

    public Course(String name, String degree, String campus, String city, String state, String country, String website) {
        this.id = (name + campus + degree + city).replaceAll(" ", "");
        this.name = name;
        this.campus = CampusFactory.getInstance().fetch(campus, city, state, country, website);
        try {
            this.degree = Degree.fromString(degree);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid degree: " + degree);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Degree getDegree() {
        return degree;
    }

    public Campus getCampus() {
        return campus;
    }

    public String toString() {
        return "Course{name='" + this.getName() + "',degree='" + this.getDegree().toString() + "'," + this.getCampus() + "}";
    }
}
