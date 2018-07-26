package com.santosh.music.player;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    private ImageButton imageButtonPlayPause;
    private ImageButton imageButtonNext;
    private ImageButton imageButtonPrevious;
    private ImageButton imageButtonRepeat;
    private ImageButton imageButtonShuffle;
    private ImageButton imageButtonFav;
    private ImageButton imageButtonShare;
    private ImageButton imageButtonMore;

    private TextView textViewNowPlayingTrack;

    //Declared ArrayList of Song list
    private ArrayList<String> songsListReceived;

    //KEEP TRACK OF SONG'S SERIAL NUMBER (INDEX)
    private int index;
    private String evenOrOdd = "EVEN";

    private static final String NOW_PLAYING_TRACK = "now_playing_track";
    private static final String BUNDLE_OF_SONGS = "bundle_of_songs";
    private static final String INDEX = "index";

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        referenceToIDs();
        setClicksDefault();
    }

    private void referenceToIDs() {
        imageButtonPlayPause = findViewById(R.id.id_anp_play_pause);
        imageButtonNext = findViewById(R.id.id_anp_next);
        imageButtonPrevious = findViewById(R.id.id_anp_previous);
        imageButtonRepeat = findViewById(R.id.id_anp_repeat);
        imageButtonShuffle = findViewById(R.id.id_anp_shuffle);
        imageButtonFav = findViewById(R.id.id_anp_fav_heart);
        imageButtonShare = findViewById(R.id.id_anp_share);
        imageButtonMore = findViewById(R.id.id_anp_more);
    }

    private void setClicksDefault() {
        Intent intent = getIntent();
        String nowPlayingTrack = intent.getStringExtra(NOW_PLAYING_TRACK);
        index = intent.getIntExtra(INDEX, 0);
        songsListReceived = intent.getStringArrayListExtra(BUNDLE_OF_SONGS);

        textViewNowPlayingTrack = findViewById(R.id.id_anp_track);
        textViewNowPlayingTrack.setText(nowPlayingTrack);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewNowPlayingTrack.setSelected(true);
            }
        }, 1000);

        imageButtonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (evenOrOdd.equals("EVEN")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_play_black));
                    Toast.makeText(getApplicationContext(), "PAUSED " + songsListReceived.get(index), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "ODD";
                } else if (evenOrOdd.equals("ODD")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_pause_black));
                    Toast.makeText(getApplicationContext(), "PLAYING " + songsListReceived.get(index), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "EVEN";
                }

            }
        });

        imageButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewNowPlayingTrack.setSelected(false);
                if (index > 0) {
                    index--;
                    textViewNowPlayingTrack.setText(songsListReceived.get(index));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                } else if (index == 0) {
                    Toast.makeText(getApplicationContext(), "This is already the first song", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                }
            }
        });

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewNowPlayingTrack.setSelected(false);
                if (index < (songsListReceived.size() - 1)) {
                    index++;
                    textViewNowPlayingTrack.setText(songsListReceived.get(index));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                } else if (index == (songsListReceived.size() - 1)) {
                    Toast.makeText(getApplicationContext(), "This is already the last song", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                }
            }
        });

        imageButtonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
