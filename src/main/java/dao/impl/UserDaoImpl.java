package dao.impl;

import dao.UserDao;
import hibernate.util.HibernateUtil;
import model.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UserDaoImpl extends HibernateUtil implements UserDao {


    @Override
    public void saveUser(User user) {
        save(user);
    }

    @Override
    public void deleteUser(long userId) {
        delete(User.class, userId);
    }

    @Override
    public Optional<User> getUserById(long userId) {
        TypedQuery<User> query = getEntityManager().createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", userId);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            TypedQuery<User> query = getEntityManager().createQuery("select u from User u where u.login = :login", User.class);
            query.setParameter("login", login);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
