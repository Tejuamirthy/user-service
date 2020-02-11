package com.tripshorts.userservice.controllers;

import com.tripshorts.userservice.exceptions.PlaceNotFound;
import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

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

    //unfollow a user
    @PostMapping(path = "/user/unfollow/{username}")
    public UserDTO unfollowUser(@PathVariable String username, Principal principal) throws UserNotFound, UserAlreadyExists {
        return followService.unfollow(username, principal);
    }

    //get followers for a user
    @GetMapping(path = "/followers/")
    public List<UserDTO> getFollowers(Principal principal) throws UserNotFound {
        return followService.getFollowers(principal);
    }

    //get following for a user
    @GetMapping(path = "/following/")
    public List<UserDTO> getFollowing(Principal principal) throws UserNotFound {
        return followService.getFollowing(principal);
    }


    //get followers for a user
    @GetMapping(path = "/{username}/followers/")
    public List<UserDTO> getUserFollowers(@PathVariable String username) throws UserNotFound {
        return followService.getUserFollowers(username);
    }

    //get following for a user
    @GetMapping(path = "/{username}/following/")
    public List<UserDTO> getUserFollowing(@PathVariable String username) throws UserNotFound {
        return followService.getUserFollowing(username);
    }

    @GetMapping(path = "/getfollowing/{id}")
    public List<Integer> getFollowersById(@PathVariable Integer id) throws UserNotFound {
        return followService.getUserById(id);
    }
}
