package com.mecintaidiri.berpuasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mecintaidiri.berpuasa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.home:
                    break;

                case R.id.zakat:
                    break;

                case R.id.donasi:
                    break;

                case R.id.profil:
                    break;
            }

            return true;
        });

    }
}