//package com.tripshorts.userservice.controllers;
//
//import com.tripshorts.userservice.exceptions.PlaceNotFound;
//import com.tripshorts.userservice.exceptions.UserAlreadyExists;
//import com.tripshorts.userservice.exceptions.UserNotFound;
//import com.tripshorts.userservice.model.UserDTO;
//import com.tripshorts.userservice.services.FollowService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class FollowController {
//
//    @Autowired
//    private FollowService followService;
//
//    //follow a user
//    @GetMapping(path = "/user/follow/{username}")
//    public UserDTO followUser(@RequestBody UserDTO userDTO, @PathVariable String username) throws UserNotFound, UserAlreadyExists {
//
//        return followService.followUser(userDTO.getUsername(),username);
//    }
//
////    //follow a place
////    @GetMapping(path = "/follow/place")
////    public boolean followPlace(@RequestParam String place) throws PlaceNotFound {
////        return followService.followPlace(place);
////    }
//
//    //unfollow a user
//    @PostMapping(path = "/user/unfollow/{username}")
//    public UserDTO unfollowUser(@RequestBody UserDTO userDTO, @PathVariable String username) throws UserNotFound, UserAlreadyExists {
//        return followService.unfollowUser(userDTO.getUsername(),username);
//    }
//
//    //get followers for a user
//    @GetMapping(path = "/user/followers/{username}")
//    public List<UserDTO> getFollowers(@PathVariable String username) throws UserNotFound {
//        return followService.getFollowers(username);
//    }
//
//    //get following for a user
//    @GetMapping(path = "/user/following/{username}")
//    public List<UserDTO> getFollowing(@PathVariable String username) throws UserNotFound {
//        return followService.getFollowing(username);
//    }
//}
