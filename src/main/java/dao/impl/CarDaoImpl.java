package dao.impl;

import dao.CarDao;
import hibernate.util.HibernateUtil;
import model.Car;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class CarDaoImpl extends HibernateUtil implements CarDao {
    @Override
    public void saveCar(Car car) {
        save(car);
    }

    @Override
    public void deleteCarById(long carId) {
        delete(Car.class, carId);
    }

    @Override
    public Car getCarById(long carId) {
        TypedQuery<Car> query = getEntityManager().createQuery("select c from Car c where c.id = :id", Car.class);
        query.setParameter("id", carId);
        return query.getSingleResult();
    }

    @Override
    public Set<Car> getCarsByMark(String mark) {
        TypedQuery<Car> query = getEntityManager().createQuery("select c from Car c where c.mark = :mark", Car.class);
        query.setParameter("mark", mark);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Set<Car> getCarsByStatus(String status) {
        TypedQuery<Car> query = getEntityManager().createQuery("select c from Car c where c.status = :status", Car.class);
        query.setParameter("status", status);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public Car getCarByRegistrationNumber(String registrationNumber) {
        TypedQuery<Car> query = getEntityManager().createQuery("select c from Car c where c.registrationNumber = :registration", Car.class);
        query.setParameter("registration", registrationNumber);
        return query.getSingleResult();
    }

    @Override
    public Set<Car> getAllCars() {
        TypedQuery<Car> query = getEntityManager().createQuery("select c from Car c", Car.class);
        return new HashSet<>(query.getResultList());
    }
}
