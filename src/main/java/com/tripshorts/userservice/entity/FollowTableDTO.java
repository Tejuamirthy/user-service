//package com.tripshorts.userservice.entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Table(name = "followers")
//public class FollowTableDTO {
//
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
//}
//
