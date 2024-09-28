package com.example.demo.entities;

import javax.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.UUID;

@Entity
@Table(name = "AUTH_AUTHORITY")
public class Authority implements GrantedAuthority {

    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ROLE_CODE", unique = true, nullable = false)
    private String roleCode;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;

    @PrePersist
    protected void onCreate() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String getAuthority() {
        return roleCode;
    }

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}










//package com.example.demo.entities;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.UUID;
//
//@Table(name = "AUTH_AUTHORITY")
//@Entity
//public class Authority implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private UUID id;
//
//    @Column(name = "ROLE_CODE")
//    private String roleCode;
//
//    @Column(name = "ROLE_DESCRIPTION")
//    private String roleDescription;
//
//
//
//    @Override
//    public String getAuthority() {
//        // TODO Auto-generated method stub
//        return roleCode;
//    }
//
//
//
//    public UUID getId() {
//        return id;
//    }
//
//
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//
//
//    public String getRoleCode() {
//        return roleCode;
//    }
//
//
//
//    public void setRoleCode(String roleCode) {
//        this.roleCode = roleCode;
//    }
//
//
//
//    public String getRoleDescription() {
//        return roleDescription;
//    }
//
//
//
//    public void setRoleDescription(String roleDescription) {
//        this.roleDescription = roleDescription;
//    }
//
//
//
//}
//
