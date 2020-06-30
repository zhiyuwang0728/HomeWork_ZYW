package com.zyw.second.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.db.DaoMaster;
import com.example.greendaodemo.db.DaoSession;

public class MyApp extends Application {

    private static MyApp myApp;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        setDatabase();
    }

    private void setDatabase() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "student.db", null);

        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        writableDatabase.disableWriteAheadLogging();

        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession = daoMaster.newSession();

    }

    public static MyApp getInstance() {
        return myApp;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
