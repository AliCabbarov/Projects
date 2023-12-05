package repository;

import model.entity.Flight;
import model.util.FlightFilter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FlightRepository {
    List<Flight> findAll();
    List<Flight> findAvailableFlight();
    Optional<Flight> findById(long id);
    int updateById(Flight flight);
    int createFlight(Flight flight);
    List<Flight> findBySearchFilter(FlightFilter flightFilter);
}
