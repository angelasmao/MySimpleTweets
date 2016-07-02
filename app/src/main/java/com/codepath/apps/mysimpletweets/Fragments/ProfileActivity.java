package com.codepath.apps.mysimpletweets.Fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.models.User;

public class ProfileActivity extends AppCompatActivity implements UserHeaderFragment.OnUserLoaded{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //get the screen name from activity that launches this
        String screenName = getIntent().getStringExtra("screen_name");

        if (savedInstanceState == null) {
            UserHeaderFragment fragment = UserHeaderFragment.newInstance(screenName);
            //display user fragment within this activity (dynamically)
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContainer, fragment);
            //ft.commit();

            //create the user timeline fragment
            UserTimelineFragment fragmentUserTimeline = UserTimelineFragment.newInstance(screenName);
            //display user fragment within this activity (dynamically)
            //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flContainer2, fragmentUserTimeline);
            ft.commit();

        }
    }

    @Override
    public void loadedUser(User u) {
        //getSupportActionBar().setTitle("@" + u.getScreenName());
    }
}
