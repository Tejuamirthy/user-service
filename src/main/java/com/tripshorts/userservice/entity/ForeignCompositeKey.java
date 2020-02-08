//package com.tripshorts.userservice.entity;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.persistence.Embeddable;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//
//@Embeddable
//public class ForeignCompositeKey implements Serializable {
//    @NotNull
//    private Long id;
//    @NotNull
//    private Long followerId;
//
//
//    public ForeignCompositeKey() {
//
//    }
//
//    public ForeignCompositeKey(Long id, Long followerId) {
//        this.id = id;
//        this.followerId = followerId;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getFollowerId() {
//        return followerId;
//    }
//
//    public void setFollowerId(Long followerId) {
//        this.followerId = followerId;
//    }
//}