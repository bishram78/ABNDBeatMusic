package com.santosh.music.player;

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

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

    /**
     * This is our custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout finle, and the List is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param musics    A list of Music objects to display in a list.
     */
    public MusicAdapter(Context context, ArrayList<Music> musics) {
        /*
         * Here, we initialize the ArrayAdapter's internal storage for the context and the List.
         * the second argument is used when the ArrayAdapter is populating a single TextView.
         * Because this is a Custom Adapter for two TextViews, the adapter is no longer
         * going to use this second argument, so it can be any value. Here, we used 0;
         */
        super(context, 0, musics);
    }

    @NonNull
    /*
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position  The AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     *                  (Search online for "android view recycling" to learn more)
     * @param parent    The parent ViewGroup that is used for inflation
     * @param return    The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.music_list_item, parent, false);
        }

        // Get the {@link Music} boject located at this position in the list
        Music currentMusic = getItem(position);

        // Find the TextView in the music_list_item.xml layout with the ID id_mli_title
        TextView textViewTitle = listItemView.findViewById(R.id.id_mli_title);

        // Get the Title from the current Music object and set the text on the Title's textView
        textViewTitle.setText(currentMusic.getSongTitle());
        return listItemView;
    }
}
