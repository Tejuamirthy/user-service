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
public interface FollowRepository extends JpaRepository<FollowersTable, FollowersTable.ForeignCompositeKey> {
    @Query(value = "SELECT * FROM followers f where f.id = :uId ;", nativeQuery = true)
    List<FollowersTable> findByUserEntity(@Param("uId") int l);
//    List<Long> findByUserFollowerEntity(UserEntity userFollowerEntity);

}
