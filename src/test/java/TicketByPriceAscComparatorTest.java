import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketByPriceAscComparatorTest {
    private Repository repository = new Repository();
    private TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 100, "AEF", "WER", 125);
    Ticket ticket2 = new Ticket(2, 10, "AEF", "WER", 124);
    Ticket ticket3 = new Ticket(3, 1020, "AEF", "WER", 195);
    Ticket ticket4 = new Ticket(4, 1010, "AEF", "WER", 184);
    Ticket ticket5 = new Ticket(5, 1100, "AEF", "WER", 64);
    Ticket ticket6 = new Ticket(6, 1100, "AEF", "WER", 64);
    Ticket ticket7 = new Ticket(7, 1100, "AEF", "WWR", 64);

    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
    }

    @Test
    void shouldFindAll() {
        TicketByPriceAscComparator timeComparator = new TicketByPriceAscComparator();
        Ticket[] expected = {ticket5, ticket6, ticket2, ticket1, ticket4, ticket3};
        Ticket[] actual = manager.findAll("AEF", "WER", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
