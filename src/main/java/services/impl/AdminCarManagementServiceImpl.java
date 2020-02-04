package services.impl;

import dao.CarDao;
import dao.CarRentedDao;
import dao.impl.CarDaoImpl;
import dao.impl.CarRentedDaoImpl;
import model.Car;
import model.CarRental;
import services.AdminCarManagementService;

import java.util.Set;

import static services.utils.ServiceUtil.CAR_STATUS_FREE;
import static services.utils.ServiceUtil.CAR_STATUS_RENTED;

public class AdminCarManagementServiceImpl implements AdminCarManagementService {

    CarDao carDao;
    CarRentedDao carRentedDao;

    public AdminCarManagementServiceImpl() {
        carDao = new CarDaoImpl();
        carRentedDao = new CarRentedDaoImpl();
    }

    @Override
    public void deletedCarById(long id) {
        carDao.deleteCarById(id);
    }

    @Override
    public Set<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public void addCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public Set<Car> getNotRentedCar() {
        return carDao.getCarsByStatus(CAR_STATUS_FREE);
    }

    @Override
    public Set<Car> getRentedCar() {
        return carDao.getCarsByStatus(CAR_STATUS_RENTED);
    }

    @Override
    public Set<CarRental> getRentalCarInfo() {
        return carRentedDao.getRentedCarInfo();
    }
}
