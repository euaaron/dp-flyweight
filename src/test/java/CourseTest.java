import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void testToString() {
        Course course = CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
                );
        assertEquals("Course{name='Sistemas de Informação',degree='Bachelor',Campus{name='IF Sudeste MG',address='Address{city='Juiz de Fora,state='MG',country='Brasil'}',website='https://www.ifsudestemg.edu.br/juizdefora'}}", course.toString());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldNotCreateDuplicatedCoursesAtTheSameCampusAndDegreeAndCity() {
        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Rio Pomba",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "Universidade Federal de Juiz de Fora",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        assertEquals(3, CourseFactory.getInstance().getTotal());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldClearTheCourseList() {
        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Rio Pomba",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "Universidade Federal de Juiz de Fora",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );
        CourseFactory.getInstance().clear();
        assertEquals(0, CourseFactory.getInstance().getTotal());
    }

    @Test
    void shouldCreateAnId() {
        Course course = CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );

        assertEquals("SistemasdeInformaçãoIFSudesteMGBachelorJuizdeFora", course.getId());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldGetCourseName() {
        Course course = CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );
        assertEquals("Sistemas de Informação", course.getName());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldGetCourseDegree() {
        Course course = CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );
        assertEquals(Degree.BACHELOR, course.getDegree());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldGetCourseCampusName() {
        Course course = CourseFactory.getInstance().fetch(
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://www.ifsudestemg.edu.br/juizdefora"
        );
        assertEquals("IF Sudeste MG", course.getCampus().getName());
        CourseFactory.getInstance().clear();
    }

    @Test
    void shouldNotAllowCreateCourseWithInvalidDegree() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CourseFactory.getInstance().fetch(
                    "Sistemas de Informação",
                    "Marshal",
                    "IF Sudeste MG",
                    "Juiz de Fora",
                    "MG",
                    "Brasil",
                    "https://www.ifsudestemg.edu.br/juizdefora"
                )
        );
        assertEquals("Invalid degree: Marshal", exception.getMessage());
    }

    @Test
    void shouldNotAllowCreateCourseNullValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CourseFactory.getInstance().fetch(
                    null,
                    "Bachelor",
                    "IF Sudeste MG",
                    "Juiz de Fora",
                    "MG",
                    "Brasil",
                    "https://www.ifsudestemg.edu.br/juizdefora"
                )
        );
        assertEquals("Values cannot be null", exception.getMessage());
    }
}