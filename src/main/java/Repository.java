public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket newItem) {
        for (Ticket items: tickets){
            if (items.id == newItem.id){
                throw new NotFoundException("a ticket with this " + newItem.id + " exists");
            }
        }
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = newItem;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Ticket with id: " + id + " not found");
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket item : tickets) {
            if (item.id != id) {
                tmp[index] = item;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket item : tickets) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

}