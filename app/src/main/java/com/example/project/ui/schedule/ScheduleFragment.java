package com.example.project.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {

    private ScheduleViewModel scheduleViewModel;
    private RecyclerView imageList;
    private RecyclerView.Adapter imageAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        scheduleViewModel = ViewModelProviders.of(this).get(ScheduleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_schedule, container, false);
        imageList = root.findViewById(R.id.rv);
        imageList.hasFixedSize();
        imageList.setLayoutManager(new LinearLayoutManager(root.getContext()));

        ArrayList<ImageList> images = new ArrayList<>();
        images.add(new ImageList(R.drawable.a1));
        images.add(new ImageList(R.drawable.a2));
        images.add(new ImageList(R.drawable.a3));
        images.add(new ImageList(R.drawable.a4));
        images.add(new ImageList(R.drawable.a5));
        images.add(new ImageList(R.drawable.a6));
        images.add(new ImageList(R.drawable.a7));
        images.add(new ImageList(R.drawable.a8));

        imageAdapter = new ImageAdapter(images);
        imageList.setAdapter(imageAdapter);

        return root;
    }
}