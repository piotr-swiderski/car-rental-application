package dao;

import model.Car;

import java.util.Set;

public interface CarDao {

    void saveCar(Car car);

    void deleteCarById(long carId);

    Car getCarById(long carId);

    Set<Car> getCarsByMark(String mark);

    Set<Car> getCarsByStatus(String status);

    Car getCarByRegistrationNumber(String registrationNumber);

    Set<Car> getAllCars();

}
