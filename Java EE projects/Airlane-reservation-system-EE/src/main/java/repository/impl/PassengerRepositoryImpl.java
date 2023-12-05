package repository.impl;

import jakarta.persistence.TypedQuery;
import model.config.RepositoryConfig;
import model.entity.Flight;
import model.entity.Passenger;
import repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

public class PassengerRepositoryImpl extends RepositoryConfig implements PassengerRepository {

    @Override
    public Optional<Passenger> findById(long id) {
        return Optional.ofNullable(getEntityManager().find(Passenger.class,id));
    }

    @Override
    public Optional<Passenger> findByFinNumber(String finNumber) {
        TypedQuery<Passenger> typedQuery = getEntityManager().createNamedQuery("findByFinNumber",Passenger.class);
        typedQuery.setParameter("finNumber",finNumber);
        return Optional.ofNullable(typedQuery.getSingleResult());
    }
}
