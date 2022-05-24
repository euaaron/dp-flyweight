import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampusTest {

    @Test
    void testToString() {
        Campus campus = CampusFactory.getInstance().fetch(
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
        "https://ifsudestemg.edu.br/juizdefora");
        assertEquals("Campus{name='IF Sudeste MG',address='Address{city='Juiz de Fora,state='MG',country='Brasil'}',website='https://ifsudestemg.edu.br/juizdefora'}", campus.toString());
        CampusFactory.getInstance().clear();
    }

    @Test
    void shouldClearCampusList() {
        Campus campus = CampusFactory.getInstance().fetch(
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora");
        assertEquals(1, CampusFactory.getInstance().getTotal());
        CampusFactory.getInstance().clear();
        assertEquals(0, CampusFactory.getInstance().getTotal());
    }

    @Test
    void shouldNotCreateDuplicatedCampus() {
        CampusFactory.getInstance().fetch(
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora");
        CampusFactory.getInstance().fetch(
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora");
        assertEquals(1, CampusFactory.getInstance().getTotal());
        CampusFactory.getInstance().clear();
    }

    @Test
    void shouldNotCreateCampusWithNullValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CampusFactory.getInstance().fetch(
                    null,
                    null,
                    null,
                    null,
                    null
                )
        );
        assertEquals("Values cannot be null", exception.getMessage());
    }


}