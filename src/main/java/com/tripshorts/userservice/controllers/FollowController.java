package com.tripshorts.userservice.controllers;

import com.tripshorts.userservice.exceptions.UserException;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDTO followUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "followUsername") String username) throws UserException {
        return followService.follow(username, userId);
    }

    @GetMapping(path = "/unfollow")
    public UserDTO unfollowUser(@RequestParam(name = "userId") String userId, @RequestParam(name = "unfollowUsername") String username) throws UserException {
        return followService.unfollow(username, userId);
    }

    @GetMapping(path = "/my-followers")
    public List<UserDTO> getCurrentFollowers(@RequestParam(name = "userId") String userId) throws UserException {
        return followService.getUserFollowers(userId);
    }

    @GetMapping(path = "/my-following")
    public List<UserDTO> getCurrentFollowing(@RequestParam(name = "userId") String userId) throws UserException {
        return followService.getUserFollowing(userId);
    }

    //get following for a user
    @GetMapping(path = "/get-following")
    public List<UserDTO> getUserFollowing(@RequestParam(name = "userId") String userId) throws UserException {
        return followService.getUserFollowing(userId);
    }


    //get followers for a user
    @GetMapping(path = "/get-followers")
    public List<UserDTO> getUserFollowers(@RequestParam(name = "userId") String userId) throws UserException {
        return followService.getUserFollowers(userId);
    }

}
