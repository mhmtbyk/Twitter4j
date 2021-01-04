package com.arpanet.STT;

import com.arpanet.STT.controller.EntryPointViewController;
import com.arpanet.STT.model.Tweet;
import com.arpanet.STT.model.Users;
import com.arpanet.STT.reposıtory.TweetRepository;
import com.arpanet.STT.reposıtory.UsersRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.net.URL;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SSTApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent root;
    private double x, y;


    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(SSTApplication.class);

        URL url = getClass().getResource("/Home.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        fxmlLoader.setControllerFactory(springContext::getBean);

        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image(getClass()
                .getResource("/images/arpanet-mini.png").toExternalForm()));

        primaryStage.setScene(new Scene(root));
        //set stage borderless
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }
}
