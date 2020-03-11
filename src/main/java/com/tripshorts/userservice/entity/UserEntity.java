package com.tripshorts.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {

    public void UserEntityValues(String email, String username, String password, Date dateOfBirth, String name, String gender, Long phoneNumber) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "username",unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phoneNumber")
    private Long phoneNumber;

    @JsonIgnoreProperties
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles",joinColumns = @JoinColumn(name = "id"))
    List<Roles> roles;


//    @JsonIgnoreProperties
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "followers", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))//ame = "followers",joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
//    List<UserEntity> followers;

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

    @Column(name = "enabled")
    private Boolean enabled;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
