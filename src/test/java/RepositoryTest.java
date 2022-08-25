import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    private Repository repository = new Repository();
    Ticket ticket1 = new Ticket(1, 100, "AEF", "WER", 125);
    Ticket ticket2 = new Ticket(2, 10, "AEF", "WEE", 124);
    Ticket ticket3 = new Ticket(3, 1020, "AEF", "AER", 195);
    Ticket ticket4 = new Ticket(4, 1010, "AEF", "FRT", 184);
    Ticket ticket5 = new Ticket(5, 1100, "AEF", "FRT", 64);
    Ticket ticket6 = new Ticket(6, 1200, "AEF", "WER", 65);
    Ticket ticket7 = new Ticket(7, 1300, "AEF", "WER", 128);
    Ticket ticket8 = new Ticket(8, 1400, "AEF", "WER", 125);
    Ticket ticket9 = new Ticket(9, 1, "AEF", "WER", 136);

    @Test
    void shouldSave() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdOneNull() {
        repository.save(ticket1);

        repository.removeById(1);

        Ticket[] expected = {};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdOne() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);

        repository.removeById(2);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById2Two() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);

        repository.removeById(2);
        repository.removeById(8);

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6, ticket7, ticket9};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);

        Ticket actual = repository.findById(7);
        Ticket expected = ticket7;
        Assertions.assertEquals(expected, actual);
    }


}
