package org.example;

import java.util.List;

public class Tickets {
    private List<Ticket> tickets;

    public Tickets() {
    }

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
