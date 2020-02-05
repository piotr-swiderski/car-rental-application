package services;

import model.*;
import model.enums.EquipmentVersionEnum;
import model.enums.UserRoleEnum;
import services.impl.AdminCarManagementServiceImpl;
import services.impl.UserCarManagementServiceImpl;
import services.impl.UserManagementServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import static services.utils.ServiceUtil.CAR_STATUS_FREE;

public class test {

    public static void main(String[] args) {
        UserManagementService userLogin = new UserManagementServiceImpl();
        AdminCarManagementService adminService = new AdminCarManagementServiceImpl();
        UserCarManagementService userManagementService = new UserCarManagementServiceImpl();

        User user = User.UserBuilder.anUser()
                .withName("user")
                .withRole(new UserRole(UserRoleEnum.INDIVIDUAL_CLIENT))
                .withStatus("okej")
                .withPhone("797051304")
                .withSurname("Swiderski")
                .withPassword("haslo123")
                .withLogin("user")
                .withAddress("Siemien 14")
                .build();

        userLogin.saveUser(user);

        User user2 = User.UserBuilder.anUser()
                .withName("user123")
                .withRole(new UserRole(UserRoleEnum.INDIVIDUAL_CLIENT))
                .withStatus("okej")
                .withPhone("797051304")
                .withSurname("Swiderski")
                .withPassword("haslo123")
                .withLogin("user123")
                .withAddress("Siemien 14")
                .build();

        userLogin.saveUser(user2);

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

        Car car = Car.CarBuilder.aCar()
                .withMark("TOYOTA")
                .withRegistrationNumber("BL1243")
                .withFuel_level(300)
                .withProductionYear(2012)
                .withMode(model)
                .withCarConditionNode("EXTRA")
                .withStatus(CAR_STATUS_FREE)
                .build();

        Car car2 = Car.CarBuilder.aCar()
                .withMark("TOYOTA")
                .withRegistrationNumber("BL123")
                .withFuel_level(300)
                .withProductionYear(2012)
                .withMode(model)
                .withCarConditionNode("EXTRA")
                .withStatus(CAR_STATUS_FREE)
                .build();

        System.out.println(userLogin.isUserLoginExist("user"));
        System.out.println(userLogin.isUserLoginExist("user2"));
        System.out.println(userLogin.isUserValid("user", "haslo123"));
        System.out.println(userLogin.isUserValid("user", "haslo1234"));

        adminService.addCar(car);
        adminService.addCar(car2);
        userLogin.saveUser(user);

        userManagementService.rentCar(car, user, Date.valueOf(LocalDate.of(2020, 12, 12)));
        Set<CarRental> carRentals = adminService.getRentalCarsInformation();

        System.out.println(adminService.isCarRegistrationNumberExist("dsadasd"));


    }

}
