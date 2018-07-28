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
        songsList.add(new Music("Aaj Mood Ishqholiq Hai - www.PagalWorld.com", "Sonakshi Sihna, Kadil Baag & Pritam Kapoor", "Single Bollywood Album Mp3 2016", "04:30"));
        songsList.add(new Music("Along The Coast - www.BossMp3.IN", "Unknown Artist", "Unknown Album", "03:37"));
        songsList.add(new Music("Bandook - www.SongsCloud.IN", "Unknown Artist", "Unknown Album", "05:49"));
        songsList.add(new Music("Beautiful Feat. Colby Odonis - www.WapKing.FM", "Akon", "Akon Konvicted", "03:59"));
        songsList.add(new Music("Begar Jhore Nai Aaboo (Toore) - www.JharkhandWap.IN", "DJ Sandeep", "Toore", "05:20"));
        songsList.add(new Music("Better Than Revenge - www.RaagJatt.Com", "Taylor Swift", "Billboard Top 100", "03:46"));
        songsList.add(new Music("Blame Feat The Newman - www.FazMusic.Net", "Kelvin Harris", "Billboard Top 100", "03:10"));
        songsList.add(new Music("Chaand Lakhe Rupa Gori - www.Fun2Desi.com", "Pawan", "Adhunik Nagpuri", "06:20"));
        songsList.add(new Music("Chicken Music - www.SongsPK.Link", "Mika Singh", "Bollywood Party", "05:02"));
        songsList.add(new Music("Dil Jala Raat Hua - www.NaGpuriMp3.In", "Munna Dhamal", "Gaon Ker Gori", "06:39"));
        songsList.add(new Music("Down To Earth - www.SongsLover.Info", "Justin Bieber", "My World 2.0", "03:54"));
        songsList.add(new Music("Enchanted - www.WebMusic.IN", "Taylor Swift", "Enchanted", "04:00"));
        songsList.add(new Music("Eraser - www.SongsLover.Info", "Unknown Artist", "Latest English Music", "03:27"));
        songsList.add(new Music("Favourite Girl - www.9xTune.com", "Justin Bieber", "My World 2.0", "05:00"));
        songsList.add(new Music("Gaddi Ft. Veer Karan - Rob C - www.Mr-Punjab.Com", "Rob C", "Meri Gaddi", "04:45"));
        songsList.add(new Music("Gora Gora Badan Re Goriya - www.NaGpuriMp3.IN", "Munna Dhamal", "Gaon Ker Gori", "05:05"));
        songsList.add(new Music("Ishq Achcha Lagta Hai - www.DJMaza.Info", "Unknown Artist", "Romantic Music", "04:40"));
        songsList.add(new Music("Hey Ma Feat. Camila Cabello - www.RaagTune.com", "Camila Cabello", "More Power", "03:11"));
        songsList.add(new Music("I Wanna Go - www.RaagJatt.Com", "Mey Mee", "Northern People", "03:56"));
        songsList.add(new Music("Jab Toy Dekhle Ulait - www.Fun2Desi.com", "Raju & Monika", "Adhunik Nagpuri", "06:06"));
        songsList.add(new Music("Jaanta Tha - www.MyMp3Singer.com", "Kavita Krishnamurthy", "Masoom", "05:32"));
        songsList.add(new Music("Koi Chehra - www.RaagJatt.com", "Alda Kaur", "Koi Chehra", "05:19"));
        songsList.add(new Music("Let Me Love You Feat. Justin Bieber - www.DJMaza.Info", "DJ Snake", "Latest English", "04:48"));
        songsList.add(new Music("Love You Like Love Music - www.WebMusic.In", "Selena Gomez", "My Love", "03:40"));
        songsList.add(new Music("Mere Lamhon Ki Aarzoo - www.WebMusic.In", "Himesh Reshammiya", "Aarzoo", "05:50"));
        songsList.add(new Music("Naina Se Lor Bahela (DJ Remix By Guru) - www.NagpuriWap.IN", "Pawan & Mittal Devi", "Adhunik Nagpuri", "06:30"));
        songsList.add(new Music("One Dance Ft. Justin Bieber - www.9xTune.com", "Chris Brown", "Once Dance", "02:58"));
        songsList.add(new Music("Pal Pal Dil Ke Paas - www.Songs.Pk", "Sanam Puri", "Single Mp3", "04:39"));
        songsList.add(new Music("Saanson Ke - www.MyMp3Songs.Info", "Azhar Kakkar", "Masoom Chehra", "04:42"));
        songsList.add(new Music("See You Again Ft. Charlie Puth - wwww.RiskyjaTT.CoM", "Wiz Khalifa", "Fast & Furious", "04:42"));
        songsList.add(new Music("Something New Feat. Chris Brown - www.Howwe.Biz", "Charlie Puth", "Slow Down", "03:51"));
        songsList.add(new Music("Swag Babe Ft. Millind Gaba - wwww.PagalWorld.com", "Badshah", "Swaagat", "04:08"));
        songsList.add(new Music("Thanda Thanda Cool Cool (Dance Mix By DJ Chandan) - www.DjOnly.IN", "Hemlata & Ramesh", "Barf Badan", "05:06"));
        songsList.add(new Music("Tore Se Pyaar - www.SadriMasti.IN", "Munna Dhamal & Supriya", "Tore Se Pyaar", "06:00"));
        songsList.add(new Music("Yeah Ft. Lil Jon and Ludacris - www.SongsLover.Info", "Usher", "Confessions", "04:00"));
        songsList.add(new Music("Zindagi Gulzar Hai - www.PakHeaven.Com", "Nikita & Nisha", "Zindagi Ke Rang", "05:00"));
        songsList.add(new Music("Zindegi (Unplugged) - www.Fun2Desi.com", "Shael Oswal", "Zindagi Universal", "04:44"));
    }
}
