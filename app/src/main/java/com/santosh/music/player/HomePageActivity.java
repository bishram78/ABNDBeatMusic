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
    private GridView gridViewArtists;
    private ListView listViewTracks;

    private ArrayList<Music> songsList;
    private ArrayList<Artist> artistList;
    private ArrayList<Album> albumsList;

    private Bundle bundle;
    private Intent intent;

    private static final String INDEX = "index";

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
        gridViewArtists = findViewById(R.id.id_ahp_list_4_artist);
        gridViewAlbums = findViewById(R.id.id_ahp_grid_4_album);
        listViewTracks = findViewById(R.id.id_ahp_list_4_all_tracks);
    }

    private void addSongs() {
        //Create an ArrayList of Music Objects;
        songsList = new ArrayList<>();
        songsList.add(new Music("Song Title 01 - www.source.com", "Artist 01", "Album 01", "04:30"));
        songsList.add(new Music("Song Title 02 - www.source.com", "Artist 02", "Album 02", "03:37"));
        songsList.add(new Music("Song Title 03 - www.source.com", "Artist 03", "Album 03", "05:49"));
        songsList.add(new Music("Song Title 04 - www.source.com", "Artist 04", "Album 04", "03:59"));
        songsList.add(new Music("Song Title 05 - www.source.com", "Artist 05", "Album 05", "05:20"));
        songsList.add(new Music("Song Title 06 - www.source.com", "Artist 06", "Album 06", "03:46"));
        songsList.add(new Music("Song Title 07 - www.source.com", "Artist 07", "Album 07", "03:10"));
        songsList.add(new Music("Song Title 08 - www.source.com", "Artist 08", "Album 08", "06:20"));
        songsList.add(new Music("Song Title 09 - www.source.com", "Artist 09", "Album 09", "05:02"));
        songsList.add(new Music("Song Title 10 - www.source.com", "Artist 10", "Album 10", "06:39"));
        songsList.add(new Music("Song Title 11 - www.source.com", "Artist 11", "Album 12", "03:54"));
        songsList.add(new Music("Song Title 12 - www.source.com", "Artist 12", "Album 12", "04:00"));
        songsList.add(new Music("Song Title 13 - www.source.com", "Artist 13", "Album 13", "03:27"));
        songsList.add(new Music("Song Title 14 - www.source.com", "Artist 14", "Album 14", "05:00"));
        songsList.add(new Music("Song Title 15 - www.source.com", "Artist 15", "Album 15", "04:45"));
        songsList.add(new Music("Song Title 16 - www.source.com", "Artist 16", "Album 16", "05:05"));
        songsList.add(new Music("Song Title 17 - www.source.com", "Artist 17", "Album 17", "04:40"));
        songsList.add(new Music("Song Title 18 - www.source.com", "Artist 18", "Album 18", "03:11"));
        songsList.add(new Music("Song Title 19 - www.source.com", "Artist 19", "Album 19", "03:56"));
        songsList.add(new Music("Song Title 20 - www.source.com", "Artist 20", "Album 20", "06:06"));
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

    public void addArtists() {
        artistList = new ArrayList<>();
        for(int i = 0; i < songsList.size()-1; i++) {
            artistList.add(new Artist(songsList.get(i).getSongArtist()));
        }
    }

    public void addAlbums() {
        albumsList = new ArrayList<>();
        for(int i = 0; i < songsList.size()-1; i++) {
            albumsList.add(new Album(songsList.get(i).getSongAlbum()));
        }
    }

    private void setClicksDefault() {
        // Create an {@link SongAdapter}, whose data source is a list of {@link Music}
        // The adapter knows how to create layout for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android Framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set
        // display a single Word.
        SongAdapter songsArrayAdapter = new SongAdapter(this, songsList);

        // Attach the custom adapter to the ListView.
        listViewTracks.setAdapter(songsArrayAdapter);

        ArtistAdapter artistsArrayAdapter = new ArtistAdapter(this, artistList);
        gridViewArtists.setAdapter(artistsArrayAdapter);

        AlbumAdapter albumsArrayAdapter = new AlbumAdapter(this, albumsList);
        gridViewAlbums.setAdapter(albumsArrayAdapter);

        buttonAllTracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listViewTracks.setVisibility(View.VISIBLE);
                gridViewArtists.setVisibility(View.GONE);
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
                gridViewArtists.setVisibility(View.VISIBLE);
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
                gridViewArtists.setVisibility(View.GONE);
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
                intent.putExtra(NOW_PLAYING_TRACK, songsList.get(position).getSongTitle());
                intent.putExtra(ARTIST_NAME, songsList.get(position).getSongArtist());
                intent.putExtra(ALBUM_NAME, songsList.get(position).getSongAlbum());
                intent.putExtra(INDEX, position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        gridViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomePageActivity.this, ArtistDetailsActivity.class);
                intent.putExtra(ARTIST_NAME, artistList.get(position).getSongArtist());
                startActivity(intent);
            }
        });

        gridViewAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
                intent.putExtra(NOW_PLAYING_TRACK, albumsList.get(position).getSongAlbum());
                startActivity(intent);
            }
        });
    }
}
