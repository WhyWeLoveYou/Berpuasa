package com.mecintaidiri.berpuasa;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.firestore.FirebaseFirestore;
import com.mecintaidiri.berpuasa.databinding.ActivityCumanNambahDataBinding;
import com.mecintaidiri.berpuasa.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityCumanNambahDataBinding binding;

    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCumanNambahDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addItem();
    }

    private void addItem() {
        firestore = FirebaseFirestore.getInstance();

    }
}