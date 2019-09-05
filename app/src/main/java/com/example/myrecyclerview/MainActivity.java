package com.example.myrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCharacter;
    private ArrayList<Character> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCharacter = findViewById(R.id.rv_character);
        rvCharacter.setHasFixedSize(true);

        list.addAll(CharacterData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCharacter.setLayoutManager(new LinearLayoutManager(this));
        ListCharacterAdapter listHeroAdapter = new ListCharacterAdapter(list);
        rvCharacter.setAdapter(listHeroAdapter);

        listHeroAdapter.setOnItemClickCallback(new ListCharacterAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Character data) {
                showSelectedCharacter(data);
            }
        });
    }

    private void showSelectedCharacter(Character character) {
        Toast.makeText(this, "Kamu memilih " + character.getName(), Toast.LENGTH_SHORT).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onComposeAction(MenuItem item) {
        Intent about = new Intent(MainActivity.this, About.class);
        startActivity(about);
    }
}