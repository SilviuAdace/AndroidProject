package com.example.project.ui.profile;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;
import androidx.lifecycle.LiveData;

public class ProfileRepository {

    private ProfileDAO profileDAO;
    private static ProfileRepository instance;
    private LiveData<List<Profile>> allProfiles;

    public ProfileRepository(Application application){
        ProfileDatabase database = ProfileDatabase.getInstance(application);
        profileDAO = database.profileDAO();
        allProfiles = profileDAO.getAllProfiles();
    }

    public static synchronized ProfileRepository getInstance(Application application){
        if(instance == null)
            instance = new ProfileRepository(application);

        return instance;
    }

    public LiveData<List<Profile>> getAllProfiles(){
        return allProfiles;
    }

    public void insert(Profile profile) {
        new InsertNoteAsync(profileDAO).execute(profile);
    }

    public void deleteAllProfiles(){
        new DeleteAllNotesAsync(profileDAO).execute();
    }


    private static class InsertNoteAsync extends AsyncTask<Profile, Void, Void> {
        private ProfileDAO profileDAO;

        private InsertNoteAsync(ProfileDAO profileDao) {
            this.profileDAO = profileDAO;
        }

        @Override
        protected Void doInBackground(Profile... profiles) {
            profileDAO.insert(profiles[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsync extends AsyncTask<Void,Void,Void> {
        private ProfileDAO profileDAO;

        private DeleteAllNotesAsync(ProfileDAO profileDAO) {
            this.profileDAO = profileDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            profileDAO.deleteAllProfiles();
            return null;
        }
    }
}
