package com.example.mypets;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Animal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnimalDao animalDao();

    // с инстансом этим паттерн называется Singleton, его раз запомнишь, потом везде будешь юзать
    private static AppDatabase INSTANCE;

    // вот эта инициализация базы в общем правильная, в этом приложении работать будет, но она не потокобезопасная,
    // если хочешь в качестве доп задания поразбирайся, че еще нужно добавить, но это пока тебе не обязательно
    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDatabase")
                    // здесь заполняем данными базу, когда первый раз ее создаем
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            // заполняем только с бэкграунда
                            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                                @Override
                                public void run() {
                                    // берем прям отсюда интстанс, и сразу его заполняем, дерзко
                                    getInstance(context).animalDao().insertAll(new Animal[]{
                                            new Animal("Пес", "Тузик"),
                                            new Animal("Кот", "Барсик"),
                                            new Animal("Черепаха", "Донателло")
                                    });
                                }
                            });
                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
