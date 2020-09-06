package com.example.amchack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class BirdsAdapter extends RecyclerView.Adapter<BirdsAdapter.CardViewHolder>  {

    private OnItemClickListener mListener;
    private ArrayList<Bird> mBirds = new ArrayList<>();

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BirdsAdapter.CardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.bird_card,
                        parent,
                        false
                ), mListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(mBirds.get(position));
    }

    @Override
    public int getItemCount() {
        return mBirds.size();
    }

    public void setItems(Collection<Bird> soundItems) {
        mBirds.addAll(soundItems);
        notifyDataSetChanged();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public CardViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_for_card);
            textView = itemView.findViewById(R.id.text_for_card);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

        public void bind(Bird bird) {
            imageView.setImageBitmap(getBitmapFromURL(bird.getPicture()));
            textView.setText(bird.getName());
        }

        public static Bitmap getBitmapFromURL(String src) {
            try {
                URL url = new URL(src);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                return null;
            }
        }
    }
}
