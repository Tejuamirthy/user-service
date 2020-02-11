package com.tripshorts.userservice.services.implementation;

import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.repositeries.FollowRepository;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class FollowServiceImplementation implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Override
    public UserDTO follow(String username, Principal principal) throws UserNotFound {
        return null;
    }

    @Override
    public UserDTO unfollow(String username, Principal principal) throws UserNotFound {
        return null;
    }

    @Override
    public List<UserDTO> getFollowers(Principal principal) throws UserNotFound {
        return null;
    }

    @Override
    public List<UserDTO> getFollowing(Principal principal) throws UserNotFound {
        return null;
    }

    @Override
    public List<UserDTO> getUserFollowers(String username) throws UserNotFound {
        return null;
    }

    @Override
    public List<UserDTO> getUserFollowing(String username) throws UserNotFound {
        return null;
    }

    @Override
    public List<Integer> getUserById(int id) {
        return followRepository.findById(id);
    }
}
