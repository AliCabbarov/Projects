package repository.impl;


import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import model.config.RepositoryConfig;
import model.entity.Flight;
import model.enums.ExceptionEnums;
import model.exceptions.NotFoundException;
import model.exceptions.UpdateFailedException;
import model.util.FlightFilter;
import repository.FlightRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl extends RepositoryConfig implements FlightRepository {

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> findAll = entityManager.createNamedQuery("findAll", Flight.class);

        return findAll.getResultList();
    }

    @Override
    public List<Flight> findAvailableFlight() {
        TypedQuery<Flight> findAvailableFlights = entityManager.createNamedQuery("findAvailableFlights", Flight.class);
        return findAvailableFlights.getResultList();
    }

    @Override
    public Optional<Flight> findById(long id) {
        return Optional.ofNullable(getEntityManager().find(Flight.class, id));
    }

    @Override
    public int updateById(Flight flight) {
        try {
            flightIsExist(flight);
            getEntityTransaction().begin();
            getEntityManager().merge(flight);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new UpdateFailedException(ExceptionEnums.UPDATE_FAILED);
        }

        return 1;
    }

    @Override
    public int createFlight(Flight flight) {
        try {
            flightIsExist(flight); //TODO warning
            getEntityTransaction().begin();
            getEntityManager().persist(flight);
            getEntityTransaction().commit();
        } catch (Exception e) {
            getEntityTransaction().rollback();
            throw new UpdateFailedException(ExceptionEnums.UPDATE_FAILED); // Todo exception should changed
        }
        return 1;
    }

    @Override
    public List<Flight> findBySearchFilter(FlightFilter flightFilter) {
        CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
        Root<Flight> root = criteriaQuery.from(Flight.class);

        List<Predicate> predicates = generatePredicateForQuery(root, criteriaBuilder, flightFilter);

        CriteriaQuery<Flight> flightCriteriaQuery =  criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Flight> typedQuery = getEntityManager().createQuery(flightCriteriaQuery);


        return typedQuery.getResultList();
    }

    private List<Predicate> generatePredicateForQuery(Root<Flight> root, CriteriaBuilder criteriaBuilder, FlightFilter flightFilter) {
        List<Predicate> predicates = new ArrayList<>();

        if (flightFilter.getFrom() != null && flightFilter.getTo() != null) {
            Predicate from = criteriaBuilder.equal(root.get("from"), flightFilter.getFrom());
            Predicate to = criteriaBuilder.equal(root.get("to"), flightFilter.getTo());
            predicates.add(criteriaBuilder.and(from,to));
        }

        if (flightFilter.getFirstFlyDate() != null && flightFilter.getSecondFlyDate() != null){
            Predicate flightDateTime = criteriaBuilder.between(root.get("flightDateTime"), flightFilter.getFirstFlyDate(), flightFilter.getSecondFlyDate());
            predicates.add(flightDateTime);
        }

        if ((flightFilter.getMinSalePrice() != null && flightFilter.getMaxSalePrice() != null)){
            Predicate salePrice = criteriaBuilder.between(root.get("salePrice"), flightFilter.getMinSalePrice(), flightFilter.getMaxSalePrice());
            predicates.add(salePrice);
        }
        return predicates;

    }


    private void flightIsExist(Flight flight) {
        findById(flight.getId()).orElseThrow(() -> new NotFoundException(ExceptionEnums.NOT_FOUND, "Flight", flight.getId()));
    }
}
