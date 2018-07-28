package com.santosh.music.player;

public class Album {

    /* A private field that holds the ALBUM_NAME of the app */
    private String mSongAlbum;

    // The constructor of the class (necessary)
    public Album(String songAlbum) {
        mSongAlbum = songAlbum;
    }

    /** GET THE ALBUM META DATA OF THE SONG */
    public String getSongAlbum() {
        return mSongAlbum;
    }
}
