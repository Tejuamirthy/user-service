package com.tripshorts.userservice.services;


import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;

import java.security.Principal;
import java.util.List;

public interface FollowService {
    UserDTO follow(String username, String currUsername) throws UserNotFound;
    UserDTO unfollow(String username, String currUsername) throws UserNotFound;
    List<UserDTO> getUserFollowers(String username) throws UserNotFound;
    List<UserDTO> getUserFollowing(String username) throws UserNotFound;
//    List<Long> getUserById(int id);
}
