package com.haci.EKG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

/**
 * Created by HaciOzdemir on 02/01/15.
 */
public class DBAdapter {
    public static final String DATABASE_TABLE="login";
    public static final String DATABASE_TABLE1="hastalikli";
    public static final String DATABASE_TABLE2="saglikli";
    public static final String USERNAME="username";
    public static final String PASSWORD="password";
    public static final String DOSYAADI="dosyaadi";
    public static final String DOSYAYOLU="dosyayolu";
    public static final String DOSYAADI1="dosyaadi";
    public static final String DOSYAYOLU1="dosyayolu";

    SQLiteDatabase loginDb;
    Context loginCtx;
    DBHelper loginHelper;

    public DBAdapter(Context context){
        this.loginCtx=context;
    }
    public DBAdapter open() throws SQLException{
        loginHelper=new DBHelper(loginCtx);
        loginDb=loginHelper.getWritableDatabase();
        return this;
    }
    public void close(){loginHelper.close();}
    public long register(String usr,String pwd){
        ContentValues initialValues =new ContentValues();
        initialValues.put(USERNAME,usr);
        initialValues.put(PASSWORD,pwd);

        return loginDb.insert(DATABASE_TABLE,null,initialValues);
    }
    public boolean giris(String username, String password) throws SQLException{
        Cursor mCursor = loginDb.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE username=? AND password=?", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }
}
