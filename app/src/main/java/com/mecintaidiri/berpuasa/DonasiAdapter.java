package com.mecintaidiri.berpuasa;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mecintaidiri.berpuasa.databinding.ItemViewDonasiBinding;

import org.w3c.dom.Text;

import java.lang.annotation.Target;
import java.util.ArrayList;

public class DonasiAdapter extends RecyclerView.Adapter<DonasiAdapter.ViewHolder>{

    private ArrayList<Item> ItemArrayList;
    private Context context;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private String itunya;
    DonasiAdapter(ArrayList<Item> coursesArrayList, Context context){
        this.ItemArrayList = coursesArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public DonasiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_donasi, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DonasiAdapter.ViewHolder holder, int position) {
        Item hitam = ItemArrayList.get(position);
        holder.judul.setText(hitam.getJudul());
        holder.relativeLayout.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hitam.getLink()));
            context.startActivity(browserIntent);
        });
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
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
