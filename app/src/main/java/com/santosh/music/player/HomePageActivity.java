package com.santosh.music.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private Button buttonAllTracks;
    private Button buttonArtist;
    private Button buttonAlbum;
    private GridView gridViewAlbums;
    private ListView listViewArtists;
    private ListView listViewTracks;

    private ArrayList<String> songsList;
    private ArrayList<String> artistList;
    private ArrayList<String> albumsList;

    private Bundle bundle;
    private Intent intent;

    private static final String ARTIST_NAME = "artist_name";
    private static final String BUNDLE_OF_SONGS = "bundle_of_songs";
    private static final String INDEX = "index";
    private static final String NOW_PLAYING_TRACK = "now_playing_track";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        referenceToIDs();
        addSongs();
        addArtists();
        addAlbums();
        setClicksDefault();
    }

    public void referenceToIDs() {
        buttonAlbum = findViewById(R.id.id_ahp_album);
        buttonAllTracks = findViewById(R.id.id_ahp_all_tracks);
        buttonArtist = findViewById(R.id.id_ahp_artist);
        listViewArtists = findViewById(R.id.id_ahp_list_4_artist);
        gridViewAlbums = findViewById(R.id.id_ahp_grid_4_album);
        listViewTracks = findViewById(R.id.id_ahp_list_4_all_tracks);
    }

    private void addSongs() {
        songsList = new ArrayList<>();
        songsList.add("Track/Song Name ONE - www.Website.com");
        songsList.add("Track/Song Name TWO - www.Website.com");
        songsList.add("Track/Song Name THREE - www.Website.com");
        songsList.add("Track/Song Name FOUR - www.Website.com");
        songsList.add("Track/Song Name FIVE - www.Website.com");
        songsList.add("Track/Song Name SIX - www.Website.com");
        songsList.add("Track/Song Name SEVEN - www.Website.com");
        songsList.add("Track/Song Name EIGHT - www.Website.com");
        songsList.add("Track/Song Name NINE - www.Website.com");
        songsList.add("Track/Song Name TEN - www.Website.com");
    }

    public void addArtists() {
        artistList = new ArrayList<>();
        artistList.add("Artist Name FIRST");
        artistList.add("Artist Name SECOND");
        artistList.add("Artist Name THIRD");
        artistList.add("Artist Name FOURTH");
        artistList.add("Artist Name FIFTH");
        artistList.add("Artist Name SIXTH");
        artistList.add("Artist Name SEVENTH");
        artistList.add("Artist Name EIGHTH");
        artistList.add("Artist Name NINTH");
        artistList.add("Artist Name TENTH");
    }

    public void addAlbums() {
        albumsList = new ArrayList<>();
        albumsList.add("Album Name FIRST");
        albumsList.add("Album Name SECOND");
        albumsList.add("Album Name THIRD");
        albumsList.add("Album Name FOURTH");
        albumsList.add("Album Name FIFTH");
        albumsList.add("Album Name SIXTH");
        albumsList.add("Album Name SEVENTH");
        albumsList.add("Album Name EIGHTH");
        albumsList.add("Album Name NINTH");
        albumsList.add("Album Name TENTH");
    }

    private void setClicksDefault() {
        ArrayAdapter<String> songsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, songsList);
        listViewTracks.setAdapter(songsArrayAdapter);

        ArrayAdapter<String> artistsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, artistList);
        listViewArtists.setAdapter(artistsArrayAdapter);

        ArrayAdapter<String> albumsArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, albumsList);
        gridViewAlbums.setAdapter(albumsArrayAdapter);

        buttonAllTracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewTracks.setVisibility(View.VISIBLE);
                listViewArtists.setVisibility(View.GONE);
                gridViewAlbums.setVisibility(View.GONE);
                buttonAllTracks.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                buttonArtist.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                buttonAlbum.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        buttonArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewTracks.setVisibility(View.GONE);
                listViewArtists.setVisibility(View.VISIBLE);
                gridViewAlbums.setVisibility(View.GONE);
                buttonAllTracks.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                buttonArtist.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                buttonAlbum.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            }
        });

        buttonAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewTracks.setVisibility(View.GONE);
                listViewArtists.setVisibility(View.GONE);
                gridViewAlbums.setVisibility(View.VISIBLE);
                buttonAllTracks.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                buttonArtist.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                buttonAlbum.setBackgroundColor(getResources().getColor(R.color.colorBackground));
            }
        });

        listViewTracks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
                bundle = new Bundle();
                intent.putExtra(NOW_PLAYING_TRACK, songsList.get(position));
                intent.putExtra(INDEX, position);
                bundle.putStringArrayList(BUNDLE_OF_SONGS, songsList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        listViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomePageActivity.this, ArtistDetailsActivity.class);
                intent.putExtra(ARTIST_NAME, artistList.get(position));
                startActivity(intent);
            }
        });

        gridViewAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
                intent.putExtra(NOW_PLAYING_TRACK, albumsList.get(position));
                startActivity(intent);
            }
        });
    }
}
