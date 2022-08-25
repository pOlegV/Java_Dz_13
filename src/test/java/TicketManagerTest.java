import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    private Repository repository = new Repository();
    private TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 100, "AEF", "WER", 125);
    Ticket ticket2 = new Ticket(2, 10, "AEF", "WER", 125);
    Ticket ticket3 = new Ticket(3, 1020, "AEF", "WER", 125);
    Ticket ticket4 = new Ticket(4, 1010, "AEF", "FRT", 125);
    Ticket ticket5 = new Ticket(5, 1100, "AEF", "FRT", 125);
    Ticket ticket6 = new Ticket(6, 1200, "UYI", "WER", 125);
    Ticket ticket7 = new Ticket(7, 1020, "AEF", "WER", 125);
    Ticket ticket8 = new Ticket(8, 1400, "UYI", "WER", 125);
    Ticket ticket9 = new Ticket(9, 1, "AEF", "WER", 125);

    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
    }

    @Test
    void shouldAdd() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        Ticket[] expected = {ticket9, ticket2, ticket1, ticket3, ticket7};
        Ticket[] actual = manager.findAll("AEF", "WER");
        Assertions.assertArrayEquals(expected, actual);
    }
}
