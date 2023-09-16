package com.example.alshamelexam.databaseUser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    Context context;

    public database(Context context) {
        super(context,"user",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user (id integer primary key autoincrement ,name text ,password text,email email)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user ");
        onCreate(sqLiteDatabase);
    }
    public boolean insertUser(User user){
        SQLiteDatabase database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        long result= database.insert("user",null,values);
        return result!=-1;
    }
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users=new ArrayList<>();
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor= database.rawQuery("select * from user", null);
        if (cursor!=null&&cursor.moveToFirst()){
            do {
                String name =cursor.getString(cursor.getColumnIndex("name"));
                String password =cursor.getString(cursor.getColumnIndex("password"));
                String email =cursor.getString(cursor.getColumnIndex("email"));
                User user=new User(name,password,email);
                users.add(user);
            }while (cursor.moveToNext());
            cursor.close();
        }
        return users;
    }
    public boolean isCredentialsValid(String email, String password) {
        // قد يكون هذا تنفيذ بسيط، يمكنك تخصيصه وفقًا لهيكل قاعدة البيانات الخاص بك.

        // استعلام SQL لفحص اسم المستخدم وكلمة المرور.
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        String[] selectionArgs = {email, password};

        SQLiteDatabase db = getReadableDatabase();

        // يتم تنفيذ الاستعلام والتحقق من وجود السجل.
        Cursor cursor = db.rawQuery(query, selectionArgs);
        boolean isValid = cursor.getCount() > 0;

        // إغلاق الاتصال بقاعدة البيانات والمؤشر.
        cursor.close();
        db.close();

        return isValid;
    }
}
