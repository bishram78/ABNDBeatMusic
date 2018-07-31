package com.santosh.music.player;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

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
    private String evenOrOdd = "EVEN";

    private static final String INDEX = "index";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_list";
    private static final String DURATION_LIST = "duration_list";
    private static final long DELAY_MILLIS = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        referenceToIDs();
        setReceivedIntent();
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
        textViewCurrentTime = findViewById(R.id.anp_current_duration);
        textViewTotalDuration = findViewById(R.id.id_anp_time_total);
    }

    private void setReceivedIntent() {
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

        textViewCurrentTime.setText(R.string.current_time);
        textViewTotalDuration.setText(durationList.get(index));
    }

    private void setClicksDefault() {
        imageButtonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (evenOrOdd.equals("EVEN")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_play_black));
                    Toast.makeText(getApplicationContext(),
                            String.format(Locale.getDefault(), getString(R.string.song_paused), trackList.get(index)), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "ODD";
                } else if (evenOrOdd.equals("ODD")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_pause_black));
                    Toast.makeText(getApplicationContext(),
                            String.format(Locale.getDefault(), getString(R.string.song_playing), trackList.get(index)), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "EVEN";
                }

            }
        });

        imageButtonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewNowPlayingTrack.setSelected(false);
                textViewArtistAlbum.setSelected(false);
                if (index > 0) {
                    index--;
                    textViewNowPlayingTrack.setText(trackList.get(index));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    String stringArtist = artistList.get(index);
                    String stringAlbum = albumList.get(index);
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    textViewTotalDuration.setText(durationList.get(index));
                } else if (index == 0) {
                    Toast.makeText(getApplicationContext(), R.string.the_first_song, Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    String stringArtist = artistList.get(index);
                    String stringAlbum = albumList.get(index);
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    textViewTotalDuration.setText(durationList.get(index));
                }
            }
        });

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewNowPlayingTrack.setSelected(false);
                textViewArtistAlbum.setSelected(false);
                if (index < (trackList.size() - 1)) {
                    index++;
                    textViewNowPlayingTrack.setText(trackList.get(index));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    String stringArtist = artistList.get(index);
                    String stringAlbum = albumList.get(index);
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    textViewTotalDuration.setText(durationList.get(index));
                } else if (index == (trackList.size() - 1)) {
                    Toast.makeText(getApplicationContext(), R.string.the_last_song, Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    String stringArtist = artistList.get(index);
                    String stringAlbum = albumList.get(index);
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, DELAY_MILLIS);

                    textViewTotalDuration.setText(durationList.get(index));
                }
            }
        });

        imageButtonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.function_addition_soon, Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.function_addition_soon, Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.function_addition_soon, Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.function_addition_soon, Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.function_addition_soon, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
