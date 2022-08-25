import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.time < o2.time) {
            return -1;
        } else if (o1.time > o2.time) {
            return 1;
        } else {
            return 0;
        }
    }
}
