package com.santosh.music.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //Find reference to View {@link ListView} by id;
        ListView listView = findViewById(R.id.listView);

        //Create list of data of type String which will serve as list items.
        final ArrayList<String> arrayList = new ArrayList<>();

        //Adding list items (i.e. Strings => One, Two, Three and so on);
        arrayList.add("Luhur Luhur - www.JharkhandWap.IN");
        arrayList.add("Sugar - www.SongsLover.Info");
        arrayList.add("Yeah - www.GaanaBajao.com");
        arrayList.add("Aaja Aaja - www.Songs.PK");
        arrayList.add("Re Chhori Rio Rio - www.Fun2Desi.com");

        //Create @link ArrayAdapter which handles the data of the @link ListView;
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.btn_enter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_enter);
                String string = editText.getText().toString();
                if (string.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Empty text cannot be added.", Toast.LENGTH_SHORT).show();
                } else {
                    arrayList.add(string);
                    adapter.notifyDataSetChanged();
                    editText.setText("");

                    try {
                        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                        assert inputMethodManager != null;
                        inputMethodManager.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(),0);
                    } catch (Exception e) {
                        //TODO: Handle exception
                    }
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomePageActivity.this, NowPlayingActivity.class);
                intent.putExtra("NOW_PLAYING_TRACK", arrayList.get(position));
                startActivity(intent);
                int curPosition = position + 1;
                Toast.makeText(getApplicationContext(), "Clicked item = " + arrayList.get(position) + " at position: " + curPosition + id , Toast.LENGTH_SHORT).show();
            }
        });
    }


}
