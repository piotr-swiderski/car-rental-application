package services;

import model.Car;
import model.Model;
import model.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface UserCarManagementService {


    boolean isCarRentedById(long id); //

    Set<Car> searchCarByMark(String mark);

    Set<Car> getNotRentalCar();

    void rentCar(long carId, long userId, LocalDate fromDate, LocalDate toData);

    void returnCarById(long rentedCarId, long userId);

    Optional<Car> getCarById(Long Id);


}
