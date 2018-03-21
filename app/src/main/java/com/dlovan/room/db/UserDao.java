package com.dlovan.room.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * UserDao
 * Created by dlovan on 3/20/18.
 */

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getListUser();

    @Insert
    void insertAll(User... users);
}
