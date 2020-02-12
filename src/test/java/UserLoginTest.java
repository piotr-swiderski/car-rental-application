import model.User;
import model.UserRole;
import model.enums.UserRoleEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.UserManagementService;
import services.impl.UserManagementServiceImpl;

import java.util.Optional;


public class UserLoginTest {

    private UserManagementService userManagementService;
    private User userToSave;

    @Before
    public void setUp() {
        userManagementService = new UserManagementServiceImpl();
        userToSave = User.UserBuilder.anUser()
                .withName("usernew")
                .withRole(new UserRole(UserRoleEnum.INDIVIDUAL_CLIENT))
                .withPhone("797051304")
                .withSurname("surname")
                .withPassword("password")
                .withLogin("usernew")
                .withAddress("Address 123")
                .build();
    }

    @Test
    public void should_create_new_user() {
        //given
        userManagementService.saveUser(userToSave);
        //when
        User userFromDB = userManagementService.getUserById(userToSave.getId()).get();
        //then
        Assert.assertEquals(userToSave, userFromDB);
    }

    @Test
    public void should_delete_user() {
        //given
//        userManagementService.saveUser(userToSave);
        String userLogin = "usernew";
        User userByLogin = userManagementService.getUserByLogin(userLogin).get();

        userManagementService.deleteUserByUserId(userByLogin.getId());
        //when
        Optional<User> userById = userManagementService.getUserById(userByLogin.getId());
        //then
        Assert.assertEquals(false, userById.isPresent());
    }

    @Test
    public void should_return_false_because_user_is_not_exist() {
        //given
        String userLogin = "not_exist_user";
        //when
        boolean loginExist = userManagementService.isUserLoginExist(userLogin);
        //then
        Assert.assertEquals(false, loginExist);
    }

    @Test
    public void should_return_true_because_user_is_exist() {
        //given
        userManagementService.saveUser(userToSave);
        //when
        boolean userLoginExist = userManagementService.isUserLoginExist(userToSave.getLogin());
        //then
        Assert.assertEquals(true, userLoginExist);
    }

    @Test
    public void should_return_true_because_login_and_pass_is_valid() {
        //given
//        userManagementService.saveUser(userToSave);
        String password = userToSave.getPassword();
        String login = userToSave.getLogin();
        //when
        boolean userValid = userManagementService.isUserValid(login, password);
        //then
        Assert.assertEquals(true, userValid);
    }

    @Test
    public void should_return_false_because_login_and_pass_is_not_valid() {
        //given
//        userManagementService.saveUser(userToSave);
        String password = userToSave.getPassword() + "wrong";
        String login = userToSave.getLogin();
        //when
        boolean userValid = userManagementService.isUserValid(login, password);
        //then
        Assert.assertEquals(false, userValid);
    }

}
