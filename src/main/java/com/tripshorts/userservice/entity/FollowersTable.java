package com.tripshorts.userservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "followers")
@IdClass(value = FollowersTable.ForeignCompositeKey.class)
public class FollowersTable {


    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "follower_id", referencedColumnName = "user_id")
    private UserEntity userFollowerEntity;

//    @EmbeddedId
//    @AttributeOverride(name = "followerId", column=@Column(name = "follower_id"))
//    private ForeignCompositeKey foreignCompositeKey;
//
//    public ForeignCompositeKey getForeignCompositeKey() {
//        return foreignCompositeKey;
//    }
//
//    public void setForeignCompositeKey(ForeignCompositeKey foreignCompositeKey) {
//        this.foreignCompositeKey = foreignCompositeKey;
//    }



    public static class ForeignCompositeKey implements Serializable {
        private UserEntity userEntity;
        private UserEntity userFollowerEntity;

        public UserEntity getUserEntity() {
            return userEntity;
        }

        public void setUserEntity(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        public UserEntity getUserFollowerEntity() {
            return userFollowerEntity;
        }

        public void setUserFollowerEntity(UserEntity userFollowerEntity) {
            this.userFollowerEntity = userFollowerEntity;
        }

        //        private Long id;
//        private Long followerId;
//
//        public ForeignCompositeKey(Long id, Long followerId) {
//            this.id = id;
//            this.followerId = followerId;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public Long getFollowerId() {
//            return followerId;
//        }
//
//        public void setFollowerId(Long followerId) {
//            this.followerId = followerId;
//        }
    }


}

