package services.impl;

import dao.CarDao;
import dao.impl.CarDaoImpl;
import model.Car;
import model.Model;
import services.CarService;

import java.util.Set;

public class CarManagementServiceImpl implements CarService {

    private CarDao carDao;
    private final String FREE_CAR_STATUS = "FREE";
    private final String RENT_CAR_STATUS = "RENT";

    public CarManagementServiceImpl() {
        this.carDao = new CarDaoImpl();
    }

    @Override
    public void addCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public boolean isCarRentedByRegistration(String registration) {
        Car car = carDao.getCarByRegistrationNumber(registration);
        return car.getStatus().equals(FREE_CAR_STATUS);
    }

    @Override
    public boolean isCarRentedById(long id) {
        Car car = carDao.getCarById(id);
        return car.getStatus().equals(FREE_CAR_STATUS);
    }

    @Override
    public Set<Car> searchCarByMark(String mark) {
        return carDao.getCarsByMark(mark);
    }

    @Override
    public Set<Car> getNotRentalCar() {
        return carDao.getNoRentalCar();
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
    public void rentCarById(long id) {
        Car car = carDao.getCarById(id);
        setStatusCar(car, RENT_CAR_STATUS);
    }

    @Override
    public void rentCarByRegistrationNumber(String registration) {
        Car car = carDao.getCarByRegistrationNumber(registration);
        setStatusCar(car, RENT_CAR_STATUS);
    }

    @Override
    public void returnCarById(long id) {
        Car car = carDao.getCarById(id);
        setStatusCar(car, FREE_CAR_STATUS);
    }

    @Override
    public void returnCarByRegistrationNumber(String registration) {
        Car car = carDao.getCarByRegistrationNumber(registration);
        setStatusCar(car, FREE_CAR_STATUS);
    }

    @Override
    public Model getModelOfCarByRegistration(String registration) {
        Car car = carDao.getCarByRegistrationNumber(registration);
        return car.getModel();
    }

    private void setStatusCar(Car car, String status) {
        car.setStatus(RENT_CAR_STATUS);
        carDao.deleteCarById(car.getId());
        carDao.saveCar(car);
    }
}
