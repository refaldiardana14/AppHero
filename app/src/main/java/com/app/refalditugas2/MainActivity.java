package com.app.refalditugas2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.refalditugas2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    HeroAdapter heroAdapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] namaHero = getResources().getStringArray(R.array.nama_hero);
        String[] roleHero = getResources().getStringArray(R.array.role_hero);
        String[] fotoHero = getResources().getStringArray(R.array.foto_hero);

        heroList = new ArrayList<>();
        for (int i = 0; i < namaHero.length; i++) {
            heroList.add(new Hero(namaHero[i], roleHero[i], fotoHero[i]));
        }

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        heroAdapter = new HeroAdapter(heroList);
        binding.recyclerView.setAdapter(heroAdapter);


    }
}