//package com.tripshorts.userservice.services.implementation;
//
//import com.tripshorts.userservice.entity.UserEntity;
//import com.tripshorts.userservice.model.UserDTO;
//import com.tripshorts.userservice.repositeries.UserRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImplementation implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
//        if(userEntity == null){
//            throw new UsernameNotFoundException("Username Not Found");
//        }
//        UserDTO userDTO = new UserDTO();
//        BeanUtils.copyProperties(userEntity,userDTO);
//        return userDTO;
//    }
//}
