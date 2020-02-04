import model.*;
import model.enums.EquipmentVersionEnum;
import model.enums.UserRoleEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.AdminCarManagementsService;
import services.UserCarManagementService;
import services.UserManagementService;
import services.impl.AdminCarManagementServiceImpl;
import services.impl.UserCarManagementServiceImpl;
import services.impl.UserManagementServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import static services.utils.ServiceUtil.CAR_STATUS_FREE;

public class UserCarManagementServiceTest {

    private AdminCarManagementsService adminService;
    private UserCarManagementService userService;
    private UserManagementService userManagementService;
    private User user;
    private Car car;
    private Car carSecond;
    private final String MARK = "TOYOTA";
    private final String MARK_TWO = "HONDA";

    @Before
    public void setUp() {
        adminService = new AdminCarManagementServiceImpl();
        userService = new UserCarManagementServiceImpl();
        EquipmentVersion equipmentVersion = new EquipmentVersion();
        equipmentVersion.setEquipmentDescription("FULL VERSION");
        equipmentVersion.setEquipmentName(EquipmentVersionEnum.FULL_VERSION.name());

        Model model = Model.ModelBuilder.aModel()
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

        carSecond = Car.CarBuilder.aCar()
                .withMark(MARK_TWO)
                .withRegistrationNumber("BL1233")
                .withFuel_level(300)
                .withProductionYear(2012)
                .withMode(model)
                .withCarConditionNode("EXTRA")
                .withStatus(CAR_STATUS_FREE)
                .build();

        userManagementService = new UserManagementServiceImpl();
        user = User.UserBuilder.anUser()
                .withName("user")
                .withRole(new UserRole(UserRoleEnum.INDIVIDUAL_CLIENT))
                .withStatus(CAR_STATUS_FREE)
                .withPhone("797051304")
                .withSurname("surname")
                .withPassword("password")
                .withLogin("user")
                .withAddress("Address 123")
                .build();
    }

    @Test
    public void should_return_all_not_rented_cars() {
        //given
        adminService.addCar(car);
        adminService.addCar(carSecond);
        //when
        Set<Car> notRentalCar = userService.getNotRentalCar();
        //then
        Assert.assertEquals(2, notRentalCar.size());

    }

    @Test
    public void should_return_one_searching_car() {
        //given
        adminService.addCar(car);
        adminService.addCar(carSecond);
        //when
        Set<Car> cars = userService.searchCarByMark(MARK);
        //then
        Assert.assertEquals(1, cars.size());
    }

    @Test
    public void should_return_empty_set() {
        Set<Car> emptySet = userService.searchCarByMark("MARK");
        Assert.assertEquals(0, emptySet.size());
    }

    @Test
    public void should_return_one_rented_car() {
        //given
        adminService.addCar(car);
        userManagementService.saveUser(user);
        Set<Car> cars = userService.searchCarByMark(MARK);
        userService.rentCar(car, user, Date.valueOf(LocalDate.of(2020, 12, 12)));
        //when
        Set<CarRental> carRentals = adminService.getRentalCarInfo();
        //then
        Assert.assertEquals(1, carRentals.size());
    }

}
