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
    private static final String ALBUM_NAME = "album_name";
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
        songsList.add(new Music("Chicken Song - www.SongsPK.Link", "Mika Singh", "Bollywood Party", "05:02"));
        songsList.add(new Music("Dil Jala Raat Hua - www.NaGpuriMp3.In", "Munna Dhamal", "Gaon Ker Gori", "06:39"));
        songsList.add(new Music("Down To Earth - www.SongsLover.Info", "Justin Bieber", "My World 2.0", "03:54"));
        songsList.add(new Music("Enchanted - www.WebMusic.IN", "Taylor Swift", "Enchanted", "04:00"));
        songsList.add(new Music("Eraser - www.SongsLover.Info", "Unknown Artist", "Latest English Song", "03:27"));
        songsList.add(new Music("Favourite Girl - www.9xTune.com", "Justin Bieber", "My World 2.0", "05:00"));
        songsList.add(new Music("Gaddi Ft. Veer Karan - Rob C - www.Mr-Punjab.Com", "Rob C", "Meri Gaddi", "04:45"));
        songsList.add(new Music("Gora Gora Badan Re Goriya - www.NaGpuriMp3.IN", "Munna Dhamal", "Gaon Ker Gori", "05:05"));
        songsList.add(new Music("Ishq Achcha Lagta Hai - www.DJMaza.Info", "Unknown Artist", "Romantic Song", "04:40"));
        songsList.add(new Music("Hey Ma Feat. Camila Cabello - www.RaagTune.com", "Camila Cabello", "More Power", "03:11"));
        songsList.add(new Music("I Wanna Go - www.RaagJatt.Com", "Mey Mee", "Northern People", "03:56"));
        songsList.add(new Music("Jab Toy Dekhle Ulait - www.Fun2Desi.com", "Raju & Monika", "Adhunik Nagpuri", "06:06"));
        songsList.add(new Music("Jaanta Tha - www.MyMp3Singer.com", "Kavita Krishnamurthy", "Masoom", "05:32"));
        songsList.add(new Music("Koi Chehra - www.RaagJatt.com", "Alda Kaur", "Koi Chehra", "05:19"));
        songsList.add(new Music("Let Me Love You Feat. Justin Bieber - www.DJMaza.Info", "DJ Snake", "Latest English", "04:48"));
        songsList.add(new Music("Love You Like Love Song - www.WebMusic.In", "Selena Gomez", "My Love", "03:40"));
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
                intent.putExtra(NOW_PLAYING_TRACK, songsList.get(position).getSongTitle());
                intent.putExtra(ARTIST_NAME, songsList.get(position).getSongArtist());
                intent.putExtra(ALBUM_NAME, songsList.get(position).getSongAlbum());
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
