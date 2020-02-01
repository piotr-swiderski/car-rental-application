package services.impl;

import dao.UserDao;
import model.User;
import model.UserRole;
import services.UserManagementService;

import java.util.Optional;

public class UserManagementServiceImpl implements UserManagementService {

    private UserDao userDao;
    private UserRole userRole;

    public UserManagementServiceImpl(UserDao userDao, UserRole userRole) {
        this.userDao = userDao;
        this.userRole = userRole;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserByUserId(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public boolean isUserLoginExist(String login) {
        Optional<User> userByLogin = userDao.getUserByLogin(login);
        return userByLogin.isPresent();
    }

    @Override
    public boolean isUserValid(String login, String password) {
        Optional<User> user = userDao.getUserByLogin(login);
        return user.map(value -> value.getPassword().equals(password)).orElse(false);
    }
}
