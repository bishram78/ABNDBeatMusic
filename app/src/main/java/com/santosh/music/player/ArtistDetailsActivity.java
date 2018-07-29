package com.santosh.music.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistDetailsActivity extends AppCompatActivity {

    private ImageButton imageButtonPlayAll;
    private TextView textViewArtistName;
    private TextView textViewNoOfSongs;
    private ListView listViewSongsList;

    private Intent intent;
    private ArrayList<String> songList;
    private ArrayList<String> artistList;
    private ArrayList<String> albumList;

    private static final String INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        referenceToIDs();

        intent = getIntent();
        String artistName = intent.getStringExtra("ARTIST_NAME");
        String noOfSongs = intent.getIntExtra("NO_OF_SONG", 0) + " Tracks found";
        textViewArtistName.setText(artistName);
        textViewNoOfSongs.setText(noOfSongs);

//        listViewArtistSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent songsIntent = new Intent(ArtistDetailsActivity.this, NowPlayingActivity.class);
//                songsIntent.putExtra(NOW_PLAYING_TRACK, artistSongs.get(position));
//                songsIntent.putExtra(INDEX, position);
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList(BUNDLE_OF_SONGS, artistSongs);
//                songsIntent.putExtras(bundle);
//                startActivity(songsIntent);
//            }
//        });
    }

    protected void referenceToIDs() {
        textViewArtistName = findViewById(R.id.id_aad_artist_name_header);
        textViewNoOfSongs = findViewById(R.id.id_aad_no_albums_tracks);
        imageButtonPlayAll = findViewById(R.id.id_aad_play_all);
        listViewSongsList = findViewById(R.id.id_aad_songs_list);
    }
}
