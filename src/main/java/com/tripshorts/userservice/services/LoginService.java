package com.tripshorts.userservice.services;

import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.LoginRequest;
import com.tripshorts.userservice.model.UserDTO;

import java.security.Principal;
import java.util.List;

public interface LoginService {
    UserDTO findUserByUsername(String username) throws UserNotFound;
    UserDTO findUserByEmail(String email) throws UserNotFound;
    UserDTO findUserById(Long id) throws UserNotFound;
    UserDTO login(LoginRequest loginRequest) throws UserNotFound;
    UserDTO signUp(UserDTO userDTO) throws UserAlreadyExists;
    UserDTO updateUserDetails(UserDTO userDTO) throws UserNotFound;
    List<String> getUserRoles(String username) throws UserNotFound;
}
