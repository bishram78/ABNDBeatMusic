package com.santosh.music.player;

/**
 * Created by BISHRAM MUNDA
 * Created on Friday 27/07/2018
 *
 * A custom ArrayAdapter (MusicAdapter) that is responsible for handling custom class with ListView;
 */

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class MusicAdapter extends ArrayAdapter<Music> {

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
