package com.arpanet.STT.controller;

import com.arpanet.STT.ConfigurationTwitter;
import com.arpanet.STT.EntryPoint;
import com.arpanet.STT.model.Tweet;
import com.arpanet.STT.model.Users;
import com.arpanet.STT.reposıtory.TweetRepository;
import com.arpanet.STT.reposıtory.UsersRepository;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static com.arpanet.STT.ConfigurationTwitter.getConfig;

@Component
public class EntryPointViewController implements Initializable {

    //General
    @FXML
    private Button btnHomepage, btnSignout, btnUserpageTweets, btnUser, btnHomepgeTweets;

    @FXML
    private TableView tableTweet;

    @FXML
    private VBox vBox1;

    @FXML
    private TableColumn user_id_col, name_col, user_name_col, tweet_text_col, tweet_id_col, fav_count_col, retweet_count_col, tweet_path_col, date_col;
    @FXML
    private TextField textfieldUserName;
    int whichIsLastClicked = 1;

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UsersRepository usersRepository;

    /*Runnable task = () -> {
        ConfigurationBuilder cb = ConfigurationTwitter.getConfig();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline(new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");

            for (Status status : statuses) {
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
            List<Status> statuses = twitter.getUserTimeline("Tolga_Cbn",new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            //TwitterApp twitterApp = new TwitterApp();

            for (Status status : statuses) {
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

        } catch (TwitterException | IllegalStateException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
    };*/

    @FXML
    private void eventHome2(ActionEvent event)
    {
        ConfigurationBuilder cb = ConfigurationTwitter.getConfig();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline(new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            //TwitterApp twitterApp = new TwitterApp();

            for (Status status : statuses) {
                Users users = new Users();
                Long id = users.setId(status.getUser().getId());
                String userName = users.setUserName(status.getUser().getScreenName());
                String name = users.setName(status.getUser().getName());
                Integer followersCount = users.setFollowersCount(status.getUser().getFollowersCount());
                Integer friendsCount = users.setFriendsCount(status.getUser().getFriendsCount());
                Integer tweetCount = users.setTweetCount(status.getUser().getStatusesCount());
                Date date = users.setDate(status.getUser().getCreatedAt());
                String tweetPath= "https://twitter.com/" + status.getUser().getScreenName();
                users.setUserPath(tweetPath);

                System.out.println(users.toString());
                try {
                    usersRepository.save(users);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (TwitterException | IllegalStateException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }


        whichIsLastClicked = 0 ;

        tableTweet.getColumns().remove(tweet_text_col);
        tweet_id_col.setText("User Path");
        fav_count_col.setText("Follower Count");
        retweet_count_col.setText("Friends Count");
        tweet_path_col.setText("Tweet Count");

        user_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        user_name_col.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tweet_id_col.setCellValueFactory(new PropertyValueFactory<>("userPath"));
        fav_count_col.setCellValueFactory(new PropertyValueFactory<>("followersCount"));
        retweet_count_col.setCellValueFactory(new PropertyValueFactory<>("friendsCount"));
        tweet_path_col.setCellValueFactory(new PropertyValueFactory<>("tweetCount"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));

        List<Users> users = usersRepository.findAll();
        tableTweet.getItems().clear();
        tableTweet.getItems().addAll(users);

    }

    @FXML
    public void tweetUserClick(){
        String textUserName = textfieldUserName.getText();
        tableTweet.getItems().clear();
        String userName = "";
        ConfigurationBuilder cb = ConfigurationTwitter.getConfig();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getUserTimeline(textUserName,new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            //TwitterApp twitterApp = new TwitterApp();

            for (Status status : statuses) {
                Tweet tweet = new Tweet();
                Long id = tweet.setId(status.getId());
                userName = tweet.setUserName(status.getUser().getScreenName());
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

         List<Tweet> tweets = tweetRepository.findByUserName(textUserName);


        user_id_col.setCellValueFactory(new PropertyValueFactory<>("userId"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        user_name_col.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tweet_text_col.setCellValueFactory(new PropertyValueFactory<>("tweetContent"));
        tweet_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        fav_count_col.setCellValueFactory(new PropertyValueFactory<>("favCount"));
        retweet_count_col.setCellValueFactory(new PropertyValueFactory<>("retweetCount"));
        tweet_path_col.setCellValueFactory(new PropertyValueFactory<>("tweetPath"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));


        tableTweet.getItems().addAll(tweets);

        if (whichIsLastClicked == 0){
            tableTweet.getColumns().add(3,tweet_text_col);
            fav_count_col.setText("Fav Count");
            retweet_count_col.setText("Retweet Count");
            tweet_path_col.setText("Tweet Path");
        }
        else{
            fav_count_col.setText("Fav Count");
            retweet_count_col.setText("Retweet Count");
            tweet_path_col.setText("Tweet Path");
        }
        whichIsLastClicked = 1;
    }

    @FXML
    public void tweetHomeClick(){
        ConfigurationBuilder cb = ConfigurationTwitter.getConfig();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline(new Paging(1,200));
            System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");

            for (Status status : statuses) {
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

        user_id_col.setCellValueFactory(new PropertyValueFactory<>("userId"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        user_name_col.setCellValueFactory(new PropertyValueFactory<>("userName"));
        tweet_text_col.setCellValueFactory(new PropertyValueFactory<>("tweetContent"));
        tweet_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        fav_count_col.setCellValueFactory(new PropertyValueFactory<>("favCount"));
        retweet_count_col.setCellValueFactory(new PropertyValueFactory<>("retweetCount"));
        tweet_path_col.setCellValueFactory(new PropertyValueFactory<>("tweetPath"));
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));

        List<Tweet> tweets = tweetRepository.findAll();
        tableTweet.getItems().clear();
        tableTweet.getItems().addAll(tweets);

        if (whichIsLastClicked == 0){
            tableTweet.getColumns().add(3,tweet_text_col);
            fav_count_col.setText("Fav Count");
            retweet_count_col.setText("Retweet Count");
            tweet_path_col.setText("Tweet Path");
        }
        else{
            fav_count_col.setText("Fav Count");
            retweet_count_col.setText("Retweet Count");
            tweet_path_col.setText("Tweet Path");
        }
        whichIsLastClicked = 1 ;
    }

    @FXML
    public  void tableTweetHome(){
    }

    @FXML
    private Pane pnlSolab;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final CategoryAxis xAxis = new CategoryAxis(); // we are gonna plot against time
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time/s");
        xAxis.setAnimated(false); // axis animations are removed
        yAxis.setLabel("Value");
        yAxis.setAnimated(false); // axis animations are removed

       /* Thread thread = new Thread(task);
        thread.start();*/
    }

    public void handleClicks(ActionEvent actionEvent) {
        

        if (actionEvent.getSource() == btnSignout) {
            Platform.exit();
            System.exit(0);
        }
    }

}
