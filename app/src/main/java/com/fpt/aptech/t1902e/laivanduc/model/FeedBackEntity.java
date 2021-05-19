package com.fpt.aptech.t1902e.laivanduc.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "FEEDBACK")
public class FeedBackEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "NAMEE")
    public String name;

    @ColumnInfo(name = "EMAIL")
    public String email;

    @ColumnInfo(name = "FEEL")
    public String feel;

    @ColumnInfo(name = "CHECK")
    public int check;

    @ColumnInfo(name = "DETAIL")
    public String detail;


    public FeedBackEntity(String name, String email, String feel, int check, String detail) {
        this.name = name;
        this.email = email;
        this.feel = feel;
        this.check = check;
        this.detail = detail;
    }
}
