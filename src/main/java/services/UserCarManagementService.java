package services;

import model.Car;
import model.Model;
import model.User;

import java.sql.Date;
import java.util.Set;

public interface UserCarManagementService {


    boolean isCarRentedById(long id); //

    Set<Car> searchCarByMark(String mark);

    Set<Car> getNotRentalCar();

    void rentCar(Car car, User user, Date toData);

    void returnCarById(long rentedCarId, long userId);


}
