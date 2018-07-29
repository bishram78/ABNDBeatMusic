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
    private TextView textViewTotalDuration;

    //Declared ArrayList of Music list
    private ArrayList<Music> songsList;

    //KEEP TRACK OF SONG'S SERIAL NUMBER (INDEX)
    private int index;
    private String evenOrOdd = "EVEN";

    private static final String INDEX = "index";

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        referenceToIDs();
        addSongs();
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
        textViewTotalDuration = findViewById(R.id.id_anp_time_total);
    }

    private void setClicksDefault() {
        Intent intent = getIntent();
        index = intent.getIntExtra(INDEX, 0);

        textViewNowPlayingTrack.setText(songsList.get(index).getSongTitle());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewNowPlayingTrack.setSelected(true);
            }
        }, 1000);
        String stringArtist = songsList.get(index).getSongArtist();
        String stringAlbum = songsList.get(index).getSongAlbum();
        String stringArtistAlbum = stringArtist + " | " + stringAlbum;
        textViewArtistAlbum.setText(stringArtistAlbum);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewArtistAlbum.setSelected(true);
            }
        }, 1000);
        textViewTotalDuration.setText(songsList.get(index).getSongDuration());

        imageButtonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (evenOrOdd.equals("EVEN")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_play_black));
                    Toast.makeText(getApplicationContext(), "PAUSED " + songsList.get(index).getSongTitle(), Toast.LENGTH_SHORT).show();
                    evenOrOdd = "ODD";
                } else if (evenOrOdd.equals("ODD")) {
                    imageButtonPlayPause.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_pause_black));
                    Toast.makeText(getApplicationContext(), "PLAYING " + songsList.get(index).getSongTitle(), Toast.LENGTH_SHORT).show();
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
                    textViewNowPlayingTrack.setText(songsList.get(index).getSongTitle());
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                    String stringArtist = songsList.get(index).getSongArtist();
                    String stringAlbum = songsList.get(index).getSongAlbum();
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, 1000);
                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
                } else if (index == 0) {
                    Toast.makeText(getApplicationContext(), "This is already the first song", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                    String stringArtist = songsList.get(index).getSongArtist();
                    String stringAlbum = songsList.get(index).getSongAlbum();
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, 1000);
                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
                }
            }
        });

        imageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewNowPlayingTrack.setSelected(false);
                if (index < (songsList.size() - 1)) {
                    index++;
                    textViewNowPlayingTrack.setText(songsList.get(index).getSongTitle());
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                    String stringArtist = songsList.get(index).getSongArtist();
                    String stringAlbum = songsList.get(index).getSongAlbum();
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, 1000);
                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
                } else if (index == (songsList.size() - 1)) {
                    Toast.makeText(getApplicationContext(), "This is already the last song", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewNowPlayingTrack.setSelected(true);
                        }
                    }, 1000);
                    String stringArtist = songsList.get(index).getSongArtist();
                    String stringAlbum = songsList.get(index).getSongAlbum();
                    String stringArtistAlbum = stringArtist + " | " + stringAlbum;
                    textViewArtistAlbum.setText(stringArtistAlbum);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            textViewArtistAlbum.setSelected(true);
                        }
                    }, 1000);
                    textViewTotalDuration.setText(songsList.get(index).getSongDuration());
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
    private void addSongs() {
        //Create an ArrayList of Music Objects;
        songsList = new ArrayList<>();
        songsList.add(new Music("A Girl Like Me - www.MyMp3Singers.com", "Rihana", "A Girls Like Me", "04:18"));
        songsList.add(new Music("Baby Ft. Ludacris - www.Hungama.com", "Justin Bieber", "My World 2.0", "03:34"));
        songsList.add(new Music("Better That We Break - www.PagalWorld.com", "Maroon 5", "I Won't Be Soon Before Long", "03:21"));
        songsList.add(new Music("Break It Off With Sean Paul - www.PagalWorld.com", "Rihana", "A Girls Like Me", "03:33"));
        songsList.add(new Music("Burn - www.SongsLover.Info", "Usher", "Confessions", "03:44"));
        songsList.add(new Music("Eenie Meenie Ft. Sean Kingston - www.WebMusic.in", "Justin Bieber", "My World 2.0", "03:23"));
        songsList.add(new Music("Fashion - www.MyMp3Singers.com", "Guru Randhawa", "Single Mp3", "04:16"));
        songsList.add(new Music("Goriya Re Kaahe - www.SadriMuzik.com", "Unknown", "Single Mp3", "05:09"));
        songsList.add(new Music("Handstand Ft. Shanell - www.DJMaza.Info", "Nicki Minaj", "Beam Me Up Scotty", "03:08"));
        songsList.add(new Music("I Get Crazy Ft. Lil Wayne - www.PagalWorld.com", "Nicki Minaj", "Beam Me Up Scotty", "03:41"));
        songsList.add(new Music("Lahore - www.DownloadMing.Info", "Guru Randhawa", "Single Mp3", "03:16"));
        songsList.add(new Music("Luhurr Luhurr - www.YouTube.com", "Unknown", "E Kuri Aa Jana", "04:57"));
        songsList.add(new Music("Madwa Mein Mandar - www.Fun2Desi.com", "Monika & Egnesh", "Unknown", "05:11"));
        songsList.add(new Music("Pedal Mari Mari - www.JharkhandWap.In", "Babu Boruah", "Single Mp3", "04:38"));
        songsList.add(new Music("Remember The Name - www.PagalWorld.com", "Fort Minor", "Single Mp3", "03:49"));
        songsList.add(new Music("Rupa Re - www.NagpuriMasti.Net", "Akash Lohra", "Unknown", "05:40"));
        songsList.add(new Music("Sanu Ek Pal Chain Na - www.Songs.PK", "Rahat Fateh Ali Khan", "Raid", "08:25"));
        songsList.add(new Music("Sugar - www.SongsLover.Info", "Maroon 5", "Single Mp3", "03:56"));
        songsList.add(new Music("Tera Mera Milna - www.FreshMaza.In", "Himesh Reshammiya & Shreya Ghoshal", "Aap Kaa Surroor", "05:50"));
        songsList.add(new Music("That Should Be Me - www.BossMobi.IN", "Justin Bieber", "My World 2.0", "03:53"));
        songsList.add(new Music("Tirchhi Nazariya - www.SadriMuzik.Com", "Unknown", "Unknown", "04:53"));
        songsList.add(new Music("U Smile - www.DJMaza.Info", "Justin Bieber", "My World 2.0", "03:17"));
        songsList.add(new Music("Ya Ali - www.Gaana.com", "Himesh Reshammiya & Sunidhi Chauhan", "Aap Kaa Surroor", "04:32"));
        songsList.add(new Music("Yeah! Ft. Lil Jon & Ludacris - www.DJMaza.Info", "Usher", "Confessions", "04:10"));
    }
}
