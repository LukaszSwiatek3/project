package com.wevibe.project.users.userdetails;

import com.wevibe.project.users.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDetails extends User {

    @Column(name = "first_name", nullable = true)
    private String firstName;
    @Column(name = "last_name", nullable = true)
    private String lastName;
    @Column(name = "address", nullable = true)
    private Integer address;
    @Column(name = "phone_number", nullable = true)
    private Integer phoneNumber;
    @Column(name = "gender", nullable = true)
    private Boolean gender;

    public UserDetails() {

    }

    public UserDetails(String firstName, String lastName, Integer address, Integer phoneNumber, Boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public UserDetails(String username, String email, String password, String roles, Boolean active, String firstName, String lastName, Integer address, Integer phoneNumber, Boolean gender) {
        super(username, email, password, roles, active);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}