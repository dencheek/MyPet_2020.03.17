package com.example.mypets;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimalDao {

    // нужно оборачивать все что получаешь из базы в LiveData для асинхронности
    @Query("SELECT * FROM animal")
    LiveData<List<Animal>> getAll();

    @Insert
    void insertAll(Animal... animals);
}
