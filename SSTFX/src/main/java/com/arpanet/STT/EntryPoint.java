package com.arpanet.STT;

import com.arpanet.STT.controller.EntryPointViewController;
import com.arpanet.STT.model.Tweet;
import com.arpanet.STT.model.Users;
import com.arpanet.STT.reposıtory.HashtagRepository;
import com.arpanet.STT.reposıtory.TweetRepository;
import com.arpanet.STT.reposıtory.UsersRepository;
import com.sun.javafx.application.LauncherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import sun.plugin.dom.core.Comment;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Date;
import java.util.List;

public class EntryPoint implements  CommandLineRunner   {
    private Object Tweet;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private HashtagRepository hashtagRepository;
    private Object Hashtag;
    private Object Users;

    public static void main (String[] args) {
        LauncherImpl.launchApplication(SSTApplication.class, SplashScreen.class, args);
        SpringApplication.run(EntryPoint.class, args);



    }
    public void run(String... args) throws Exception {

       /* ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eFlPiYpQXPdn23BQ3Iy2C6XLx")
                .setOAuthConsumerSecret("uEdnUNGkFyqSMHRyhnaz89zYa7UsqJdhdrx5rkPvNKAnlLfACS")
                .setOAuthAccessToken("494252514-y9BEgi7W4NfA9xszjmWWW3BWDDTiG898Tn1JZMmI")
                .setOAuthAccessTokenSecret("76lp0c5Jida6btaXFcc5JNRTMIbhQlaCwOXfLVgSUcyy0");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();



        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline(new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            //TwitterApp twitterApp = new TwitterApp();




            for (Status status : statuses) {
                EntryPointViewController entryPointViewController = new EntryPointViewController();
                entryPointViewController.tweetHomeClick();
                Tweet tweet = new Tweet();
                Long id = tweet.setId(status.getId());
                String userName = tweet.setUserName(status.getUser().getScreenName());
                String name = tweet.setName(status.getUser().getName());
                String tweetContent = tweet.setTweetContent(status.getText());
                HashtagEntity[] hashtag=status.getHashtagEntities();
                for (HashtagEntity e :hashtag){
                    String hashtag1=tweet.setHashtag(e.getText());
                    System.out.println("#"+hashtag1);
                }
                Long userId = tweet.setUserId(status.getUser().getId());
                Integer favCount = tweet.setFavCount(status.getFavoriteCount());
                Integer retweetCount = tweet.setRetweetCount(status.getRetweetCount());
                Date date = tweet.setDate(status.getCreatedAt());
                String tweetPath= "https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId();
                tweet.setTweetPath(tweetPath);


*//*System.out.println(id + " @" +  userName + " (" + name + " - " + userId + ")" + " - " + tweetContent + " Adress:" + tweetPath
                    + " Fav Sayısı: " + favCount + " Retweet Sayisi: "+ retweetCount + " Atıldığı tarih: " + date);*//*

                System.out.println(tweet.toString());
                try {
                    tweetRepository.save(tweet);
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        } catch (TwitterException | IllegalStateException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }

        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline(new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");

            for (Status status : statuses) {
                Users users = new Users();
                Long id = users.setId(status.getUser().getId());
                String userName = users.setUserName(status.getUser().getScreenName());
                String name = users.setName(status.getUser().getName());
                Integer followersCount = users.setFollowersCount(status.getUser().getFollowersCount());
                Integer friendsCount = users.setFriendsCount(status.getUser().getFriendsCount());
                Integer tweetCount = users.setTweetCount(status.getUser().getStatusesCount());
                //String usersPath = users.setUserPath(status.getUser().getURL());
                String usersPath= "https://twitter.com/" + status.getUser().getScreenName() ;
                users.setUserPath(usersPath);
                Date date = users.setDate(status.getUser().getCreatedAt());
                System.out.println(users.toString());
                usersRepository.save(users);
            }
            System.exit(-1);

        } catch (TwitterException | IllegalStateException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }*/



        /*System.out.println("***************************************************************");
        Query query = new Query("POPULAR");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
        String tweet = "Selam";
        Status status = twitter.updateStatus(tweet);
        System.out.println(status.getText());*//*

        }*/


    }



}
