package model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import model.constants.FlightConstant;
import util.FormatUtil;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import static model.constants.FlightConstant.MAX_SEATS;

@Getter
@Entity(name = "flights")
@NamedQueries({
        @NamedQuery(name = "findAll",query = "select f from flights f"),
        @NamedQuery(name = "findAvailableFlights",query = "select f from flights f where isFly = false and isFull = false ")
})
public class Flight {
    private final int max_seats;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
    @SequenceGenerator(name = "sequence_id", sequenceName = "sequence_id", allocationSize = 1)
    long id;
    @Column(name = "from", nullable = false, updatable = false)
    private String from;
    @Column(name = "to", nullable = false, updatable = false)
    private String to;
    @Column(name = "initial_price", nullable = false, updatable = false)

    private BigDecimal initialPrice;
    @Column(name = "price", nullable = false, unique = true, updatable = false)
    private BigDecimal price;
    @Column(name = "flight_date", nullable = false, unique = true, updatable = false)
    private LocalDateTime flightDateTime;
    @Column(name = "landed_date", nullable = false, unique = true, updatable = false)
    private LocalDateTime landedDateTime;
    private boolean isFull;
    @Column(name = "landed_date", nullable = false, unique = true, updatable = false)
    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;
    private boolean isFly;
    @Transient
    private int saleCount; // TODO: use in AirPlaneService

    {
        max_seats = MAX_SEATS;
    }

    public Flight() {
    }


    public Flight(String from, String to, BigDecimal initialPrice, LocalDateTime flightDateTime, LocalDateTime landedDateTime) {
        this.from = from;
        this.to = to;
        this.initialPrice = initialPrice;
        this.price = initialPrice;
        this.flightDateTime = flightDateTime;
        this.landedDateTime = landedDateTime;
    }

    public void fly() {
        isFly = true;
    }

    public boolean isFly() {
        return isFly;
    }

    public boolean isFlightMoment() {
        return Duration.between(getFlightDateTime(), LocalDateTime.now()).isNegative();
    }

    public void demandTicketPrice() {
        if (saleCount > 1 && saleCount < 7) {
            setPrice(this.price.add(price.multiply(BigDecimal.valueOf(FlightConstant.INCREMENT_PRICE_BETWEEN_2_AND_7))));
        } else if (saleCount > 7) {
            setPrice(this.price.add(price.multiply(BigDecimal.valueOf(FlightConstant.INCREMENT_PRICE_MORE_THAN_7))));
        } else if (saleCount < 2) {
            setPrice(this.price.add(price.multiply(BigDecimal.valueOf(FlightConstant.DECREMENT_PRICE_LESS_THAN_2))));
        }

        if (this.price.compareTo(calculateMaxTicketPrice()) > 0) {
            setPrice(calculateMaxTicketPrice());
        } else if (this.price.compareTo(calculateMinTicketPrice()) < 0) {
            setPrice(calculateMinTicketPrice());
        }


        saleCount = 0;
    }

    public boolean isFull(){
        return tickets.size() == max_seats;
    }

    public void full(){
        isFull = true;
    }

    private BigDecimal calculateMaxTicketPrice() {
        return initialPrice.add(initialPrice.multiply(BigDecimal.valueOf(FlightConstant.MAX_TICKET_PRICE)));
    }

    private BigDecimal calculateMinTicketPrice() {
        return initialPrice.subtract(initialPrice.multiply(BigDecimal.valueOf(FlightConstant.MIN_TICKET_PRICE)));
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String toString(boolean isAdmin) {
        return getFlightInfo(isAdmin); // Warning!!!
    }

    private String getFlightInfo(boolean isAdmin) {
        StringBuilder builder = new StringBuilder();
        builder.append("\n-----------------------\n")
                .append(getId()).append(". Flight (").append(getFrom()).append(" to ").append(getTo()).append(")")
                .append("\n\t - Ticket price  : ").append(FormatUtil.decimalFormat(getPrice())).append("$")
                .append("\n\t - Fly date time : ").append(FormatUtil.formatDateTime(getFlightDateTime()));

        if (!isAdmin) {
            builder.append("\n\t - Approximately ").append(calculateFlightDate());
        } else {
            builder.append("\n\t - Landing time: ").append(getLandedDateTime())
                    .append("\n\t - Ticket initial price: ").append(getInitialPrice())
                    .append("\n\t - Total profit: ").append(FormatUtil.decimalFormat(calculateTotalProfit()))
                    .append("\n\t - passenger size: ").append(tickets.size());
        }
        builder.append("\n-----------------------\n");
        return builder.toString();
    }

    private BigDecimal calculateTotalProfit() {
        double totalPrice = tickets.stream()
                .map(ticket -> ticket.getSalePrice().doubleValue())
                .reduce(0.0, Double::sum);
        return BigDecimal.valueOf(totalPrice);

    }

    private String calculateFlightDate() {
        long seconds = Duration.between(getFlightDateTime(), getLandedDateTime()).getSeconds();
        long hour = seconds / 3600;
        long minutes = seconds % 3600;
        return hour + "hours " + minutes + " minutes";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return max_seats == flight.max_seats && id == flight.id && isFull == flight.isFull && isFly == flight.isFly && saleCount == flight.saleCount && Objects.equals(from, flight.from) && Objects.equals(to, flight.to) && Objects.equals(initialPrice, flight.initialPrice) && Objects.equals(price, flight.price) && Objects.equals(flightDateTime, flight.flightDateTime) && Objects.equals(landedDateTime, flight.landedDateTime) && Objects.equals(tickets, flight.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max_seats, id, from, to, initialPrice, price, flightDateTime, landedDateTime, isFull, tickets, isFly, saleCount);
    }
}
