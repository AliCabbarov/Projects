package repository;

import model.entity.Flight;
import model.entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {
    Optional<Passenger> findById(long id);
    Optional<Passenger> findByFinNumber(String finNumber);
}
