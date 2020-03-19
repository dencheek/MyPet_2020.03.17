package com.example.mypets;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    @PrimaryKey private int id;
    @ColumnInfo(name = "Animal") private String Animal;
    @ColumnInfo(name = "Name") private String Name;
}
