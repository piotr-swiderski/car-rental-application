package dao;

import model.CarRental;

import java.util.Optional;
import java.util.Set;

public interface CarRentedDao {

    void saveRentedCar(CarRental carRental);

    Optional<CarRental> getRentedCarById(long rentCarId);

    void deleteCarRent(long carRentId);

    Set<CarRental> getRentedCarInfo();

}
