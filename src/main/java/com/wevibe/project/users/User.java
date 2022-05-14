package com.wevibe.project.users;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Long idUser;

    @Column(nullable = false, unique = true, length = 45, name = "username")
    private String username;

    @Column(nullable = false, unique = true, length = 45, name = "email")
    private String email;

    @Column(nullable = false, length = 64, name = "password")
    private String password;

    @Column(nullable = false, length = 45,name = "role")
    private String roles;

    @Column(nullable = true, name = "enabled")
    private boolean active;

    public User() {

    }

    public User(Long idUser, String username, String email, String password) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getFullName() {
        return getUsername();
    }
}
