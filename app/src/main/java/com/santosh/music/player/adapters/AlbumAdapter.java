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
import com.santosh.music.player.models.Album;

import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {
    /**
     * This is our custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param album     A list of Music objects to display in a list.
     */
    public AlbumAdapter(Context context, ArrayList<Album> album) {
        /*
         * Here, we initialize the ArrayAdapter's internal storage for the context and the List.
         * the second argument is used when the ArrayAdapter is populating a single TextView.
         * Since this is also a Custom Adapter for single TextViews but with custom layout, the
         * adapter is no longer going to use this second argument, so it can be any value. Here,
         * we used 0;
         */
        super(context, 0, album);
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
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_4_album, parent, false);
        }

        // Get the {@link Album} object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextViews in the list_item_4_album.xml layout with the IDs id_li_al_album_title
        TextView textViewAlbumTitle = listItemView.findViewById(R.id.id_li_al_album_title);

        // Get the Album from the current Album object and set the text on the  textView
        assert currentAlbum != null;
        textViewAlbumTitle.setText(currentAlbum.getSongAlbum());
        return listItemView;
    }
}
