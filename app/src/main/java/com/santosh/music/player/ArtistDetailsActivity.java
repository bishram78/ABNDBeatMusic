package com.santosh.music.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistDetailsActivity extends AppCompatActivity {


    private static final String ARTIST_NAME = "artist_name";
    private static final String BUNDLE_OF_SONGS = "bundle_of_songs";
    private static final String INDEX = "index";
    private static final String NOW_PLAYING_TRACK = "now_playing_track";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_details);

        final Intent intent = getIntent();
        String artistName = intent.getStringExtra(ARTIST_NAME);
        TextView textViewArtistName = findViewById(R.id.id_aad_artist_name_header);
        textViewArtistName.setText(artistName);

        final ArrayList<String> artistSongs = new ArrayList<>();
        artistSongs.add("Track/Song Name ONE - www.Website.com");
        artistSongs.add("Track/Song Name TWO - www.Website.com");
        artistSongs.add("Track/Song Name THREE - www.Website.com");
        artistSongs.add("Track/Song Name FOUR - www.Website.com");
        artistSongs.add("Track/Song Name FIVE - www.Website.com");
        artistSongs.add("Track/Song Name SIX - www.Website.com");
        artistSongs.add("Track/Song Name SEVEN - www.Website.com");
        artistSongs.add("Track/Song Name EIGHT - www.Website.com");

        ArrayAdapter<String> asArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, artistSongs);
        ListView listViewArtistSongs = findViewById(R.id.id_aad_songs_list);
        listViewArtistSongs.setAdapter(asArrayAdapter);

        listViewArtistSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent songsIntent = new Intent(ArtistDetailsActivity.this, NowPlayingActivity.class);
                songsIntent.putExtra(NOW_PLAYING_TRACK, artistSongs.get(position));
                songsIntent.putExtra(INDEX, position);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(BUNDLE_OF_SONGS, artistSongs);
                songsIntent.putExtras(bundle);
                startActivity(songsIntent);
            }
        });
    }
}
