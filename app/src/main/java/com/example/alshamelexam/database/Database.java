package com.example.alshamelexam.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
Context context;

    public Database( Context context) {
        super(context,"database",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table cars (id integer primary key autoincrement ,name text ,model integer,color text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists cars ");
        onCreate(sqLiteDatabase);

    }
    public boolean insertCar(Car car){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", car.getName());
        values.put("model", car.getModel());
        values.put("color", car.getColor());
       long result= database.insert("cars",null,values);
        return result!=-1;
    }
    public boolean updateCar(Car car){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", car.getName());
        values.put("model", car.getModel());
        values.put("color", car.getColor());
        String  [] args={(car.getId())+""};
        long result= database.update("cars",values,"id=?",args);
        return result>0;
    }
    public boolean deleteCar(Car car){
        SQLiteDatabase database=getWritableDatabase();
        String  [] args={(car.getId())+""};
        long result= database.delete("cars","id=?",args);
        return result>0;
    }
    public ArrayList<Car> getCars(){
        ArrayList<Car> cars=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
      Cursor cursor= database.rawQuery("select * from cars", null);
      if (cursor!=null&&cursor.moveToFirst()){
          do {
              String name =cursor.getString(cursor.getColumnIndex("name"));
              String color =cursor.getString(cursor.getColumnIndex("color"));
              int model =cursor.getInt(cursor.getColumnIndex("model"));
              Car car=new Car(name,model,color);
              cars.add(car);
          }while (cursor.moveToNext());
          cursor.close();
      }
      return cars;
    }


}
