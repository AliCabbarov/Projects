package model.entity;

import jakarta.persistence.*;
import model.enums.ExceptionEnums;
import model.exceptions.NullObjectException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "tickets")
@NamedQueries({
        @NamedQuery(name = "findByFlight",query = "select t from tickets t where flight = :flight"),
        @NamedQuery(name = "findByPassenger",query = "select t from tickets t where passenger = :passenger"),
        @NamedQuery(name = "findByTicketId",query = "select t from tickets t where ticketId = :ticketId")
})
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_id")
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1)
    private long id;
    @Column(name = "ticket_id", nullable = false, updatable = false)
    private String ticketId;
    @Column(name = "seat_number", nullable = false, updatable = false)
    private String seatNumber;
    @Column(name = "sale_price", nullable = false, updatable = false)
    private BigDecimal salePrice;
    @Column(name = "sale_date", nullable = false, updatable = false)
    private LocalDateTime saleDateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket_id")
    private Passenger passenger;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private Flight flight;


    public Ticket(Passenger passenger, Flight flight) {
        setTicketId();
        setSeatNumber();
        this.flight = flight; // WARNING: question
        setSalePrice();
        this.saleDateTime = LocalDateTime.now();
        this.passenger = passenger;
        this.flight = flight;
    }

    public Ticket() {
    }


    private void setTicketId() {
        this.ticketId = UUID.randomUUID().toString().substring(0,6);
    }

    private void setSeatNumber() {
        this.seatNumber = UUID.randomUUID().toString().substring(0,3);
    }

    public void setSalePrice() {
        if(flight  == null){
            throw new NullObjectException(ExceptionEnums.NULL_OBJECT_EXCEPTION);
        }

        this.salePrice = flight.getPrice();
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Objects.equals(ticketId, ticket.ticketId) && Objects.equals(seatNumber, ticket.seatNumber) && Objects.equals(salePrice, ticket.salePrice) && Objects.equals(saleDateTime, ticket.saleDateTime) && Objects.equals(passenger, ticket.passenger) && Objects.equals(flight, ticket.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ticketId, seatNumber, salePrice, saleDateTime, passenger, flight);
    }
}
