package com.example.mypets;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Entity
public interface AnimalDao {
    @Query("select id, animal, name from Animal") List<Animal> getAll();
    @Query("select id, animal, name from Animal") List<Animal> loadById(int[] animalIds);
    @Query("select id, animal, name from Animal where Animal like :Animal") Animal findByAnimal(String Animal);
    @Insert
    void insertAll(Animal... animals);
    @Update
    void update(Animal animal);
    @Delete
    void delete(Animal animal);
}
