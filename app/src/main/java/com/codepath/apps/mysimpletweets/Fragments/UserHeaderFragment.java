package com.codepath.apps.mysimpletweets.Fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.TwitterClient;
import com.codepath.apps.mysimpletweets.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class UserHeaderFragment extends Fragment {

    private TwitterClient client;
    private User user;

    TextView tvName;
    TextView tvTagline;
    TextView tvFollowers;
    TextView tvFollowing;
    ImageView ivProfileImage;
    TextView tvHandle;

    private String screenName;

    public UserHeaderFragment() {
        // Required empty public constructor
    }

    public static UserHeaderFragment newInstance(String screen_name) {
        UserHeaderFragment fragment = new UserHeaderFragment();
        Bundle args = new Bundle();
        args.putString("screen_name", screen_name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        populateProfileHeader();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_header, container, false);

        tvName = (TextView) v.findViewById(R.id.tvName);
        tvTagline = (TextView) v.findViewById(R.id.tvTagline);
        tvFollowers = (TextView) v.findViewById(R.id.tvFollowers);
        tvFollowing = (TextView) v.findViewById(R.id.tvFollowing);
        ivProfileImage = (ImageView) v.findViewById(R.id.ivProfileImage);
        tvHandle = (TextView) v.findViewById(R.id.tvHandle2);

        Typeface fontBold = Typeface.createFromAsset(getContext().getAssets(), "fonts/GothamNarrow-Bold.otf");
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/GothamNarrow-Book.otf");

        tvName.setTypeface(fontBold);
        tvTagline.setTypeface(font);
        tvFollowers.setTypeface(font);
        tvFollowing.setTypeface(font);
        tvHandle.setTypeface(font);

        // Inflate the layout for this fragment
        return v;
    }

    public interface OnUserLoaded {
        void loadedUser(User u);
    }

    private OnUserLoaded listener;

    // Store the listener (activity) that will have events fired once the fragment is attached
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUserLoaded) {
            listener = (OnUserLoaded) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    private void populateProfileHeader() {
        String screenName = getArguments().getString("screen_name");

        if (screenName == null) {
            //get account info
            client.getUserInfo(new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    user = User.fromJSON(response);
                    listener.loadedUser(user);
                    //my current user account's information
                    tvName.setText(user.getName());
                    tvTagline.setText(user.getTagline());
                    tvHandle.setText(user.getScreenName());
                    //Log.d("testing", user.getScreenName());
                    tvFollowers.setText(user.getFollowersCount() + " Followers");
                    tvFollowing.setText(user.getFollowingCount() + " Following");
                    String profileUrl = user.getProfileImageUrl();
                    //Log.d("cake", profileUrl);
                    profileUrl = profileUrl.replaceAll("_normal", "");
                    Log.d("cake", profileUrl);
                    Picasso.with(getContext()).load(profileUrl).into(ivProfileImage);
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }
            });
        }
        else {
            client.getUserProfile(screenName, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    user = User.fromJSON(response);
                    listener.loadedUser(user);
                    tvName.setText(user.getName());
                    tvTagline.setText(user.getTagline());
                    tvHandle.setText(user.getScreenName());
                    tvFollowers.setText(user.getFollowersCount() + " Followers");
                    tvFollowing.setText(user.getFollowingCount() + " Following");
                    String profileUrl = user.getProfileImageUrl();
                    Log.d("cake", profileUrl);
                    profileUrl = profileUrl.replaceAll("_normal", "");
                    Log.d("cake", profileUrl);
                    Picasso.with(getContext()).load(profileUrl).into(ivProfileImage);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                    super.onFailure(statusCode, headers, throwable, errorResponse);
                }
            });
        }
    }
}
