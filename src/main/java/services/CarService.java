package services;

import model.Car;
import model.Model;
import java.util.Set;

public interface CarService {

    void addCar(Car car);

    boolean isCarRentedByRegistration(String registration);

    boolean isCarRentedById(long id);

    Set<Car> searchCarByMark(String mark);

    Set<Car> getNotRentalCar();

    Set<Car> getAllCars();

    void deletedCarById(long id);

    void rentCarById(long id);

    void rentCarByRegistrationNumber(String registration);

    void returnCarById(long id);

    void returnCarByRegistrationNumber(String registration);

    Model getModelOfCarByRegistration(String registration);



}
