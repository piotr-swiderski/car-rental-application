package services;

import model.User;
import model.UserRole;
import model.enums.UserRoleEnum;
import services.impl.UserManagementServiceImpl;

public class test {

    public static void main(String[] args) {
        UserManagementService userManagementService = new UserManagementServiceImpl();

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

        userManagementService.saveUser(user);

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

        userManagementService.saveUser(user2);

        System.out.println(userManagementService.isUserLoginExist("user"));
        System.out.println(userManagementService.isUserLoginExist("user2"));
        System.out.println(userManagementService.isUserValid("user","haslo123"));
        System.out.println(userManagementService.isUserValid("user","haslo1234"));
    }

}
