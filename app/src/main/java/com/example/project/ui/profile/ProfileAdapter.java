package com.example.project.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileHolder>{
    private List<Profile> profiles = new ArrayList<>();

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_item, parent, false);
        return new ProfileHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, int position) {
        Profile currentProfile = profiles.get(position);

        System.out.println(currentProfile.getTitle());

        holder.textViewTitle.setText(currentProfile.getTitle());
        holder.textViewDescription.setText(currentProfile.getDescription());
        holder.textViewPriority.setText(currentProfile.getPriority());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    public void setNotes(List<Profile> profiles) {
        this.profiles = profiles;
     //   notifyDataSetChanged();
    }
    class ProfileHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public ProfileHolder(View itemView){
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription=itemView.findViewById(R.id.text_view_description);
            textViewPriority=itemView.findViewById(R.id.text_view_priority);
        }
    }
}
