package com.santosh.music.player;

public class Artist {

    /* A private field that holds the ALBUM_NAME of the app */
    private String mSongArtist;

    // The constructor of the class (necessary)
    public Artist(String songArtist) {
        mSongArtist = songArtist;
    }

    /** GET THE ALBUM META DATA OF THE SONG */
    public String getSongArtist() {
        return mSongArtist;
    }
}
