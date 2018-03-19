package com.example.nassh.yapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    Button b;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    EditText e;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = findViewById(R.id.e1);
        b = findViewById(R.id.b1);
        youTubePlayerView = ( YouTubePlayerView )findViewById(R.id.yv);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(a);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = e.getText().toString();
                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
            }
        });
    }
}
