package dao.impl;

import dao.CarRentDao;
import hibernate.util.HibernateUtil;
import model.CarRental;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class CarRentDaoImpl extends HibernateUtil implements CarRentDao {

    private static final String STATUS_CAR_RENTED = "RENTED";

    @Override
    public void rentCarRent(CarRental carRental) {
        save(carRental);
    }

    @Override
    public void deleteCarRent(long carRentId) {
        delete(CarRental.class, carRentId);
    }

    @Override
    public Set<CarRental> getRentalCar() {
        TypedQuery<CarRental> query = getEntityManager().createQuery("SELECT c from CarRental c where c.status = :status ", CarRental.class);
        query.setParameter("status", STATUS_CAR_RENTED);
        return new HashSet<>(query.getResultList());
    }
}
