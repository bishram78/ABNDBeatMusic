package com.santosh.music.player.adapters;

/*
 * Created by BISHRAM MUNDA
 * Created on Friday 27/07/2018
 *
 * A custom ArrayAdapter (MusicAdapter) that is responsible for handling custom class with ListView;
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.santosh.music.player.R;
import com.santosh.music.player.models.Music;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    /**
     * This is our custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param music     A list of Music objects to display in a list.
     */
    public MusicAdapter(Context context, ArrayList<Music> music) {
        /*
         * Here, we initialize the ArrayAdapter's internal storage for the context and the List.
         * the second argument is used when the ArrayAdapter is populating a single TextView.
         * Because this is a Custom Adapter for four TextViews, the adapter is no longer
         * going to use this second argument, so it can be any value. Here, we used 0;
         */
        super(context, 0, music);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position      The AdapterView position that is requesting a view
     * @param convertView   The recycled view to populate.
     *                      (Search online for "android view recycling" to learn more)
     * @param parent        The parent ViewGroup that is used for inflation
     * return               The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_4_song, parent, false);
        }

        // Get the {@link Music} object located at this position in the list
        Music currentMusic = getItem(position);

        // Find the TextViews in the list_item_4_song.xml layout with the IDs id_mli_title,
        // id_mli_artist_album and id_mli_duration
        TextView textViewTitle = convertView.findViewById(R.id.id_mli_title);
        TextView textViewArtistAlbum = convertView.findViewById(R.id.id_mli_artist_album);
        TextView textViewDuration = convertView.findViewById(R.id.id_mli_duration);

        // Get the Title, Artist, Album and Duration from the current Music object and set the text
        // on the respective textViews
        assert currentMusic != null;
        textViewTitle.setText(currentMusic.getSongTitle());
        String artist_album = String.format("%s | %s", currentMusic.getSongArtist(), currentMusic.getSongAlbum());
        textViewArtistAlbum.setText(artist_album);
        textViewDuration.setText(currentMusic.getSongDuration());
        return convertView;
    }
}
