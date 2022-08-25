import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotFoundExceptionTest {
    private Repository repository = new Repository();
    private TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 100, "AEF", "WER", 125);
    Ticket ticket2 = new Ticket(2, 10, "AEF", "WER", 125);
    Ticket ticket3 = new Ticket(3, 1020, "AEF", "WER", 125);
    Ticket ticket4 = new Ticket(4, 1010, "AEF", "FRT", 125);
    Ticket ticket5 = new Ticket(5, 1100, "AEF", "FRT", 125);
    Ticket ticket6 = new Ticket(6, 1200, "UYI", "WER", 125);
    Ticket ticket7 = new Ticket(7, 1300, "AEF", "WJR", 125);
    Ticket ticket8 = new Ticket(8, 1400, "UYI", "WER", 125);
    Ticket ticket9 = new Ticket(1, 1, "AEF", "WEL", 125);

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
    }

    @Test
    void shouldRemoveByIdFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(100);
        });
    }

    @Test
    void shouldAddExistingID() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.add(ticket9);
            ;
        });
    }
}
