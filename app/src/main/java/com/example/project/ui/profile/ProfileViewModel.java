package com.example.project.ui.profile;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class ProfileViewModel extends AndroidViewModel {

    private ProfileRepository repository;
    private LiveData<List<Profile>> allProfiles;

    public ProfileViewModel(Application app) {
        super(app);
        repository = new ProfileRepository(app);
        allProfiles =repository.getAllProfiles();
    }

    public LiveData<List<Profile>> getAllProfiles() {
        return repository.getAllProfiles();
    }

    public void insert(Profile profile) {
        repository.insert(profile);
    }

    public void deleteAllProfiles() {
        repository.deleteAllProfiles();
    }


    public void navToMainPage() {

    }
}