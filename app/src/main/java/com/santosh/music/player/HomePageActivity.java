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

    private ArrayList<Music> songsList;
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

        //Create an ArrayList of Music Objects;
        ArrayList<Music> songsList = new ArrayList<>();
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
        songsList.add(new Music("Aaj Mood Ishqholiq Hai - www.PagalWorld.com"));
        songsList.add(new Music("Along The Coast - www.BossMp3.IN"));
        songsList.add(new Music("Bandook - www.SongsCloud.IN"));
        songsList.add(new Music("Beautiful Feat. Colby Odonis - www.WapKing.FM"));
        songsList.add(new Music("Begar Jhore Nai Aaboo (Toore) - www.JharkhandWap.IN"));
        songsList.add(new Music("Better Than Revenge - www.RaagJatt.Com"));
        songsList.add(new Music("Blame Feat The Newman - www.FazMusic.Net"));
        songsList.add(new Music("Chaand Lakhe Rupa Gori - www.Fun2Desi.com"));
        songsList.add(new Music("Chicken Song - www.SongsPK.Link"));
        songsList.add(new Music("Dil Jala Raat Hua - www.NaGpuriMp3.In"));
        songsList.add(new Music("Down To Earth - www.SongsLover.Info"));
        songsList.add(new Music("Enchanted - www.WebMusic.IN"));
        songsList.add(new Music("Eraser - www.SongsLover.Info"));
        songsList.add(new Music("Favourite Girl - www.9xTune.com"));
        songsList.add(new Music("Gaddi Ft. Veer Karan - Rob C - www.Mr-Punjab.Com"));
        songsList.add(new Music("Gora Gora Badan Re Goriya - www.NaGpuriMp3.IN"));
        songsList.add(new Music("Ishq Achcha Lagta Hai - www.DJMaza.Info"));
        songsList.add(new Music("Hey Ma Feat. Camila Cabello - www.RaagTune.com"));
        songsList.add(new Music("I Wanna Go - www.RaagJatt.Com"));
        songsList.add(new Music("Jab Toy Dekhle Ulait - www.Fun2Desi.com"));
        songsList.add(new Music("Jaanta Tha - www.MyMp3Singer.com"));
        songsList.add(new Music("Koi Chehra - www.RaagJatt.com"));
        songsList.add(new Music("Let Me Love You Feat. Justin Bieber - www.DJMaza.Info"));
        songsList.add(new Music("Love You Like Love Song - www.WebMusic.In"));
        songsList.add(new Music("Mere Lamhon Ki Aarzoo - www.WebMusic.In"));
        songsList.add(new Music("Naina Se Lor Bahela (DJ Remix By Guru) - www.NagpuriWap.IN"));
        songsList.add(new Music("One Dance Ft. Justin Bieber - www.9xTune.com"));
        songsList.add(new Music("Pal Pal Dil Ke Paas - www.Songs.Pk"));
        songsList.add(new Music("Saanson Ke - www.MyMp3Songs.Info"));
        songsList.add(new Music("See You Again Ft. Charlie Puth - wwww.RiskyjaTT.CoM"));
        songsList.add(new Music("Something New Feat. Chris Brown - www.Howwe.Biz"));
        songsList.add(new Music("Swag Babe Ft. Millind Gaba - wwww.PagalWorld.com"));
        songsList.add(new Music("Thanda Thanda Cool Cool (Dance Mix By DJ Chandan) - www.DjOnly.IN"));
        songsList.add(new Music("Tore Se Pyaar - www.SadriMasti.IN"));
        songsList.add(new Music("Yeah Ft. Lil Jon and Ludacris - www.SongsLover.Info"));
        songsList.add(new Music("Zindagi Gulzar Hai - www.PakHeaven.Com"));
        songsList.add(new Music("Zindegi (Unplugged) - www.Fun2Desi.com"));
    }

    public void addArtists() {
        artistList = new ArrayList<>();
        artistList.add("Akon");
        artistList.add("Arash");
        artistList.add("Big Sean");
        artistList.add("B.L.U.E.");
        artistList.add("BossMp3.IN");
        artistList.add("Britney Spears");
        artistList.add("Bryan Adam");
        artistList.add("Charlie Puth");
        artistList.add("David Correy");
        artistList.add("D.J. Snake");
        artistList.add("Ed Sheeran");
        artistList.add("Eric Bellinger");
        artistList.add("Fifth Harmony");
        artistList.add("Jessie J");
        artistList.add("Justin Bieber");
        artistList.add("Kesha");
        artistList.add("Meghan Trainor");
        artistList.add("One Direction");
        artistList.add("Selena Gomez & The Scene");
        artistList.add("Snoop Dogg");
        artistList.add("Tailor Swift");
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
        // Create an {@link MusicAdapter}, whose data source is a list of {@link Music}
        // The adapter knows how to create layout for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android Framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set
        // display a single Word.
        MusicAdapter songsArrayAdapter = new MusicAdapter(this, songsList);

        // Attach the custom adapter to the ListView.
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
                //intent.putExtra(NOW_PLAYING_TRACK, songsList.get(position));
                intent.putExtra(INDEX, position);
                //bundle.putStringArrayList(BUNDLE_OF_SONGS, songsList);
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
