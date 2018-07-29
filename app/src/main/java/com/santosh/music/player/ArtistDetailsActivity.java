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

    private ArrayList<String> trackList;
    private ArrayList<String> artistList;
    private ArrayList<String> albumList;
    private ArrayList<String> durationList;

    private static final String INDEX = "index";
    private static final String NO_OF_SONG = "no_of_song";
    private static final String ARTIST_NAME = "artist_name";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_name";
    private static final String DURATION_LIST = "duration_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        referenceToIDs();

        Intent intent = getIntent();
        int position = intent.getIntExtra(INDEX, 0);
        final String artistName = intent.getStringExtra("ARTIST_NAME");
        String noOfSongs = intent.getIntExtra("NO_OF_SONG", 0) + " Tracks found";
        textViewArtistName.setText(artistName);
        textViewNoOfSongs.setText(noOfSongs);

        trackList = intent.getStringArrayListExtra(TRACK_LIST);
        artistList = intent.getStringArrayListExtra(ARTIST_LIST);
        albumList = intent.getStringArrayListExtra(ALBUM_LIST);
        durationList = intent.getStringArrayListExtra(DURATION_LIST);

        ArrayList<Music> musicArrayList = new ArrayList<>();
        for (int i = 0; i<trackList.size(); i++) {
            musicArrayList.add(new Music(trackList.get(i), artistList.get(i), albumList.get(i), durationList.get(i)));
        }
        MusicAdapter musicAdapter = new MusicAdapter(this, musicArrayList);
        listViewSongsList.setAdapter(musicAdapter);

        listViewSongsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songsIntent = new Intent(ArtistDetailsActivity.this, NowPlayingActivity.class);
                songsIntent.putExtra(INDEX, position);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                songsIntent.putExtras(bundle);
                startActivity(songsIntent);
            }
        });
    }

    protected void referenceToIDs() {
        textViewArtistName = findViewById(R.id.id_aad_artist_name_header);
        textViewNoOfSongs = findViewById(R.id.id_aad_no_albums_tracks);
        imageButtonPlayAll = findViewById(R.id.id_aad_play_all);
        listViewSongsList = findViewById(R.id.id_aad_songs_list);
    }
}
