package dao;

import model.User;
import java.util.Optional;

public interface UserDao {

    void saveUser(User user);

    void deleteUser(long userId);

    Optional<User> getUserById(long userId);

    Optional<User> getUserByLogin(String login);



}
