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
    private TextView textViewArtistAlbum;
    private TextView textViewCurrentTime;
    private TextView textViewTotalDuration;

    private ArrayList<String> trackList;
    private ArrayList<String> artistList;
    private ArrayList<String> albumList;
    private ArrayList<String> durationList;

    private int index;
    private String evenOrOdd = "ODD";

    private static final String INDEX = "index";
    private static final String NO_OF_SONG = "no_of_song";
    private static final String ARTIST_NAME = "artist_name";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_name";
    private static final String DURATION_LIST = "duration_list";
    private static final long DELAY_MILLIS = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        referenceToIDs();

        Intent intent = getIntent();
        index = intent.getIntExtra(INDEX, 0);
        trackList = intent.getStringArrayListExtra(TRACK_LIST);
        artistList = intent.getStringArrayListExtra(ARTIST_LIST);
        albumList = intent.getStringArrayListExtra(ALBUM_LIST);
        durationList = intent.getStringArrayListExtra(DURATION_LIST);

        textViewNowPlayingTrack.setText(trackList.get(index));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewNowPlayingTrack.setSelected(true);
            }
        }, DELAY_MILLIS);

        String artist_album = artistList.get(index) + " | " + albumList.get(index);
        textViewArtistAlbum.setText(artist_album);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewArtistAlbum.setSelected(true);
            }
        }, DELAY_MILLIS);

        textViewCurrentTime.setText("00:00");
        textViewTotalDuration.setText(durationList.get(index));

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
        textViewNowPlayingTrack = findViewById(R.id.id_anp_track);
        textViewArtistAlbum = findViewById(R.id.id_anp_artist_album);
        textViewCurrentTime = findViewById(R.id.id_anp_time_skipped);
        textViewTotalDuration = findViewById(R.id.id_anp_time_total);
    }

    private void setClicksDefault() {
        imageButtonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (evenOrOdd.equals("EVEN")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_play_black));
                    Toast.makeText(getApplicationContext(), "PAUSED " + trackList.get(index), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "ODD";
                } else if (evenOrOdd.equals("ODD")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_pause_black));
                    Toast.makeText(getApplicationContext(), "PLAYING " + trackList.get(index), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "EVEN";
                }

            }
        });

//        imageButtonPrevious.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textViewNowPlayingTrack.setSelected(false);
//                if (index > 0) {
//                    index--;
//                    textViewNowPlayingTrack.setText(songsList.get(index).getSongTitle());
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewNowPlayingTrack.setSelected(true);
//                        }
//                    }, 1000);
//                    String stringArtist = songsList.get(index).getSongArtist();
//                    String stringAlbum = songsList.get(index).getSongAlbum();
//                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
//                    textViewArtistAlbum.setText(stringArtistAlbum);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewArtistAlbum.setSelected(true);
//                        }
//                    }, 1000);
//                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
//                } else if (index == 0) {
//                    Toast.makeText(getApplicationContext(), "This is already the first song", Toast.LENGTH_SHORT).show();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewNowPlayingTrack.setSelected(true);
//                        }
//                    }, 1000);
//                    String stringArtist = songsList.get(index).getSongArtist();
//                    String stringAlbum = songsList.get(index).getSongAlbum();
//                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
//                    textViewArtistAlbum.setText(stringArtistAlbum);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewArtistAlbum.setSelected(true);
//                        }
//                    }, 1000);
//                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
//                }
//            }
//        });
//
//        imageButtonNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textViewNowPlayingTrack.setSelected(false);
//                if (index < (songsList.size() - 1)) {
//                    index++;
//                    textViewNowPlayingTrack.setText(songsList.get(index).getSongTitle());
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewNowPlayingTrack.setSelected(true);
//                        }
//                    }, 1000);
//                    String stringArtist = songsList.get(index).getSongArtist();
//                    String stringAlbum = songsList.get(index).getSongAlbum();
//                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
//                    textViewArtistAlbum.setText(stringArtistAlbum);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewArtistAlbum.setSelected(true);
//                        }
//                    }, 1000);
//                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
//                } else if (index == (songsList.size() - 1)) {
//                    Toast.makeText(getApplicationContext(), "This is already the last song", Toast.LENGTH_SHORT).show();
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewNowPlayingTrack.setSelected(true);
//                        }
//                    }, 1000);
//                    String stringArtist = songsList.get(index).getSongArtist();
//                    String stringAlbum = songsList.get(index).getSongAlbum();
//                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
//                    textViewArtistAlbum.setText(stringArtistAlbum);
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            textViewArtistAlbum.setSelected(true);
//                        }
//                    }, 1000);
//                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
//                }
//            }
//        });
//
//        imageButtonRepeat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        imageButtonShuffle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        imageButtonFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        imageButtonShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        imageButtonMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "This function will be added soon.", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
