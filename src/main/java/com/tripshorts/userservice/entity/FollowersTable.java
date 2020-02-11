package com.tripshorts.userservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "followers")
@IdClass(value = FollowersTable.ForeignCompositeKey.class)
public class FollowersTable {


    @Id
    @JoinColumn(referencedColumnName = "id")
    private UserEntity userEntity;

    @Id
    @Column(name = "follower_id")
    private Long followerId;

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
        private Long id;
        private Long followerId;

        public ForeignCompositeKey(Long id, Long followerId) {
            this.id = id;
            this.followerId = followerId;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getFollowerId() {
            return followerId;
        }

        public void setFollowerId(Long followerId) {
            this.followerId = followerId;
        }
    }


}

