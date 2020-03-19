package com.example.mypets;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Animal {
    @PrimaryKey                           private int    id;
    @ColumnInfo(name = "Animal") @NonNull private String Animal;
    @ColumnInfo(name = "Name")   @NonNull private String Name;

    public Animal (String Animal, String Name) {
        this.Animal = Animal;
        this.Name   = Name;
    }
    public int      getId()                     {return id;}
    public String   getAnimal()                 {return Animal;}
    public String   getName()                   {return Name;}
    public void     setAnimal(String Animal)    {this.Animal = Animal;}
    public void     setName  (String Name)      {this.Name   = Name;}

    public static Animal[] populateData() {
        return new Animal[] {
                 new Animal ("Кот",     "Василий")
                ,new Animal ("Собака",  "Барбос")
                ,new Animal ("Лиса",    "Алиса")
                ,new Animal ("Черепаха","Вениамин")
                ,new Animal ("Крокодил","Гена")
        };
    }
}
