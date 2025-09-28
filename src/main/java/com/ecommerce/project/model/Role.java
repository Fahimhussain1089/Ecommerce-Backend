package com.ecommerce.project.model;

import jakarta.persistence.*;

//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
//    private Integer roleId;
//
//    @ToString.Exclude
//    @Enumerated(EnumType.STRING)
//    @Column(length = 20, name = "role_name")
//    private AppRole roleName;
//
//    public Role(AppRole roleName) {
//        this.roleName = roleName;
//    }
//}


@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, name = "role_name")
    private AppRole roleName;

    // Default constructor
    public Role() {
    }

    // Constructor with all fields
    public Role(Integer roleId, AppRole roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    // Constructor with only roleName
    public Role(AppRole roleName) {
        this.roleName = roleName;
    }

    // Getters and Setters

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public AppRole getRoleName() {
        return roleName;
    }

    public void setRoleName(AppRole roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                '}';
    }
}
