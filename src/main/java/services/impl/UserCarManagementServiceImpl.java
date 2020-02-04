package services.impl;

import dao.CarDao;
import dao.CarRentedDao;
import dao.UserDao;
import dao.impl.CarDaoImpl;
import dao.impl.CarRentedDaoImpl;
import dao.impl.UserDaoImpl;
import model.Car;
import model.CarRental;
import model.User;
import services.UserCarManagementService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static services.utils.ServiceUtil.*;

public class UserCarManagementServiceImpl implements UserCarManagementService {

    private CarDao carDao;
    private CarRentedDao carRentedDao;
    private UserDao userDao;

    public UserCarManagementServiceImpl() {
        this.carDao = new CarDaoImpl();
        this.carRentedDao = new CarRentedDaoImpl();
        this.userDao = new UserDaoImpl();
    }

    @Override
    public boolean isCarRentedById(long id) {
        Car car = carDao.getCarById(id);
        return car.getStatus().equals(CAR_STATUS_RETURNED);
    }

    @Override
    public Set<Car> searchCarByMark(String mark) {
        return carDao.getCarsByMark(mark);
    }

    @Override
    public Set<Car> getNotRentalCar() {
        return carDao.getCarsByStatus(CAR_STATUS_FREE);
    }


    @Override
    public void rentCar(Car car, User user, Date toData) {
        CarRental carRental = CarRental.CarRentalBuilder.aCarRental()
                .withUser(user)
                .withCar(car)
                .withDateTo(toData)
                .withCharge(200)
                .withStatus(CAR_STATUS_RENTED)
                .build();

        carRentedDao.saveRentedCar(carRental);
    }

    @Override
    public void returnCarById(long rentedCarId, long userId) {
        Optional<CarRental> optionalCar = carRentedDao.getRentedCarById(rentedCarId);
        if (optionalCar.isPresent()) {
            CarRental carRental = optionalCar.get();
            carRentedDao.deleteCarRent(rentedCarId);
            carRental.setStatus(CAR_STATUS_RETURNED);
            carRentedDao.saveRentedCar(carRental);

            Car car = carRental.getCar();
            car.setStatus(CAR_STATUS_FREE);
            carDao.deleteCarById(car.getId());
            carDao.saveCar(car);
        }
    }


    private void setStatusCar(Car car, String status) {
        car.setStatus(status);
        carDao.deleteCarById(car.getId());
        carDao.saveCar(car);
    }
}
