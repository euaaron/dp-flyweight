import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testToString() {
        Address address = AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        assertEquals("Address{city='Juiz de Fora,state='MG',country='Brasil'}", address.toString());
        AddressFactory.getInstance().clear();
    }

    @Test
    void shouldNotAddDuplicatedAddress() {
        AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        assertEquals(1, AddressFactory.getInstance().getTotal());
        AddressFactory.getInstance().clear();
    }

    @Test
    void shouldNotContainAnyAddressAfterClear() {
        AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        AddressFactory.getInstance().fetch("Matias Barbosa", "MG", "Brasil");
        assertEquals(2, AddressFactory.getInstance().getTotal());
        AddressFactory.getInstance().clear();
        assertEquals(0, AddressFactory.getInstance().getTotal());
    }

    @Test
    void shouldHaveACity() {
        Address address = AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        assertEquals("Juiz de Fora", address.getCity());
        AddressFactory.getInstance().clear();
    }

    @Test
    void shouldHaveAState() {
        Address address = AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        assertEquals("MG", address.getState());
        AddressFactory.getInstance().clear();
    }

    @Test
    void shouldHaveACountry() {
        Address address = AddressFactory.getInstance().fetch("Juiz de Fora", "MG", "Brasil");
        assertEquals("Brasil", address.getCountry());
        AddressFactory.getInstance().clear();
    }

    @Test
    void shouldAllowCreateWithNullValues() {
        Exception exception = assertThrows(IllegalArgumentException.class , () ->
                AddressFactory.getInstance().fetch(null, null, null)
        );
        assertEquals("Values cannot be null", exception.getMessage());
    }

    @Test
    void shouldAllowCreateWithEmptyValues() {
        Exception exception = assertThrows(IllegalArgumentException.class , () ->
                AddressFactory.getInstance().fetch("", "", "")
        );
        assertEquals("Values cannot be null", exception.getMessage());
    }
}