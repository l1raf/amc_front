package com.example.amchack;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FilteredBirdsAdapter extends RecyclerView.Adapter<FilteredBirdsAdapter.CardViewHolder>  {

    private OnItemClickListener mListener;
    private ArrayList<Bird> birdList = new ArrayList<Bird>();
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public  FilteredBirdsAdapter(Context context, ArrayList<Bird> birdList) {
        this.birdList = birdList;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilteredBirdsAdapter.CardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.card_for_filtered,
                        parent,
                        false
                ), mListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        //holder.imageView.setImageBitmap(getBitmapFromURL(birdList.get(position).getPicture()));
        holder.textView.setText(birdList.get(position).getName());
       // Picasso.get().load(getBitmapFromURL(birdList.get(position).getPicture())).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public CardViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.filtered_image);
            textView = itemView.findViewById(R.id.filtered_tv);

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

    public void setNewList(ArrayList<Bird> birdlist){
        this.birdList = birdlist;
        notifyDataSetChanged();
    }
}
