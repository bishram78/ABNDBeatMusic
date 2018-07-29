package com.santosh.music.player;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

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
    private static final String NO_OF_SONG = "no_of_song";
    private static final String ARTIST_NAME = "artist_name";
    private static final String TRACK_LIST = "track_list";
    private static final String ARTIST_LIST = "artist_list";
    private static final String ALBUM_LIST = "album_name";
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
//        songsList.add(new Music("Mere Lamhon Ki Aarzoo - www.WebMusic.In", "Himesh Reshammiya", "Aarzoo", "05:50"));
//        songsList.add(new Music("Naina Se Lor Bahela (DJ Remix By Guru) - www.NagpuriWap.IN", "Pawan & Mittal Devi", "Adhunik Nagpuri", "06:30"));
//        songsList.add(new Music("One Dance Ft. Justin Bieber - www.9xTune.com", "Chris Brown", "Once Dance", "02:58"));
//        songsList.add(new Music("Pal Pal Dil Ke Paas - www.Songs.Pk", "Sanam Puri", "Single Mp3", "04:39"));
//        songsList.add(new Music("Saanson Ke - www.MyMp3Songs.Info", "Azhar Kakkar", "Masoom Chehra", "04:42"));
//        songsList.add(new Music("See You Again Ft. Charlie Puth - wwww.RiskyjaTT.CoM", "Wiz Khalifa", "Fast & Furious", "04:42"));
//        songsList.add(new Music("Something New Feat. Chris Brown - www.Howwe.Biz", "Charlie Puth", "Slow Down", "03:51"));
//        songsList.add(new Music("Swag Babe Ft. Millind Gaba - wwww.PagalWorld.com", "Badshah", "Swaagat", "04:08"));
//        songsList.add(new Music("Thanda Thanda Cool Cool (Dance Mix By DJ Chandan) - www.DjOnly.IN", "Hemlata & Ramesh", "Barf Badan", "05:06"));
//        songsList.add(new Music("Tore Se Pyaar - www.SadriMasti.IN", "Munna Dhamal & Supriya", "Tore Se Pyaar", "06:00"));
//        songsList.add(new Music("Yeah Ft. Lil Jon and Ludacris - www.SongsLover.Info", "Usher", "Confessions", "04:00"));
//        songsList.add(new Music("Zindagi Gulzar Hai - www.PakHeaven.Com", "Nikita & Nisha", "Zindagi Ke Rang", "05:00"));
//        songsList.add(new Music("Zindegi (Unplugged) - www.Fun2Desi.com", "Shael Oswal", "Zindagi Universal", "04:44"));
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
        artistsList.add(new Artist("Unknown"));
    }

    public void sortedAlbums() {
        albumsList = new ArrayList<>();
        albumsList.add(new Album("A Girls Like Me"));
        albumsList.add(new Album("Aap Kaa Surroor"));
        albumsList.add(new Album("Beam Me Up Scotty"));
        albumsList.add(new Album("Confessions"));
        albumsList.add(new Album("E Kuri Aa Jana"));
        albumsList.add(new Album("I Won't Be Soon Before Long"));
        albumsList.add(new Album("My World 2.0"));
        albumsList.add(new Album("Raid"));
        albumsList.add(new Album("Single Mp3"));
        albumsList.add(new Album("Unknown"));
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
                //Toast.makeText(getApplicationContext(), String.valueOf(position) + String.valueOf(songsList.size()), Toast.LENGTH_SHORT).show();
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

        gridViewArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomePageActivity.this, ArtistDetailsActivity.class);
                intent.putExtra(INDEX, position);
                intent.putExtra("ARTIST_NAME", artistsList.get(position).getSongArtist());
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
                intent.putExtra("NO_OF_SONG", count);
                startActivity(intent);
            }
        });

//        gridViewAlbums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
//                intent.putExtra(NOW_PLAYING_TRACK, albumList.get(position).getSongAlbum());
//                startActivity(intent);
//            }
//        });
    }
}
