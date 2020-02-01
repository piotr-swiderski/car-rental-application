package services;

import model.User;

public interface UserManagementServices {

    void saveUser(User user);

    void deleteUser(User user);

    boolean isUserLoginExist(String login);

    boolean isUserValid(String login, String password);

}
