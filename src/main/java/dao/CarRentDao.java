package dao;

import model.CarRental;

import java.util.Set;

public interface CarRentDao {

    void rentCarRent(CarRental carRental);

    void deleteCarRent(long carRentId);

    Set<CarRental> getRentalCar();

}
