package com.tripshorts.userservice.services;


import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;

import java.security.Principal;
import java.util.List;

public interface FollowService {
    UserDTO follow(String username, Principal principal) throws UserNotFound;
    UserDTO unfollow(String username, Principal principal) throws UserNotFound;
    List<UserDTO> getFollowers(Principal principal) throws UserNotFound;
    List<UserDTO> getFollowing(Principal principal) throws UserNotFound;
    List<UserDTO> getUserFollowers(String username) throws UserNotFound;
    List<UserDTO> getUserFollowing(String username) throws UserNotFound;
    List<Integer> getUserById(int id);
}
