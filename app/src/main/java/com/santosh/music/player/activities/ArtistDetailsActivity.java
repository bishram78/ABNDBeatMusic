package com.santosh.music.player.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.santosh.music.player.R;
import com.santosh.music.player.adapters.MusicAdapter;
import com.santosh.music.player.models.Music;

import java.util.ArrayList;
import java.util.Locale;

public class ArtistDetailsActivity extends AppCompatActivity {

    private ImageButton imageButtonPlayAll;
    private ImageButton imageButtonUp;
    private TextView textViewArtistName;
    private TextView textViewNoOfSongs;
    private ListView listViewSongsList;

    private ArrayList<String> trackList;
    private ArrayList<String> artistList;
    private ArrayList<String> albumList;
    private ArrayList<String> durationList;

    private static final String INDEX = "index";
    private static final String NO_OF_ARTIST_SONG = "no_of_artist_song";
    private static final String ARTIST_NAME = "artist_name";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_list";
    private static final String DURATION_LIST = "duration_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        referenceToIDs();
        setReceivedIntents();
        setClicksDefault();
    }

    protected void referenceToIDs() {
        imageButtonUp = findViewById(R.id.ard_back_or_up);
        textViewArtistName = findViewById(R.id.ard_artist_name);
        textViewNoOfSongs = findViewById(R.id.ard_tracks_found);
        imageButtonPlayAll = findViewById(R.id.ard_play_all);
        imageButtonUp = findViewById(R.id.ard_back_or_up);
        listViewSongsList = findViewById(R.id.ard_songs_list);
    }

    protected void setReceivedIntents() {
        Intent intent = getIntent();
        String noOfSongsFound = String.format(Locale.getDefault(), getString(R.string.total_track_found), intent.getIntExtra(NO_OF_ARTIST_SONG, 0));
        textViewArtistName.setText(intent.getStringExtra(ARTIST_NAME));
        textViewNoOfSongs.setText(noOfSongsFound);

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
    }

    protected void setClicksDefault() {
        imageButtonPlayAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArtistDetailsActivity.this, NowPlayingActivity.class);
                intent.putExtra(INDEX, 0);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        imageButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ArtistDetailsActivity.this, HomePageActivity.class));
            }
        });
        listViewSongsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ArtistDetailsActivity.this, NowPlayingActivity.class);
                intent.putExtra(INDEX, position);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
