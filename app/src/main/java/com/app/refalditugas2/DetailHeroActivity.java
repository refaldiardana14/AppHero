package com.app.refalditugas2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.refalditugas2.databinding.ActivityDetailHeroBinding;

public class DetailHeroActivity extends AppCompatActivity {

    ActivityDetailHeroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailHeroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String namaHero = getIntent().getStringExtra("nama");
        String roleHero = getIntent().getStringExtra("role");
        int fotoHero = getIntent().getIntExtra("foto", 1);

        binding.nama.setText(namaHero);
        binding.role.setText(roleHero);
        binding.foto.setImageResource(fotoHero);
    }
}