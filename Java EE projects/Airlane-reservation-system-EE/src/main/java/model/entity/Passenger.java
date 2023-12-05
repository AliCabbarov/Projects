package model.entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name = "passengers")
@NamedQueries({
        @NamedQuery(name = "findByFinNumber",query = "select p from passengers p where finNumber =: finNumber ")
})
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
    @SequenceGenerator(name = "sequence_id", sequenceName = "sequence_id", allocationSize = 1)
    private long id;
                    @Column(name = "name", nullable = false, updatable = false)
                    private String name;
                    @Column(name = "surname", nullable = false, updatable = false)
                    private String surname;
                    @Column(name = "fin_number", nullable = false, unique = true, updatable = false)
                    private String finNumber;
    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;


    public Passenger(String name, String surname, String finNumber, Set<Ticket> tickets) {
        this.name = name;
        this.surname = name;
        setFinNumber(name);
        this.tickets = tickets;

    }

    public Passenger() {

    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getFinNumber() {
        return finNumber;
    }

    private void setFinNumber(String finNumber) {
        if (finNumber != null && finNumber.length() == 7) {
            this.finNumber = finNumber.toUpperCase();
        }

    }
    public Set<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return id == passenger.id && Objects.equals(name, passenger.name) && Objects.equals(surname, passenger.surname) && Objects.equals(finNumber, passenger.finNumber) && Objects.equals(tickets, passenger.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, finNumber, tickets);
    }
}
