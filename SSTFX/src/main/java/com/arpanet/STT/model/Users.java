package com.arpanet.STT.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    private Long id ;
    @Column(name = "name")
    private String name;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "followers_count")
    private Integer followersCount;
    @Column(name = "friends_count")
    private Integer friendsCount;
    @Column(name = "tweet_count")
    private Integer tweetCount;
    @Column(name = "user_path")
    private String userPath;
    @Column
    private Date date;

    public Users(){}

    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String setUserName(String userName) {
        this.userName = userName;
        return userName;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public Date getDate() {
        return date;
    }

    public Date setDate(Date date) {
        this.date = date;
        return date;
    }

    public Integer setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
        return followersCount;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public Integer setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
        return friendsCount;
    }

    public Integer getTweetCount() {
        return tweetCount;
    }

    public Integer setTweetCount(Integer tweetCount) {
        this.tweetCount = tweetCount;
        return tweetCount;
    }

    public String getUserPath() {
        return userPath;
    }

    public String setUserPath(String userPath) {
        this.userPath = userPath;
        return userPath;
    }

    public Users(Long id, String name, String userName, Integer followersCount, Integer friendsCount, Integer tweetCount, String userPath, Date date) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.tweetCount = tweetCount;
        this.userPath = userPath;
    }
    public String toString() {
        return "id: " + id + ", userName: @" + userName + ", name: " + name + ", followerCount: " + followersCount + ", friendsCount: " + friendsCount + ", tweetCount: " + tweetCount + ", userPath: " + userPath + ", Date: " + date;
    }

}
