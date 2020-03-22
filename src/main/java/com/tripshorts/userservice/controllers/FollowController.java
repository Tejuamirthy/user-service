package com.tripshorts.userservice.controllers;

import com.tripshorts.userservice.exceptions.PlaceNotFound;
import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    // TODO
    //follow a user
    @GetMapping(path = "/user/follow/{username}")
    public UserDTO followUser(@PathVariable String username, Principal principal) throws UserNotFound, UserAlreadyExists {

        return followService.follow(username, principal);
    }

//    //follow a place
//    @GetMapping(path = "/follow/place")
//    public boolean followPlace(@RequestParam String place) throws PlaceNotFound {
//        return followService.followPlace(place);
//    }

    // TODO
    //unfollow a user
    @PostMapping(path = "/user/unfollow/{username}")
    public UserDTO unfollowUser(@PathVariable String username, Principal principal) throws UserNotFound, UserAlreadyExists {
        return followService.unfollow(username, principal);
    }

    // TODO
    //get followers for current logged in user
    @GetMapping(path = "/followers/")
    public List<UserDTO> getFollowers(Principal principal) throws UserNotFound {
        return followService.getFollowers(principal);
    }

    // TODO
    //get following for current logged in user
    @GetMapping(path = "/{username}/following/")
    public List<UserDTO> getFollowing(@PathVariable String username) throws UserNotFound {
        return followService.getUserFollowing(username);
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


}
