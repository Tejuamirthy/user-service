package com.tripshorts.userservice.services.implementation;

import com.tripshorts.userservice.entity.FollowersTable;
import com.tripshorts.userservice.entity.UserEntity;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.repositeries.FollowRepository;
import com.tripshorts.userservice.repositeries.UserRepository;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FollowServiceImplementation implements FollowService {

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO follow(String username, String currUsername) throws UserNotFound {
        return null;
    }

    @Override
    public UserDTO unfollow(String username, String currUsername) throws UserNotFound {
        return null;
    }

    @Override
    public List<UserDTO> getUserFollowers(String username) throws UserNotFound {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if(!userEntity.isPresent())
            throw new UserNotFound("Unable to retrieve followers: User not found");
        List<FollowersTable> followersTableList = followRepository.findByUserFollowerEntity(userEntity.get());
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(FollowersTable followersTableEntry: followersTableList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(followersTableEntry.getUserEntity(), userDTO);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getUserFollowing(String username) throws UserNotFound {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        if(!userEntity.isPresent())
            throw new UserNotFound("Unable to retrieve followers: User not found");
        List<FollowersTable> followersTableList = followRepository.findByUserEntity(userEntity.get());
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(FollowersTable followersTableEntry: followersTableList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(followersTableEntry.getUserFollowerEntity(), userDTO);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

//    @Override
//    public List<Long> getUserById(Long id) {
//        return followRepository.findById(id);
//    }
}
