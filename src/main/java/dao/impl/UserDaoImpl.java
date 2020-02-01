package dao.impl;

import dao.UserDao;
import hibernate.util.HibernateUtil;
import model.User;

import javax.persistence.TypedQuery;

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
    public User getUserById(long userId) {
        TypedQuery<User> query = getEntityManager().createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", userId);
        return query.getSingleResult();
    }
}
