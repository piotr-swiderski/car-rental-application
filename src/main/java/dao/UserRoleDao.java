package dao;

import model.UserRole;
import model.enums.UserRoleEnum;

import java.util.Set;

public interface UserRoleDao {

    Set<UserRole> getUserRoles();

    void addUserRole(UserRoleEnum userRoleEnum);

}
