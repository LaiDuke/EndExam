package com.fpt.aptech.t1902e.laivanduc.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fpt.aptech.t1902e.laivanduc.dao.FeedBackDAO;
import com.fpt.aptech.t1902e.laivanduc.model.FeedBackEntity;

@Database(entities = {FeedBackEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    public abstract FeedBackDAO feedBackDAO();

    public static AppDatabase getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    AppDatabase.class, "DBNAME")
                    .allowMainThreadQueries().build();
        }
        return appDatabase;
    }

}