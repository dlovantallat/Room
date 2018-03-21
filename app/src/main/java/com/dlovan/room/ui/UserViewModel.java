package com.dlovan.room.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.dlovan.room.db.AppDatabase;
import com.dlovan.room.db.User;

import java.util.List;

/**
 * UserViewModel
 * Created by dlovan on 3/21/18.
 */

public class UserViewModel extends AndroidViewModel {

    private AppDatabase database;

    public UserViewModel(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(this.getApplication());
    }

    LiveData<List<User>> getList() {
        return database.userDao().getListUser();
    }

    void insertUser(User user) {
        new InsertUserAsync(database).execute(user);
    }

    private static class InsertUserAsync extends AsyncTask<User, Void, Void> {

        private AppDatabase database;

        InsertUserAsync(AppDatabase database) {
            this.database = database;
        }

        @Override
        protected Void doInBackground(User... users) {
            database.userDao().insertAll(users[0]);
            return null;
        }
    }
}
