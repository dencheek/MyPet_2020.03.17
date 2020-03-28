package com.example.mypets;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "animal")
public class Animal {
    @PrimaryKey(autoGenerate = true)
    int id;

    public String animal;

    public String name;

    public Animal(String animal, String name) {
        this.animal = animal;
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public String getName() {
        return name;
    }
}
