package services;

import model.Car;
import model.CarRental;

import java.util.Set;

public interface AdminCarManagementService {

    void addCar(Car car);

    void deletedCarById(long id);

    boolean isCarRegistrationNumberExist(String carRegistrationNumber);

    Set<Car> getAllCars();

    Set<Car> getNotRentedCar();

    Set<Car> getRentedCar();

    Set<CarRental> getRentalCarsInformation();

}
