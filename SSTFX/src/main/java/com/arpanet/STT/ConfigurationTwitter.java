package com.arpanet.STT;

import twitter4j.conf.ConfigurationBuilder;

public class ConfigurationTwitter {
    public static ConfigurationBuilder getConfig(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("eFlPiYpQXPdn23BQ3Iy2C6XLx")
                .setOAuthConsumerSecret("uEdnUNGkFyqSMHRyhnaz89zYa7UsqJdhdrx5rkPvNKAnlLfACS")
                .setOAuthAccessToken("494252514-y9BEgi7W4NfA9xszjmWWW3BWDDTiG898Tn1JZMmI")
                .setOAuthAccessTokenSecret("76lp0c5Jida6btaXFcc5JNRTMIbhQlaCwOXfLVgSUcyy0");
        return cb;
    }
}
