package services;

import model.User;

public interface UserManagementService {

    void saveUser(User user);

    void deleteUserByUserId(long userId);

    boolean isUserLoginExist(String login);

    boolean isUserValid(String login, String password);

}
