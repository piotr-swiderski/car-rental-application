package dao;

import model.Car;

import java.util.Optional;
import java.util.Set;

public interface CarDao {

    void saveCar(Car car);

    void deleteCarById(long carId);

    void setCarStatus(long carId, String status);

    Optional<Car> getCarById(long carId);

    Set<Car> getCarsByMark(String mark);

    Set<Car> getCarsByStatus(String status);

    Optional<Car> getCarByRegistrationNumber(String registrationNumber);

    Set<Car> getAllCars();

}
