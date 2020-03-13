package ders.yasin.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME="USER.DB";
    public final static String TABLE_NAME="USERS";
    public final static String COL_ID="ID";
    public final static String COL_USERNAME="USERNAME";
    public final static String COL_NAME="NAME";
    public final static String COL_MAIL="EMAIL";
    public final static String COL_PASSWORD="PASSWORD";
    SQLiteDatabase database;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY="CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY,USERNAME TEXT NOT NULL,NAME TEXT NOT NULL, EMAIL TEXT, PASSWORD TEXT NOT NULL)";
        db.execSQL(CREATE_TABLE_QUERY);
        this.database=db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String UPGRADE_QUERY="DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(UPGRADE_QUERY);
        this.onCreate(db);

    }

    public boolean insertUser(String userName, String name, String email, String password) {
        database=this.getWritableDatabase();
        String query=  "SELECT * FROM "+TABLE_NAME;
        Cursor cursor=database.rawQuery(query,null);
        int id= cursor.getCount();

        ContentValues value=new ContentValues();
        value.put(COL_ID,id+1);
        value.put(COL_NAME,name);
        value.put(COL_USERNAME,userName);
        value.put(COL_MAIL,email);
        value.put(COL_PASSWORD,password);

            Long result=database.insert(TABLE_NAME,null,value);
            database.close();
            if(result==-1)
                return false;
            else
                return true;

    }

    public String findUser(String userName) {
        database=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" WHERE USERNAME= '"+userName+"'";
        Cursor cursor=database.rawQuery(query,null);

        if(cursor.moveToFirst()) {
            database.close();
            return cursor.getString(4);
        }else{
            database.close();
            return "not found";
        }


    }

    public ArrayList<String> viewUsers() {
        database=this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        Cursor cursor=database.rawQuery(query,null);
        ArrayList<String> userNames=new ArrayList<String>();

        if(cursor.moveToFirst()){
            do{
                userNames.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }
        return  userNames;

    }
}
