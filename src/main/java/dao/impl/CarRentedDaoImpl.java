package dao.impl;

import dao.AbstractDao;
import dao.CarRentedDao;
import hibernate.util.HibernateUtil;
import model.CarRental;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static services.utils.ServiceUtil.CAR_STATUS_RENTED;

public class CarRentedDaoImpl extends AbstractDao implements CarRentedDao {

    @Override
    public void saveRentedCar(CarRental carRental) {
        hibernateUtil.save(carRental);
    }

    @Override
    public void deleteCarRent(long carRentId) {
        hibernateUtil.delete(CarRental.class, carRentId);
    }

    @Override
    public Set<CarRental> getRentedCarInfo() {
        try {
            TypedQuery<CarRental> query = entityManager.createQuery("SELECT c from CarRental c where c.status = :status", CarRental.class);
            query.setParameter("status", CAR_STATUS_RENTED);
            return new HashSet<>(query.getResultList());
        }catch (NullPointerException e){
            return new HashSet<>();
        }
    }

    @Override
    public Optional<CarRental> getRentedCarById(long rentCarId) {
        try{
            TypedQuery<CarRental> query = entityManager.createQuery("SELECT c from CarRental c where c.id = :id", CarRental.class);
            query.setParameter("id", rentCarId);
            return Optional.of(query.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

}
