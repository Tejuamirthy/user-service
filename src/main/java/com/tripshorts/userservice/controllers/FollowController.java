package com.tripshorts.userservice.controllers;

import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

//    //follow a place
//    @GetMapping(path = "/follow/place")
//    public boolean followPlace(@RequestParam String place) throws PlaceNotFound {
//        return followService.followPlace(place);
//    }

    @GetMapping(path = "/follow")
    public UserDTO followUser(@RequestParam(name = "username") String username) throws UserNotFound, UserAlreadyExists {
        UserDTO userDTO = getCurrentUser();
        if(userDTO == null)
            throw new UserNotFound("User not logged in");
        return followService.follow(username, userDTO.getUsername());
    }

    @GetMapping(path = "/unfollow")
    public UserDTO unfollowUser(@RequestParam(name = "username") String username) throws UserNotFound, UserAlreadyExists {
        UserDTO userDTO = getCurrentUser();
        if(userDTO == null)
            throw new UserNotFound("User not logged in");
        return followService.unfollow(username, userDTO.getUsername());
    }

    @GetMapping(path = "/my-followers")
    public List<UserDTO> getCurrentFollowers() throws UserNotFound {
        UserDTO userDTO = getCurrentUser();
        if(userDTO == null)
            throw new UserNotFound("User not logged in");
        return followService.getUserFollowers(userDTO.getUsername());
    }

    @GetMapping(path = "/my-following")
    public List<UserDTO> getCurrentFollowing() throws UserNotFound {
        UserDTO userDTO = getCurrentUser();
        if(userDTO == null)
            throw new UserNotFound("User not logged in");
        return followService.getUserFollowing(userDTO.getUsername());
    }

    //get following for a user
    @GetMapping(path = "/get-following")
    public List<UserDTO> getUserFollowing(@RequestParam(name = "username") String username) throws UserNotFound {
        return followService.getUserFollowing(username);
    }


    //get followers for a user
    @GetMapping(path = "/get-followers")
    public List<UserDTO> getUserFollowers(@RequestParam(name = "username") String username) throws UserNotFound {
        return followService.getUserFollowers(username);
    }

    private UserDTO getCurrentUser() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(obj != null)
            return (UserDTO) obj;
        return null;
    }
}
