package com.tripshorts.userservice.controllers;

import com.tripshorts.userservice.entity.UserEntity;
import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.LoginRequest;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping(path = "/user/{username}")
    public UserDTO findUserByUsername(@PathVariable String username) throws UserNotFound {
        return loginService.findUserByUsername(username);
    }

    @GetMapping(path = "/user/id/{id}")
    public UserDTO findUserById(@PathVariable Long id) throws UserNotFound {
        return loginService.findUserById(id);
    }

    @GetMapping(path = "/user/email/{email}")
    public UserDTO findUserByEmail(@PathVariable String email) throws UserNotFound {
        return loginService.findUserByEmail(email);
    }

//    @GetMapping(path = "/gender/{gender}")
//    public List<UserDTO> findUsersByGender(@PathVariable String gender) throws UserNotFound {
//        return loginService.findUsersByGender(gender);
//    }

//    @GetMapping(path = "/login")
//    public UserDTO login(@RequestParam String username, @RequestParam String password) throws UserNotFound {
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(username);
//        loginRequest.setPassword(password);
//        return loginService.login(loginRequest);
//    }

//    @PostMapping(name = "/signup", consumes = "application/json")
//    public UserDTO signUp(@RequestBody UserDTO userDTO) throws UserAlreadyExists {
//        return loginService.signUp(userDTO);
//    }

    @PostMapping(path = "/signup")
    public UserDTO signUp(@RequestBody UserDTO userDTO) throws UserAlreadyExists {
        return loginService.signUp(userDTO);
    }

    @PostMapping(path = "/user/updateprofile", consumes = "application/json")
    public UserDTO updateProfile(@RequestBody UserDTO userDTO) throws UserNotFound {
        return loginService.updateUserDetails(userDTO);
    }

    @GetMapping(path = "/getuserroles")
    public List<String> getUserRoles(@RequestParam String username) throws UserNotFound {
        return loginService.getUserRoles(username);
    }

}
