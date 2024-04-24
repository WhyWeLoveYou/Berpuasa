package com.mecintaidiri.berpuasa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.mecintaidiri.berpuasa.databinding.FragmentZakatBinding;

import java.util.ArrayList;
import java.util.List;

public class ZakatFragment extends Fragment {

    private FirebaseAuth auth;
    private FirebaseFirestore firebaseFirestore;
    private ArrayList<Item> zakatArrayList;
    private FragmentZakatBinding binding;
    private ZakatAdapter zakatAdapter;
    private DonasiAdapter donasiAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentZakatBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getItem();
    }

    private void getItem() {
        auth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        zakatArrayList = new ArrayList<Item>();
        binding.recyclerviewzakat.setHasFixedSize(true);
        binding.recyclerviewzakat.setLayoutManager(new LinearLayoutManager(getContext()));
        zakatAdapter = new ZakatAdapter(zakatArrayList, getContext());

        binding.recyclerviewzakat.setAdapter(zakatAdapter);
        firebaseFirestore.collection("zakat").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Item c = d.toObject(Item.class);
                                zakatArrayList.add(c);
                            }
                            zakatAdapter.notifyDataSetChanged();
                        }
                    }
                });

    }
}