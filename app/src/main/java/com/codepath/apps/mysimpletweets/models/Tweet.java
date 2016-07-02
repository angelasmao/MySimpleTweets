package com.codepath.apps.mysimpletweets.models;

import android.text.format.DateUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by amao on 6/27/16.
 */

/*

{"created_at":"Mon Jun 27 22:45:06 +0000 2016","id":747561420863086593,"id_str":"747561420863086593","text":"RT @ZacAAuthors: Back to NYC for a day....then back to LA for a day....then off to San Fran for a day.... #WhatWeLiveFor https:\/\/t.co\/GKBtM…","truncated":false,"entities":{"hashtags":[{"text":"WhatWeLiveFor","indices":[106,120]}],"symbols":[],"user_mentions":[{"screen_name":"ZacAAuthors","name":"Zac Barnett","id":60769104,"id_str":"60769104","indices":[3,15]}],"urls":[],"media":[{"id":747558467414593536,"id_str":"747558467414593536","indices":[121,140],"media_url":"http:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","url":"https:\/\/t.co\/GKBtMbm5oR","display_url":"pic.twitter.com\/GKBtMbm5oR","expanded_url":"http:\/\/twitter.com\/ZacAAuthors\/status\/747558475073363968\/photo\/1","type":"photo","sizes":{"large":{"w":960,"h":1025,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":637,"h":680,"resize":"fit"},"medium":{"w":960,"h":1025,"resize":"fit"}},"source_status_id":747558475073363968,"source_status_id_str":"747558475073363968","source_user_id":60769104,"source_user_id_str":"60769104"}]},"extended_entities":{"media":[{"id":747558467414593536,"id_str":"747558467414593536","indices":[121,140],"media_url":"http:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","url":"https:\/\/t.co\/GKBtMbm5oR","display_url":"pic.twitter.com\/GKBtMbm5oR","expanded_url":"http:\/\/twitter.com\/ZacAAuthors\/status\/747558475073363968\/photo\/1","type":"photo","sizes":{"large":{"w":960,"h":1025,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":637,"h":680,"resize":"fit"},"medium":{"w":960,"h":1025,"resize":"fit"}},"source_status_id":747558475073363968,"source_status_id_str":"747558475073363968","source_user_id":60769104,"source_user_id_str":"60769104"}]},"source":"<a href=\"http:\/\/twitter.com\/download\/iphone\" rel=\"nofollow\">Twitter for iPhone<\/a>","in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":21734663,"id_str":"21734663","name":"American Authors","screen_name":"aauthorsmusic","location":"Brooklyn, NY","description":"Telling our Stories to the world since the 1980's #WhatWeLiveFor @zacaauthors @mattaauthors @daveaauthors @jamesaauthors","url":"https:\/\/t.co\/TRHWxW6o0C","entities":{"url":{"urls":[{"url":"https:\/\/t.co\/TRHWxW6o0C","expanded_url":"https:\/\/IslandRecs.lnk.to\/WhatWeLiveForTw","display_url":"IslandRecs.lnk.to\/WhatWeLiveForTw","indices":[0,23]}]},"description":{"urls":[]}},"protected":false,"followers_count":74528,"friends_count":735,"listed_count":571,"created_at":"Tue Feb 24 06:22:19 +0000 2009","favourites_count":5261,"utc_offset":-14400,"time_zone":"Eastern Time (US & Canada)","geo_enabled":true,"verified":true,"statuses_count":14789,"lang":"en","contributors_enabled":false,"is_translator":false,"is_translation_enabled":false,"profile_background_color":"8B542B","profile_background_image_url":"http:\/\/pbs.twimg.com\/profile_background_images\/440522957874417664\/otRWIcxy.jpeg","profile_background_image_url_https":"https:\/\/pbs.twimg.com\/profile_background_images\/440522957874417664\/otRWIcxy.jpeg","profile_background_tile":true,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/708444233242292224\/HzuX-EVw_normal.jpg","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/708444233242292224\/HzuX-EVw_normal.jpg","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/21734663\/1466134398","profile_link_color":"9D582E","profile_sidebar_border_color":"FFFFFF","profile_sidebar_fill_color":"000000","profile_text_color":"575353","profile_use_background_image":true,"has_extended_profile":false,"default_profile":false,"default_profile_image":false,"following":true,"follow_request_sent":false,"notifications":false},"geo":null,"coordinates":null,"place":null,"contributors":null,"retweeted_status":{"created_at":"Mon Jun 27 22:33:24 +0000 2016","id":747558475073363968,"id_str":"747558475073363968","text":"Back to NYC for a day....then back to LA for a day....then off to San Fran for a day.... #WhatWeLiveFor https:\/\/t.co\/GKBtMbm5oR","truncated":false,"entities":{"hashtags":[{"text":"WhatWeLiveFor","indices":[89,103]}],"symbols":[],"user_mentions":[],"urls":[],"media":[{"id":747558467414593536,"id_str":"747558467414593536","indices":[104,127],"media_url":"http:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","url":"https:\/\/t.co\/GKBtMbm5oR","display_url":"pic.twitter.com\/GKBtMbm5oR","expanded_url":"http:\/\/twitter.com\/ZacAAuthors\/status\/747558475073363968\/photo\/1","type":"photo","sizes":{"large":{"w":960,"h":1025,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":637,"h":680,"resize":"fit"},"medium":{"w":960,"h":1025,"resize":"fit"}}}]},"extended_entities":{"media":[{"id":747558467414593536,"id_str":"747558467414593536","indices":[104,127],"media_url":"http:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/Cl_cdyMVEAAZ7HD.jpg","url":"https:\/\/t.co\/GKBtMbm5oR","display_url":"pic.twitter.com\/GKBtMbm5oR","expanded_url":"http:\/\/twitter.com\/ZacAAuthors\/status\/747558475073363968\/photo\/1","type":"photo","sizes":{"large":{"w":960,"h":1025,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"small":{"w":637,"h":680,"resize":"fit"},"medium":{"w":960,"h":1025,"resize":"fit"}}}]},"source":"<a href=\"http:\/\/twitter.com\/download\/iphone\" rel=\"nofollow\">Twitter for iPhone<\/a>","in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":60769104,"id_str":"60769104","name":"Zac Barnett","screen_name":"ZacAAuthors","location":"Brooklyn, NY","description":"Singer\/Songwriter with American Authors","url":"https:\/\/t.co\/US0DJ7fYPK","entities":{"url":{"urls":[{"url":"https:\/\/t.co\/US0DJ7fYPK","expanded_url":"http:\/\/www.weareamericanauthors.com","display_url":"weareamericanauthors.com","indices":[0,23]}]},"description":{"urls":[]}},"protected":false,"followers_count":13071,"friends_count":264,"listed_count":91,"created_at":"Tue Jul 28 01:17:47 +0000 2009","favourites_count":1633,"utc_offset":-18000,"time_zone":"Quito","geo_enabled":true,"verified":true,"statuses_count":2206,"lang":"en","contributors_enabled":false,"is_translator":false,"is_translation_enabled":false,"profile_background_color":"C0DEED","profile_background_image_url":"http:\/\/pbs.twimg.com\/profile_background_images\/658512931\/gye9bx8sjf678vcy0x82.jpeg","profile_background_image_url_https":"https:\/\/pbs.twimg.com\/profile_background_images\/658512931\/gye9bx8sjf678vcy0x82.jpeg","profile_background_tile":false,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/673561907379445761\/RvoSS6ZX_normal.jpg","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/673561907379445761\/RvoSS6ZX_normal.jpg","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/60769104\/1459905016","profile_link_color":"0084B4","profile_sidebar_border_color":"C0DEED","profile_sidebar_fill_color":"DDEEF6","profile_text_color":"333333","profile_use_background_image":true,"has_extended_profile":false,"default_profile":false,"default_profile_image":false,"following":false,"follow_request_sent":false,"notifications":false},"geo":null,"coordinates":null,"place":null,"contributors":null,"is_quote_status":false,"retweet_count":7,"favorite_count":32,"favorited":false,"retweeted":false,"possibly_sensitive":false,"possibly_sensitive_appealable":false,"lang":"en"},"is_quote_status":false,"retweet_count":7,"favorite_count":0,"favorited":false,"retweeted":false,"possibly_sensitive":false,"possibly_sensitive_appealable":false,"lang":"en"}

 */



