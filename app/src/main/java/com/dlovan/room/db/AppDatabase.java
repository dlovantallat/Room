package com.dlovan.room.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * AppDatabase
 * Created by dlovan on 3/20/18.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    AppDatabase.class, "users")
                    .allowMainThreadQueries() // this is bad thing just for test in real app make it in the background
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
}
