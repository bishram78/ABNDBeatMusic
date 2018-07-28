package com.santosh.music.player;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {
    public ArtistAdapter(Context context, ArrayList<Artist> artist) {
        super(context, 0, artist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_4_artist, parent, false);
        }

        Artist currentArtist = getItem(position);
        TextView textViewArtistTitle = listItemView.findViewById(R.id.textView);
        assert currentArtist != null;
        textViewArtistTitle.setText(currentArtist.getSongArtist());
        return listItemView;
    }
}
