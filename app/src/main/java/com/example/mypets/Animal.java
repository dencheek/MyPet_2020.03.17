package com.example.mypets;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    @PrimaryKey private int id;
    @ColumnInfo(name = "Animal") private String Animal;
    @ColumnInfo(name = "Name") private String Name;
    public int getId() {return id;}
    public String getAnimal() {return Animal;}
    public void setAnimal(String Animal) {this.Animal = Animal;}
    public String getName() {return Name;}
    public void setName(String Name) {this.Name = Name;}
}
