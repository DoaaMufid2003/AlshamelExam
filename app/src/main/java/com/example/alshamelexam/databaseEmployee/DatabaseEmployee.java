package com.example.alshamelexam.databaseEmployee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.alshamelexam.database.Car;

import java.util.ArrayList;

public class DatabaseEmployee extends SQLiteOpenHelper {
    Context context;

    public DatabaseEmployee( Context context) {
        super(context,"databaseEmployee",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table employee (id integer primary key autoincrement ,name text ,salary integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists employee ");
        onCreate(sqLiteDatabase);
    }
    public boolean insertEmployee(Employee employee){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", employee.getName());
        values.put("salary", employee.getSalary());
        long result= database.insert("employee",null,values);
        return result!=-1;
    }
    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> employees=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor= database.rawQuery("select * from employee", null);
        if (cursor!=null&&cursor.moveToFirst()){
            do {
                String name =cursor.getString(cursor.getColumnIndex("name"));
                int salary =cursor.getInt(cursor.getColumnIndex("salary"));
                Employee employee=new Employee(name,salary);
                employees.add(employee);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return employees;
    }
}
