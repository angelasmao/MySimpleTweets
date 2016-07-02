package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.Fragments.ProfileActivity;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by amao on 6/27/16.
 */

//taking the Tweet objects and turning them into Views displayed in the list
public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {

    List<Tweet> mTweets;

    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
        mTweets = tweets;
    }

    //SET UP VIEWHOLDER FOR ALL ARRAY ADAPTERS I MAKE

    //override and setup custom template
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1 get the tweet
        final Tweet tweet = getItem(position);

        //2 find or inflate the template
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweet, parent, false);
        }

        //3 find the subviews to fill with data in the template
        ImageView ivProfileImage = (ImageView) convertView.findViewById(R.id.ivProfileImage);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.tvUsername);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        TextView tvHandle = (TextView) convertView.findViewById(R.id.tvHandle);


        Typeface fontBold = Typeface.createFromAsset(getContext().getAssets(), "fonts/GothamNarrow-Bold.otf");
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/GothamNarrow-Book.otf");
        // Assign the typeface to the view
        tvUsername.setTypeface(fontBold);
        tvBody.setTypeface(font);
        tvTime.setTypeface(font);
        tvHandle.setTypeface(font);


        //4 populate data into the subviews
        tvUsername.setText(tweet.getUser().getName());
        tvBody.setText(tweet.getBody());
        tvHandle.setText("@" + tweet.getUser().getScreenName());

        ivProfileImage.setImageResource(android.R.color.transparent); //erase old

        String profileUrl = tweet.getUser().getProfileImageUrl();
        profileUrl = profileUrl.replaceAll("_normal", "");

        Picasso.with(getContext()).load(profileUrl).into(ivProfileImage);


        //String dateString =
        String formattedTime = TimeFormatter.getTimeDifference(tweet.getCreatedAt()
        );
        //tvTime.setText(tweet.getRelativeTimeAgo(tweet.getCreatedAt()));
        tvTime.setText(formattedTime);

        ivProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                i.putExtra("screen_name", tweet.getUser().getScreenName()); //screen name of tweet
                getContext().startActivity(i);
            }
        });

        //5 return the view to be inserted into the list
        return convertView;
    }


}
