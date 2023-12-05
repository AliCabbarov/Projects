package repository.impl;

import model.entity.Flight;
import model.entity.Passenger;
import model.entity.Ticket;
import repository.TicketRepository;

import java.util.List;
import java.util.Optional;

public class TicketRepositoryImpl implements TicketRepository {
    @Override
    public int saveTicket(Ticket ticket) {
        return 0;
    }

    @Override
    public Optional<Ticket> findByPassenger(Passenger passenger) {
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Ticket> findByTicketId(String ticketId) {
        return Optional.empty();
    }
    public List<Passenger> findByFlight(Flight flight) {
        return null;
    }

}
