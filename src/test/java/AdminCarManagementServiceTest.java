import model.Car;
import model.EquipmentVersion;
import model.Model;
import model.enums.EquipmentVersionEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.AdminCarManagementService;
import services.impl.AdminCarManagementServiceImpl;

import java.util.Set;

import static services.utils.ServiceUtil.CAR_STATUS_FREE;
import static services.utils.ServiceUtil.CAR_STATUS_RENTED;

public class AdminCarManagementServiceTest {

    private AdminCarManagementService service;
    private Car car;
    private Car car_second;
    private Model model;
    private  final String MARK = "TOYOTA";


    @Before
    public void setUp() {
        service = new AdminCarManagementServiceImpl();
        EquipmentVersion equipmentVersion = new EquipmentVersion();
        equipmentVersion.setEquipmentDescription("FULL VERSION");
        equipmentVersion.setEquipmentName(EquipmentVersionEnum.FULL_VERSION.name());

        model = Model.ModelBuilder.aModel()
                .withDoorsNumber(4)
                .withEquipmentVersion(equipmentVersion)
                .withName("CORROLA")
                .withSeatsNumber(4)
                .withType("sedan")
                .withGeneration("sedan")
                .build();

        car = Car.CarBuilder.aCar()
                .withMark(MARK)
                .withRegistrationNumber("BL123")
                .withFuel_level(300)
                .withProductionYear(2012)
                .withMode(model)
                .withCarConditionNode("EXTRA")
                .withStatus(CAR_STATUS_FREE)
                .build();

        car_second = Car.CarBuilder.aCar()
                .withMark(MARK)
                .withRegistrationNumber("BL1233")
                .withFuel_level(300)
                .withProductionYear(2012)
                .withMode(model)
                .withCarConditionNode("EXTRA")
                .withStatus(CAR_STATUS_FREE)
                .build();
    }

    @Test
    public void should_add_car() {
        //given
        service.addCar(car);
        //when
        Set<Car> allCars = service.getAllCars();
        //then
        Assert.assertEquals(1, allCars.size());
    }

    @Test
    public void should_returned_one_not_rented_car() {
        //given
        service.addCar(car);
        //when
        Set<Car> notRentedCar = service.getNotRentedCar();
        //then
        Assert.assertEquals(1, notRentedCar.size());
    }

    @Test
    public void should_returned_one_rented_car() {
        //given
        car.setStatus(CAR_STATUS_RENTED);
        service.addCar(car);
        //when
        Set<Car> rentedCar = service.getRentedCar();
        //then
        Assert.assertEquals(1, rentedCar.size());
    }

    @Test
    public void should_return_all_added_cars(){
        //given
        service.addCar(car);
        service.addCar(car_second);
        //when
        Set<Car> allCars = service.getAllCars();
        //then
        Assert.assertEquals(2,allCars.size());
    }

}
