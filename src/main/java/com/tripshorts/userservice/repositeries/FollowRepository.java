package com.tripshorts.userservice.repositeries;

import com.tripshorts.userservice.entity.FollowersTable;
import com.tripshorts.userservice.entity.UserEntity;
import com.tripshorts.userservice.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<FollowersTable, Long> {

    // To get the followers with user id as "id"
    @Query(value = "SELECT * FROM followers f where f.from_id = :uId ;", nativeQuery = true)
    List<FollowersTable> findFollowingById(@Param("uId") long id);

    @Query(value = "SELECT * FROM followers f where f.to_id = :uId ;", nativeQuery = true)
    List<FollowersTable> findFollowersById(@Param("uId") long id);

    List<FollowersTable> findByUserEntity(UserEntity userEntity);
    List<FollowersTable> findByUserFollowerEntity(UserEntity userEntity);
    FollowersTable findByUserEntityAndUserFollowerEntity(UserEntity userEntity, UserEntity userFollowerEntity);
}
