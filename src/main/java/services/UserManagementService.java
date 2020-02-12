package services;

import model.User;

import java.util.Optional;

public interface UserManagementService {

    void saveUser(User user);

    void deleteUserByUserId(long userId);

    boolean isUserLoginExist(String login);

    boolean isUserValid(String login, String password);

    Optional<User> getUserById(long userId);

    Optional<User> getUserByLogin(String userLogin);

}
