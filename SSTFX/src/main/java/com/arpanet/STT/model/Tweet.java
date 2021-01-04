package com.arpanet.STT.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tweet")
@EntityListeners(AuditingEntityListener.class)
public class Tweet {
    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name")
    private String name ;


    private Long userId;

    @Column(name = "tweet_content")
    private String tweetContent;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "tweet_path")
    private String  tweetPath;

    @Column(name = "hashtag")
    private String hashtag;

    @Column(name = "fav_count")
    private Integer favCount;

    @Column(name = "retweet_count")
    private Integer retweetCount;

    @Column(name = "date")
    private Date date;

    public Tweet(){}

    public Tweet(Long id, String userName, Long userId, String tweetContent, String imagePath, String tweetPath, String hashtag,
                 String name, Integer favCount, Integer retweetCount, Date date) {
        this.id = id;
        this.userName = userName;
        this.userId = userId;
        this.tweetContent = tweetContent;
        this.imagePath = imagePath;
        this.tweetPath = tweetPath;
        this.hashtag = hashtag;
        this.name = name;
        this.favCount = favCount;
        this.retweetCount = retweetCount;
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public Date setDate(Date date) {
        this.date = date;
        return date;
    }
    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    public Integer getFavCount() {
        return favCount;
    }
    public Integer setFavCount(Integer fav) {
        this.favCount = fav;
        return fav;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public Integer setRetweetCount(Integer retweet) {
        this.retweetCount = retweet;
        return retweet;
    }
    public Long getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String setUserName(String userName) {
        this.userName = userName;
        return userName;
    }

    public Long getUserId() {
        return userId;
    }

    public Long setUserId(Long userId) {
        this.userId = userId;
        return userId;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public String setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
        return tweetContent;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getTweetPath() {
        return tweetPath;
    }

    public void setTweetPath(String tweetPath) {
        this.tweetPath = tweetPath;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String setHashtag(String hashtag) {
        this.hashtag = hashtag;
        return hashtag;
    }


    @Override
    public String toString() {
        return "id: " + id + ", userName: @" + userName + " (name: " + name + ", userId: " + userId + "), tweetContent: " + tweetContent + ", TweetAdress: " + tweetPath + " Fav Sayısı: " + favCount + " Retweet Sayisi: "+ retweetCount + " Atıldığı tarih: " + date;
    }
}