//parse the JSON + store the data, encapsulate logic or display logic
@Parcel
public class Tweet {
    //list out the attributes
    private String body;
    private long uid;
    private User user;
    private String createdAt;
    private String rawJsonDate;
    private String relativeDate;


    public User getUser() {
        return user;
    }

    public String getBody() {
        return body;
    }

    public long getUid() {
        return uid;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getRelativeDate() {
        return relativeDate;
    }


    public Tweet() {

    }

    // deserialize the JSON coming in
    //tweet.fromJSON("{...}") => <Tweet>
    public static Tweet fromJSON(JSONObject jsonObject) {
        Tweet tweet = new Tweet();

        //extract the values from the json, store them
        try {
            tweet.body = jsonObject.getString("text");
            tweet.uid = jsonObject.getLong("id");
            tweet.createdAt = jsonObject.getString("created_at");
            tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
            //tweet.rawJsonDate = jsonObject.getString("");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //return the tweet object


        return tweet;
    }

    //Tweet.fromJSONArray({....}, {...}) => LIst<Tweet>
    public static ArrayList<Tweet> fromJSONArray(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<>();

        //iterate the json array and create tweets
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject tweetJson = jsonArray.getJSONObject(i);
                Tweet tweet = Tweet.fromJSON(tweetJson);
                if (tweet != null) {
                    tweets.add(tweet);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                continue; //even after one fails, continue
            }
        }

        //return the finished list
        return tweets;
    }


    // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
    public String getRelativeTimeAgo(String rawJsonDate) {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        try {
            long dateMillis = sf.parse(rawJsonDate).getTime();
            relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                    System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return relativeDate;
    }

}
