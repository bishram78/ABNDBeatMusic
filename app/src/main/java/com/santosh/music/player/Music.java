package com.santosh.music.player;

/**
 * Created by BISHRAM MUNDA
 * Created on FRIDAY 27/07/2018
 * Music (This) is our model of Music that a user wants to listen.
 * This is the Custom Class.
 * Object of this class will have 4 properties:-
 * 1. SONG_TITLE, 2. ARTIST_NAME, 3. ALBUM_NAME and 4. DURATION_OF_SONG
 */

public class Music {

    /** A private field that holds the SONG_TITLE of the app */
    private String mSongTitle;

    /* A private field that holds the ARTIST_NAME of the app */
    private String mSongArtist;

    /* A private field that holds the ALBUM_NAME of the app */
    private String mSongAlbum;

    /** A private field that holds the DURATION_OF_SONG */
    private String mSongDuration;

    // The constructor of the class (necessary)
    public Music(String songTitle, String songArtist, String songAlbum, String songDuration) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
        mSongDuration = songDuration;
    }

    /** GET THE TITLE OF THE SONG */
    public String getSongTitle() {
        return mSongTitle;
    }

    /** GET THE ARTIST META DATA OF THE SONG */
    public String getSongArtist() {
        return mSongArtist;
    }

    /** GET THE ALBUM META DATA OF THE SONG */
    public String getSongAlbum() {
        return mSongAlbum;
    }

    /** GET THE DURATION META DATA OF THE APP */
    public String getSongDuration() {
        return mSongDuration;
    }
}
