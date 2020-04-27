package com.tripshorts.userservice.model;

import com.tripshorts.userservice.entity.Roles;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class UserDTO {

    public void UserDTOValues(String email, String username, String password, Date dateOfBirth, String name, String gender, Long phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }


    private String email;

    private String username;

    private String password;

    private Date dateOfBirth;

    private String name;

    private String gender;

    private Long phoneNumber;

    private Boolean enabled;

    private List<Roles> roles;

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // To enable changing username
    /*
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    */

    // To enable changing emailId
    /*
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    */
}
