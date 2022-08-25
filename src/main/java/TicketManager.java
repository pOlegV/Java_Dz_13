import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private Repository repository;

    public TicketManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket tickets) {
        repository.save(tickets);
    }

    public Ticket[] findAll (String from, String to ) {
        Ticket[] result = new Ticket[0];
        for (Ticket tickets : repository.findAll()) {
            if (matches(tickets, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator){
        Ticket[] result = new Ticket[0];
        for (Ticket tickets : repository.findAll()) {
            if (matches(tickets, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = tickets;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public boolean matches(Ticket tickets, String searchFrom, String searchTo){
        if (tickets.getDeparture().contains(searchFrom) && tickets.getArrival().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }

}