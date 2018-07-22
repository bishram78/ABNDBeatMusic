package com.santosh.music.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();
        String nowPlayingTrack = intent.getStringExtra("NOW_PLAYING_TRACK");

        TextView textViewNowPlayingTrack = findViewById(R.id.anp_now_playing_track);
        textViewNowPlayingTrack.setText(nowPlayingTrack);
    }
}
