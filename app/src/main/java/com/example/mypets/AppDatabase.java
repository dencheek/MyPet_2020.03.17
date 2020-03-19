package com.example.mypets;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimalDao animalDao();
}
