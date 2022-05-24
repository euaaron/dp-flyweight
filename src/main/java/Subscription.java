import java.util.HashMap;
import java.util.Map;

public class Subscription {
    private final static Map<String, Subscription> subscriptions = new HashMap<>();
    private final String id;
    private final Student student;
    private final Course course;

    private Subscription(Student student, Course course) {
        this.id = student.getEmail();
        this.student = student;
        this.course = course;
    }

    public static Subscription fetch(
            String studentName,
            String studentEmail,
            String studentCity,
            String studentState,
            String studentCountry,
            String courseName,
            String courseDegree,
            String campusName,
            String campusCity,
            String campusState,
            String campusCountry,
            String campusWebsite
    ) {
        Subscription sub = subscriptions.get(studentEmail);
        if (sub == null) {
            Student student = new Student(
                    studentName,
                    studentEmail,
                    studentCity,
                    studentState,
                    studentCountry
            );
            Course course = new Course(
                    courseName,
                    courseDegree,
                    campusName,
                    campusCity,
                    campusState,
                    campusCountry,
                    campusWebsite
            );
            sub = new Subscription(student, course);
            subscriptions.put(studentEmail, sub);
        }
        return sub;
    }

    public static int getTotal() {
        return subscriptions.size();
    }

    public static void clear() {
        subscriptions.clear();
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String toString() {
        return "Subscription{" + "id='" + id + "'" + student + "'" + course + "'}";
    }
}
