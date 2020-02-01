package model;

import model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private UserRoleEnum name;

    public UserRole() {
    }

    public UserRole(UserRoleEnum name){
        this.name = name;
    }

}
