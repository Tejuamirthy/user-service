package com.tripshorts.userservice.services;


import com.tripshorts.userservice.exceptions.UserException;
import com.tripshorts.userservice.model.UserDTO;
import java.util.List;

public interface FollowService {
    UserDTO follow(String username, String currUserId) throws UserException;
    UserDTO unfollow(String username, String currUserId) throws UserException;
    List<UserDTO> getUserFollowers(String userId) throws UserException;
    List<UserDTO> getUserFollowing(String userId) throws UserException;
//    List<Long> getUserById(int id);
}
