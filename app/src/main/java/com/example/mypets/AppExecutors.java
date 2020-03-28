package com.example.mypets;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static AppExecutors INSTANCE;

    private final Executor diskIO;

    public static AppExecutors getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AppExecutors();
        }
        return INSTANCE;
    }

    // тот же паттерн, что и в базе - Singleton, обрати внимание приватный конструктор
    private AppExecutors() {
        diskIO = Executors.newSingleThreadExecutor();
    }

    public Executor diskIO() {
        return diskIO;
    }
}
