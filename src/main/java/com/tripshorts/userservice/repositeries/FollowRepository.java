package com.tripshorts.userservice.repositeries;

import com.tripshorts.userservice.entity.FollowersTable;
import com.tripshorts.userservice.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<FollowersTable, FollowersTable.ForeignCompositeKey> {
    List<Long> findById(int id);
    List<Long> findByFollowerId(int id);
}
