import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    @Test
    void shouldSubscribeStudent() {
        Subscription.fetch(
                "Aaron Carneiro",
                "edu@aaroncarneiro.com",
                "Matias Barbosa",
                "MG",
                "Brasil",
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora"
        );
        assertEquals(1, Subscription.getTotal());
        Subscription.clear();
    }

    @Test
    void shouldNotSubscribeSameStudentWithSameEmail() {
        Subscription.fetch(
                "Aaron Carneiro",
                "edu@aaroncarneiro.com",
                "Matias Barbosa",
                "MG",
                "Brasil",
                "Sistemas de Informação",
                "Bachelor",
                "Instituto Federal de Educação, Ciência e Tecnologia do Sudeste de Minas Gerais",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora"
        );

        Subscription sub = Subscription.fetch(
                "Aaron Carneiro",
                "edu@aaroncarneiro.com",
                "Matias Barbosa",
                "MG",
                "Brasil",
                "Análise e Desenvolvimento de Sistemas",
                "Technician",
                "Faculdades Integradas Vianna Júnior",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora"
        );
        assertTrue(sub.toString().contains("Instituto Federal de Educação, Ciência e Tecnologia do Sudeste de Minas Gerais"));
        Subscription.clear();
    }

    @Test
    void shouldClearSubscriptions() {
        Subscription.fetch(
                "Aaron Carneiro",
                "edu@aaroncarneiro.com",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora"
        );
        Subscription.clear();
        assertEquals(0, Subscription.getTotal());
    }

    @Test
    void shouldNotCreateDuplicatedAddresses() {
        Subscription.fetch(
                "Aaron Carneiro",
                "edu@aaroncarneiro.com",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "Sistemas de Informação",
                "Bachelor",
                "IF Sudeste MG",
                "Juiz de Fora",
                "MG",
                "Brasil",
                "https://ifsudestemg.edu.br/juizdefora"
        );
        assertEquals(1, AddressFactory.getInstance().getTotal());
        Subscription.clear();
    }
}