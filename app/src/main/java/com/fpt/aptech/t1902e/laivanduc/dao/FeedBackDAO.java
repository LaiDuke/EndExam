package com.fpt.aptech.t1902e.laivanduc.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.fpt.aptech.t1902e.laivanduc.model.FeedBackEntity;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface FeedBackDAO {

    @Insert(onConflict = REPLACE)
    void insert(FeedBackEntity feedBackEntity);


    @Query("SELECT COUNT(*) FROM feedback")
    int getAllCount();

}
