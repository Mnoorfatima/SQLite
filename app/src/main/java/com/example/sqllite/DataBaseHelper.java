package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DataBaseName="Register.db";
    public DataBaseHelper( Context context ) {
        super(context, DataBaseName, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table User(Id integer primary key autoincrement, UserName text , password)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean Insert (String username, String password){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username", username );
        contentValues.put("password", password );
        long result= sqLiteDatabase.insert("user",null,contentValues);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public  boolean checkname(String username){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT* FROM USER WHERE username=?",new String[]{username});
        if (cursor.getCount()>0){
            return  false;
        }else {
            return  true;
        }
    }
    public  Boolean checklogin(String username, String password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT* FROM USER WHERE username=? AND password =?",new String[]{username,password});
        if (cursor.getCount()>0){
            return  true;
        }else {
            return  false;
        }
    }

}
