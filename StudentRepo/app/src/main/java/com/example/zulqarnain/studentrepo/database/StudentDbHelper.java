package com.example.zulqarnain.studentrepo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.zulqarnain.studentrepo.model.Student;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class StudentDbHelper extends SQLiteOpenHelper
{

    private static final String DB_NAME="stdrepo.db";
    private static final String TABLE_NAME="std_table";
    private static final String STD_ID="std_id";
    private static final String STD_NAME="std_name";
    private static final String STD_PHONE="std_phone";
    private static final String STD_EMAIL="std_email";
    private static final String STD_IMAGE="std_img";

    private static  final int DB_VERSION=1;
    private static  final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+
                                    STD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+
                                    STD_NAME+" VARCHAR(100) ,"+
                                    STD_PHONE+" VARCHAR(100) ,"+
                                    STD_EMAIL+" VARCHAR(100) ,"+
                                    STD_IMAGE+" TEXT "+
                                    ") ";

    private SQLiteDatabase db;
    private Context context;
    public StudentDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Log.d("TAG", "onCreate: DB Created");

        }
        catch (Exception e){
            Log.d("TAG", "onCreate: Exception");
        }
    }
    public long insetData(String name,String phone,String email,String path) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(STD_NAME, name);
        content.put(STD_EMAIL, phone);
        content.put(STD_PHONE, email);
        content.put(STD_IMAGE, path);
        return db.insert(TABLE_NAME, null, content);

    }

    public ArrayList<Student> getStudentData(){
        ArrayList<Student> sList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME,null);
        while (cursor.moveToNext()){

            int st_id=cursor.getInt(0);
            String st_name=cursor.getString(1);
            String st_ph=cursor.getString(2);
            String st_email=cursor.getString(3);
            String st_img=cursor.getString(4);
            Student std =new Student(st_id,st_name,st_ph,st_email,st_img);
            sList.add(std);
        }
        return sList;
    }
    public ArrayList<Student> getStudent(String name){
        ArrayList<Student> sList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME+" where "+STD_NAME+" = "+name,null);
        while (cursor.moveToNext()){

            int st_id=cursor.getInt(0);
            String st_name=cursor.getString(1);
            String st_ph=cursor.getString(2);
            String st_email=cursor.getString(2);
            String st_img=cursor.getString(4);
            Student std =new Student(st_id,st_name,st_ph,st_email,st_img);
            sList.add(std);
        }
        return sList;
    }

    public void delStuent(int id){
        SQLiteDatabase db= getWritableDatabase();
        db.delete(TABLE_NAME,STD_ID+" = ?",new String[]{String.valueOf(id)});
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
