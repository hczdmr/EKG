package com.haci.EKG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HaciOzdemir on 02/01/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="ekgDatabase";
    private static final String DATABASE_TABLE="login";
    private static final String DATABASE_TABLE1="hastalikli";
    private static final String DATABASE_TABLE2="saglikli";
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_CREATE="CREATE TABLE " + DATABASE_TABLE + "(id INTEGER PRIMARY KEY,username TEXT,password TEXT" + ")";
    private static final String DATABASE_CREATE1="CREATE TABLE " + DATABASE_TABLE1 + "(id INTEGER PRIMARY KEY,dosyaadi TEXT,dosyayolu TEXT" + ")";
    private static final String DATABASE_CREATE2="CREATE TABLE " + DATABASE_TABLE2 + "(id INTEGER PRIMARY KEY,dosyaadi TEXT,dosyayolu TEXT" + ")";
    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE1);
        db.execSQL(DATABASE_CREATE2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE1);
        db.execSQL("DROP TABLE IF EXISTS"+ DATABASE_TABLE2);
        onCreate(db);
    }
}
