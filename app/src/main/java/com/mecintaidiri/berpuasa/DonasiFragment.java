package com.mecintaidiri.berpuasa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mecintaidiri.berpuasa.databinding.FragmentDonasiBinding;

import java.nio.file.FileStore;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DonasiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DonasiFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<Item> doasiArrayList;
    private FragmentDonasiBinding binding;
    private DonasiAdapter donasiAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDonasiBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}