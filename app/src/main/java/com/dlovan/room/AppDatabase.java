package com.dlovan.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * AppDatabase
 * Created by dlovan on 3/20/18.
 */

@Database(entities = {User.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    abstract UserDao userDao();
}
