package com.tripshorts.userservice.services.implementation;

import com.tripshorts.userservice.entity.FollowersTable;
import com.tripshorts.userservice.entity.UserEntity;
import com.tripshorts.userservice.exceptions.UserException;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.repositeries.FollowRepository;
import com.tripshorts.userservice.repositeries.UserRepository;
import com.tripshorts.userservice.services.FollowService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserDTO follow(String username, String currUserId) throws UserException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        Optional<UserEntity> currentUserEntity = userRepository.findById(Long.parseLong(currUserId));
        if(!userEntity.isPresent() || !currentUserEntity.isPresent())
            throw new UserException("User Not Found");
        try {
            FollowersTable resFollowersTable = followRepository.findByUserEntityAndUserFollowingEntity(userEntity.get(), currentUserEntity.get());
            if(resFollowersTable != null)
                throw new UserException("Already following user with username: "+username);
            FollowersTable followersTable = new FollowersTable();
            followersTable.setUserEntity(currentUserEntity.get());
            followersTable.setUserFollowingEntity(userEntity.get());
            followRepository.save(followersTable);
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDTO unfollow(String username, String userId) throws UserException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        Optional<UserEntity> currentUserEntity = userRepository.findById(Long.parseLong(userId));

        if(!userEntity.isPresent() || !currentUserEntity.isPresent())
            throw new UserException("User Not Found");
        try {
            FollowersTable followersTable = followRepository.findByUserEntityAndUserFollowingEntity(currentUserEntity.get(), userEntity.get());
            if(followersTable == null)
                throw new UserException("Not following user with username: "+ username);
            followRepository.delete(followersTable);
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserDTO> getUserFollowers(String userId) throws UserException {
        Optional<UserEntity> userEntity = userRepository.findById(Long.parseLong(userId));
        if(!userEntity.isPresent())
            throw new UserException("Unable to retrieve followers: User not found");
        List<FollowersTable> followersTableList = followRepository.findByUserFollowingEntity(userEntity.get());
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(FollowersTable followersTableEntry: followersTableList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(followersTableEntry.getUserEntity(), userDTO);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getUserFollowing(String userId) throws UserException {
        Optional<UserEntity> userEntity = userRepository.findById(Long.parseLong(userId));
        if(!userEntity.isPresent())
            throw new UserException("Unable to retrieve following: User not found");
        List<FollowersTable> followersTableList = followRepository.findByUserEntity(userEntity.get());
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        for(FollowersTable followersTableEntry: followersTableList) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(followersTableEntry.getUserFollowingEntity(), userDTO);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

}
