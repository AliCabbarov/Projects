package repository;

import model.entity.Flight;
import model.entity.Passenger;
import model.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    int saveTicket(Ticket ticket);
    Optional<Ticket> findByPassenger(Passenger passenger);
    Optional<Ticket> findById(long id);
    Optional<Ticket> findByTicketId(String ticketId);
    List<Passenger> findByFlight(Flight flight);
}
