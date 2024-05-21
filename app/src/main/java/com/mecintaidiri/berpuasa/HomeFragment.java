package com.mecintaidiri.berpuasa;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mecintaidiri.berpuasa.databinding.FragmentHomeBinding;
import com.mecintaidiri.berpuasa.databinding.FragmentZakatBinding;
import com.mecintaidiri.berpuasa.databinding.FragmentHitungBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<Item> zakatArrayList;
    private FragmentHitungBinding binding;
    private ZakatAdapter zakatAdapter;
    private ArrayList<Item> doasiArrayList;
    private DonasiAdapter donasiAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHitungBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hitung();
    }
    private void hitung() {
        binding.button.setOnClickListener(v -> {
            String input = String.valueOf(binding.Angka.getText());
            if (input.isEmpty()) {
                Toast.makeText(getContext(), "Jangan Kosong", Toast.LENGTH_SHORT).show();
            } else if (input.matches("[a-zA-Z]+")){
                Toast.makeText(getContext(), "Harus Angka", Toast.LENGTH_SHORT).show();
            } else {
                Double angka = Double.valueOf(input);
                String hasil = String.valueOf(angka * 25/10/100);
                binding.Hasil.setText(hasil);
            }
        });
    }
}