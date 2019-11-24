package com.example.project.ui.profile;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Profile.class}, version = 3, exportSchema = false)
public abstract class ProfileDatabase extends RoomDatabase {

    private static ProfileDatabase instance;

    public abstract ProfileDAO profileDAO();

    public static synchronized ProfileDatabase getInstance(Context context){
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ProfileDatabase.class, "profile_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomcallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProfileDAO profileDAO;

        private PopulateDBAsyncTask(ProfileDatabase db){
            profileDAO = db.profileDAO();
        }
        @Override
        protected Void doInBackground(Void...voids) {
            profileDAO.insert(new Profile("Title 1",  "Description 1", 1));
            profileDAO.insert(new Profile("Title 2",  "Description 2", 2));
            profileDAO.insert(new Profile("Title 3",  "Description 3", 3));

            return null;
        }
    }
}
