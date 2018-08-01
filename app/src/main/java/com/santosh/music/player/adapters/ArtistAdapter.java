package com.santosh.music.player.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.santosh.music.player.R;
import com.santosh.music.player.models.Artist;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    /**
     * This is our custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param artist     A list of Music objects to display in a list.
     */
    public ArtistAdapter(Context context, ArrayList<Artist> artist) {
        /*
         * Here, we initialize the ArrayAdapter's internal storage for the context and the List.
         * the second argument is used when the ArrayAdapter is populating a single TextView.
         * Since this is also a Custom Adapter for single TextViews but with custom layout, the
         * adapter is no longer going to use this second argument, so it can be any value. Here,
         * we used 0;
         */
        super(context, 0, artist);
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
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_4_artist, parent, false);
        }

        // Get the {@link Artist} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextViews in the list_item_4_artist.xml layout with the IDs textView
        TextView textViewArtistTitle = listItemView.findViewById(R.id.textView);

        // Get the Artist from the current Artist object and set the text on the textView
        assert currentArtist != null;
        textViewArtistTitle.setText(currentArtist.getSongArtist());
        return listItemView;
    }
}
