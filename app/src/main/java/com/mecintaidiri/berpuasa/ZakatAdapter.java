package com.mecintaidiri.berpuasa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class ZakatAdapter extends RecyclerView.Adapter<ZakatAdapter.ViewHolder>{

    private ArrayList<Item> ItemArrayList;
    private Context context;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private String itunya;
    ZakatAdapter(ArrayList<Item> coursesArrayList, Context context){
        this.ItemArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ZakatAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_zakat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item hitam = ItemArrayList.get(position);
        holder.judul.setText(hitam.getJudul());
        if (hitam.getGambar() == null) {
            holder.imageView.setImageResource(R.drawable.logoapp);
        } else {
            String bytea = hitam.getGambar();
            byte[] bytes = Base64.decode(bytea, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            holder.imageView.setImageBitmap(bitmap);
            itunya =  hitam.getGambar();
        }
    }

    @Override
    public int getItemCount() {
        return ItemArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView judul;
        private final ImageView imageView;
        private final RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.namazakat);
            imageView = itemView.findViewById(R.id.imageview);
            relativeLayout = itemView.findViewById(R.id.recyclerviewzakat);
            relativeLayout.setOnClickListener(v -> {
                Toast.makeText(context.getApplicationContext(), "AHa", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
