package dao;

import model.User;

public interface UserDao {

    void saveUser(User user);

    void deleteUser(long userId);

    User getUserById(long userId);



}
