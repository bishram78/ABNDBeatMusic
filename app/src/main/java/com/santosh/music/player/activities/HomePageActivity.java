package com.santosh.music.player.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.santosh.music.player.R;
import com.santosh.music.player.adapters.AlbumAdapter;
import com.santosh.music.player.adapters.ArtistAdapter;
import com.santosh.music.player.adapters.MusicAdapter;
import com.santosh.music.player.models.Album;
import com.santosh.music.player.models.Artist;
import com.santosh.music.player.models.Music;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private Button buttonAllTracks;
    private Button buttonArtist;
    private Button buttonAlbum;
    private GridView gridViewAlbums;
    private GridView gridViewArtists;
    private ListView listViewTracks;

    private ArrayList<Music> songsList;
    private ArrayList<Artist> artistsList;
    private ArrayList<Album> albumsList;

    private static final String INDEX = "index";
    private static final String NO_OF_ARTIST_SONG = "no_of_artist_song";
    private static final String NO_OF_ALBUM_SONG = "no_of_album_song";
    private static final String ARTIST_NAME = "artist_name";
    private static final String ALBUM_NAME = "album_name";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_list";
    private static final String DURATION_LIST = "duration_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        referenceToIDs();
        addSongs();
        sortedArtists();
        sortedAlbums();
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
        songsList.add(new Music("A Girl Like Me - www.MyMp3Singers.com", "Rihana", "A Girl Like Me", "04:18"));
        songsList.add(new Music("As Long As You Love Me - www.SongsLover.SE", "Justin Bieber", "Believe", "03:41"));
        songsList.add(new Music("Baby Ft. Ludacris - www.Hungama.com", "Justin Bieber", "My World 2.0", "03:34"));
        songsList.add(new Music("Better That We Break - www.PagalWorld.com", "Maroon 5", "I Won't Be Soon Before Long", "03:21"));
        songsList.add(new Music("Break It Off With Sean Paul - www.PagalWorld.com", "Rihana", "A Girl Like Me", "03:33"));
        songsList.add(new Music("Burn - www.SongsLover.Info", "Usher", "Confessions", "03:44"));
        songsList.add(new Music("Eenie Meenie Ft. Sean Kingston - www.WebMusic.in", "Justin Bieber", "My World 2.0", "03:23"));
        songsList.add(new Music("Fashion - www.MyMp3Singers.com", "Guru Randhawa", "Single Mp3", "04:16"));
        songsList.add(new Music("Goriya Re Kaahe - www.SadriMuzik.com", "Unknown Artist", "Single Mp3", "05:09"));
        songsList.add(new Music("Handstand Ft. Shanell - www.DJMaza.Info", "Nicki Minaj", "Beam Me Up Scotty", "03:08"));
        songsList.add(new Music("I Get Crazy Ft. Lil Wayne - www.PagalWorld.com", "Nicki Minaj", "Beam Me Up Scotty", "03:41"));
        songsList.add(new Music("Lahore - www.DownloadMing.Info", "Guru Randhawa", "Single Mp3", "03:16"));
        songsList.add(new Music("Luhurr Luhurr - www.YouTube.com", "Unknown Artist", "E Kuri Aa Jana", "04:57"));
        songsList.add(new Music("Madwa Mein Mandar - www.Fun2Desi.com", "Monika & Egnesh", "Unknown Album", "05:11"));
        songsList.add(new Music("Pedal Mari Mari - www.JharkhandWap.In", "Babu Boruah", "Single Mp3", "04:38"));
        songsList.add(new Music("Remember The Name - www.PagalWorld.com", "Fort Minor", "Single Mp3", "03:49"));
        songsList.add(new Music("Rupa Re - www.NagpuriMasti.Net", "Akash Lohra", "Unknown Album", "05:40"));
        songsList.add(new Music("Sanu Ek Pal Chain Na - www.Songs.PK", "Rahat Fateh Ali Khan", "Raid", "08:25"));
        songsList.add(new Music("Sugar - www.SongsLover.Info", "Maroon 5", "Single Mp3", "03:56"));
        songsList.add(new Music("Tera Mera Milna - www.FreshMaza.In", "Himesh Reshammiya & Shreya Ghoshal", "Aap Kaa Surroor", "05:50"));
        songsList.add(new Music("That Should Be Me - www.BossMobi.IN", "Justin Bieber", "My World 2.0", "03:53"));
        songsList.add(new Music("Tirchhi Nazariya - www.SadriMuzik.Com", "Unknown Artist", "Unknown Album", "04:53"));
        songsList.add(new Music("Tumhein Dillagi - www.WebMusic.IN", "Rahat Fateh Ali Khan", "Dillagi", "06:26"));
        songsList.add(new Music("U Smile - www.DJMaza.Info", "Justin Bieber", "My World 2.0", "03:17"));
        songsList.add(new Music("Ya Ali - www.Gaana.com", "Himesh Reshammiya & Sunidhi Chauhan", "Aap Kaa Surroor", "04:32"));
        songsList.add(new Music("Yeah! Ft. Lil Jon & Ludacris - www.DJMaza.Info", "Usher", "Confessions", "04:10"));
        songsList.add(new Music("Zaroori Tha - www.DownloadMing.Info", "Rahat Fateh Ali Khan", "Unknown Album", "05:16"));
    }

    public void sortedArtists() {
        artistsList = new ArrayList<>();
        artistsList.add(new Artist("Akash Lohra"));
        artistsList.add(new Artist("Babu Boruah"));
        artistsList.add(new Artist("Fort Minor"));
        artistsList.add(new Artist("Guru Randhawa"));
        artistsList.add(new Artist("Justin Bieber"));
        artistsList.add(new Artist("Himesh Reshammiya & Shreya Ghoshal"));
        artistsList.add(new Artist("Himesh Reshammiya & Sunidhi Chauhan"));
        artistsList.add(new Artist("Maroon 5"));
        artistsList.add(new Artist("Monika & Egnesh"));
        artistsList.add(new Artist("Nicki Minaj"));
        artistsList.add(new Artist("Rahat Fateh Ali Khan"));
        artistsList.add(new Artist("Rihana"));
        artistsList.add(new Artist("Usher"));
        artistsList.add(new Artist("Unknown Artist"));
    }

    public void sortedAlbums() {
        albumsList = new ArrayList<>();
        albumsList.add(new Album("A Girl Like Me"));
        albumsList.add(new Album("Aap Kaa Surroor"));
        albumsList.add(new Album("Beam Me Up Scotty"));
        albumsList.add(new Album("Believe"));
        albumsList.add(new Album("Confessions"));
        albumsList.add(new Album("Dillagi"));
        albumsList.add(new Album("E Kuri Aa Jana"));
        albumsList.add(new Album("I Won't Be Soon Before Long"));
        albumsList.add(new Album("My World 2.0"));
        albumsList.add(new Album("Raid"));
        albumsList.add(new Album("Single Mp3"));
        albumsList.add(new Album("Unknown Album"));
    }

    private void setClicksDefault() {
        // Create {@links MusicAdapter, ArtistAdapter and AlbumAdapter}, whose data source is a
        // list of {@link Music, Artist and Album} respectively.
        // The Custom Adapter knows how to create layout for each item in the list, using the
        // list_item_4_song.xml, list_item_4_artist.xml and list_item_4_album.xml layout resource
        // defined in the res folder of the project.
        final MusicAdapter songsArrayAdapter = new MusicAdapter(this, songsList);
        ArtistAdapter artistsArrayAdapter = new ArtistAdapter(this, artistsList);
        AlbumAdapter albumsArrayAdapter = new AlbumAdapter(this, albumsList);

        // Attach the custom adapters to the ListView and GridViews.
        listViewTracks.setAdapter(songsArrayAdapter);
        gridViewArtists.setAdapter(artistsArrayAdapter);
        gridViewAlbums.setAdapter(albumsArrayAdapter);

        //This will select the All tracks tab and hide the other two i.e., Album and Artist tab on click.
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

        //This will select the Artist tab and hide the other two i.e., Artist and All tracks tab on click.
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

        //This will select the Album tab and hide the other two i.e., Artist and All tracks tab on click.
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

        //This is called when user clicks on the music item of list to play.
        listViewTracks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
                intent.putExtra(INDEX, position);

                ArrayList<String> trackList = new ArrayList<>();
                ArrayList<String> artistList = new ArrayList<>();
                ArrayList<String> albumList = new ArrayList<>();
                ArrayList<String> durationList = new ArrayList<>();

                for (int i=0; i<songsList.size(); i++) {
                    trackList.add(songsList.get(i).getSongTitle());
                    artistList.add(songsList.get(i).getSongArtist());
                    albumList.add(songsList.get(i).getSongAlbum());
                    durationList.add(songsList.get(i).getSongDuration());
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //This is called when user clicks on the artist item of list to play.
        gridViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomePageActivity.this, ArtistDetailsActivity.class);
                intent.putExtra(INDEX, position);
                intent.putExtra(ARTIST_NAME, artistsList.get(position).getSongArtist());

                ArrayList<String> trackList = new ArrayList<>();
                ArrayList<String> artistList = new ArrayList<>();
                ArrayList<String> albumList = new ArrayList<>();
                ArrayList<String> durationList = new ArrayList<>();
                int count = 0;

                for (int i = 0; i < songsList.size(); i++) {
                    if (songsList.get(i).getSongArtist().equals(artistsList.get(position).getSongArtist())) {
                        trackList.add(songsList.get(i).getSongTitle());
                        artistList.add(songsList.get(i).getSongArtist());
                        albumList.add(songsList.get(i).getSongAlbum());
                        durationList.add(songsList.get(i).getSongDuration());
                        count++;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                intent.putExtras(bundle);
                intent.putExtra(NO_OF_ARTIST_SONG, count);
                startActivity(intent);
            }
        });

        //This is called when user clicks on the album item of list to play.
        gridViewAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomePageActivity.this, AlbumDetailsActivity.class);
                intent.putExtra(INDEX, position);
                intent.putExtra(ALBUM_NAME, albumsList.get(position).getSongAlbum());

                ArrayList<String> trackList = new ArrayList<>();
                ArrayList<String> artistList = new ArrayList<>();
                ArrayList<String> albumList = new ArrayList<>();
                ArrayList<String> durationList = new ArrayList<>();
                int count = 0;

                for (int i = 0; i < songsList.size(); i++) {
                    if (songsList.get(i).getSongAlbum().equals(albumsList.get(position).getSongAlbum())) {
                        trackList.add(songsList.get(i).getSongTitle());
                        artistList.add(songsList.get(i).getSongArtist());
                        albumList.add(songsList.get(i).getSongAlbum());
                        durationList.add(songsList.get(i).getSongDuration());
                        count++;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(TRACK_LIST, trackList);
                bundle.putStringArrayList(ARTIST_LIST, artistList);
                bundle.putStringArrayList(ALBUM_LIST, albumList);
                bundle.putStringArrayList(DURATION_LIST, durationList);
                intent.putExtras(bundle);
                intent.putExtra(NO_OF_ALBUM_SONG, count);
                startActivity(intent);
            }
        });
    }
}
