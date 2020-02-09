package com.tripshorts.userservice.services.implementation;

import com.tripshorts.userservice.entity.Roles;
import com.tripshorts.userservice.entity.UserEntity;
import com.tripshorts.userservice.exceptions.UserAlreadyExists;
import com.tripshorts.userservice.exceptions.UserNotFound;
import com.tripshorts.userservice.model.LoginRequest;
import com.tripshorts.userservice.model.UserDTO;
import com.tripshorts.userservice.repositeries.LoginRepository;
import com.tripshorts.userservice.services.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImplementation implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO findUserByUsername(String username) throws UserNotFound {
        Optional<UserEntity> optionalUserEntity = loginRepository.findByUsername(username);
        UserDTO userDTO = null;
        if(optionalUserEntity.isPresent()) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUserEntity.get(), userDTO);
            return userDTO;
        }
        throw new UserNotFound("User Not Found with given Id");
    }

    @Override
    public UserDTO findUserByEmail(String email) throws UserNotFound {
        Optional<UserEntity> optionalUserEntity = loginRepository.findByEmail(email);
        UserDTO userDTO = new UserDTO();
        if(!optionalUserEntity.isPresent())
            throw new UserNotFound("User not found with email");
        BeanUtils.copyProperties(optionalUserEntity, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(Long id) throws UserNotFound {
        Optional<UserEntity> optionalUserEntity = loginRepository.findById(id);
        UserDTO userDTO = null;
        if(optionalUserEntity.isPresent()) {
            userDTO = new UserDTO();
            BeanUtils.copyProperties(optionalUserEntity.get(), userDTO);
            return userDTO;
        }
        throw new UserNotFound("User Not Found with given Id");
    }

    @Override
    public UserDTO login(LoginRequest loginRequest) throws UserNotFound {
        return null;
    }

    @Override
    public UserDTO signUp(UserDTO userDTO) throws UserAlreadyExists {

        try {
            findUserByUsername(userDTO.getUsername());
            throw new UserAlreadyExists("Username already Exists");
        } catch (UserNotFound userNotFound) {

            try {
                findUserByEmail(userDTO.getEmail());
                throw new UserAlreadyExists("Email already Exists");
            } catch (UserNotFound notFound) {
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userDTO, userEntity);
                userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
                loginRepository.save(userEntity);
                return userDTO;
            }

        }
    }


    @Override
    public UserDTO updateUserDetails(UserDTO userDTO) throws UserNotFound {
        UserEntity userEntity = loginRepository.findByUsername(userDTO.getUsername()).orElse(null);
        if(userEntity != null) {
            Long id = userEntity.getId();
            BeanUtils.copyProperties(userDTO, userEntity);
            userEntity.setId(id);
            loginRepository.save(userEntity);
            return  userDTO;
        }
        throw new UserNotFound("Given user not found");
    }

    @Override
    public List<String> getUserRoles(String username) throws UserNotFound {
        UserEntity userEntity = loginRepository.findByUsername(username).orElse(null);
        if(userEntity == null) {
            throw new UserNotFound("User name not found");
        }
        List<String> stringList = new ArrayList<>();
        userEntity.getRoles().forEach(role -> stringList.add(role.getRole()));
        return stringList;
    }

}
