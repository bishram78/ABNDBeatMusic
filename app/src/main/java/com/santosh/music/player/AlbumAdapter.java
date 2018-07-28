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

public class AlbumAdapter extends ArrayAdapter<Album> {
    public AlbumAdapter(Context context, ArrayList<Album> album) {
        super(context, 0, album);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_4_album, parent, false);
        }

        Album currentAlbum = getItem(position);
        TextView textViewAlbumTitle = listItemView.findViewById(R.id.id_li_al_album_title);
        assert currentAlbum != null;
        textViewAlbumTitle.setText(currentAlbum.getSongAlbum());
        return listItemView;
    }
}
