package dao.impl;

import dao.AbstractDao;
import dao.CarDao;
import hibernate.util.HibernateUtil;
import model.Car;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CarDaoImpl extends AbstractDao implements CarDao {

    @Override
    public void saveCar(Car car) {
        hibernateUtil.save(car);
    }

    @Override
    public void deleteCarById(long carId) {
        hibernateUtil.delete(Car.class, carId);
    }

    @Override
    public void setCarStatus(long carId, String status) {
        Car carById = getCarById(carId).get();
        carById.setStatus(status);
        hibernateUtil.getEntityManager().merge(carById);
    }

    @Override
    public Optional<Car> getCarById(long carId) {
        try {
            TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.id = :carId", Car.class);
            query.setParameter("carId", carId);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Set<Car> getCarsByMark(String mark) {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.mark = :mark", Car.class);
        query.setParameter("mark", mark);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Set<Car> getCarsByStatus(String status) {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.status = :status", Car.class);
        query.setParameter("status", status);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Optional<Car> getCarByRegistrationNumber(String registrationNumber) {
        try {
            TypedQuery<Car> query = entityManager.createQuery("select c from Car c where c.registrationNumber = :registration", Car.class);
            query.setParameter("registration", registrationNumber);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Set<Car> getAllCars() {
        TypedQuery<Car> query = entityManager.createQuery("select c from Car c", Car.class);
        return new HashSet<>(query.getResultList());
    }

}
