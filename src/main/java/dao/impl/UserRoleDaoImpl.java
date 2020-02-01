package dao.impl;

import dao.UserRoleDao;
import hibernate.util.HibernateUtil;
import model.UserRole;
import model.enums.UserRoleEnum;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

public class UserRoleDaoImpl extends HibernateUtil implements UserRoleDao {


    @Override
    public Set<UserRole> getUserRoles() {
        TypedQuery<UserRole> query = getEntityManager().createQuery("select r from UserRole r", UserRole.class);
        return new HashSet<>(query.getResultList());
    }

    @Override
    public void addUserRole(UserRoleEnum userRoleEnum) {
        save(userRoleEnum);
    }
}
