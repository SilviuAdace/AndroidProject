package com.example.project.ui.schedule;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;


import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {
    private ArrayList<ImageList> imageLists = new ArrayList<>();

    ImageAdapter(ArrayList<ImageList> images)
    {
        imageLists = images;
    }
    @NonNull
    @Override
    public ImageAdapter.ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_list, parent, false);
        return new ImageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageHolder holder, int position) {
        holder.imageId.setImageResource(imageLists.get(position).getImageid());
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageId;

        public ImageHolder(View itemView) {
            super(itemView);
            imageId = itemView.findViewById(R.id.imageId);
        }
    }
}