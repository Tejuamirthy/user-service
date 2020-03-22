package com.tripshorts.userservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "followers")
public class FollowersTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "from_id", referencedColumnName = "id", insertable = false)
    private UserEntity userEntity;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "to_id", referencedColumnName = "id", insertable = false)
    private UserEntity userFollowerEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

