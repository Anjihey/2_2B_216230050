package com.example.anjihey;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        db.execSQL("CREATE TABLE FAVOTHING (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, color TEXT, food TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name, int age, String color, String food) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO FAVOTHING VALUES(null, '" + name + "', " + age + ", '" + color + "', '" + food + "');");
        db.close();
    }

    public void update(String name, String color) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE FAVOTHING SET color=" + color + " WHERE name='" + name + "';");
        db.close();
    }

    public void delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM FAVOTHING WHERE name='" + name + "';");
        db.close();
    }

    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM FAVOTHING", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(1)
                    + " / "
                    + cursor.getInt(2)
                    + "살 / "
                    + cursor.getString(3)
                    + " / "
                    + cursor.getString(4)
                    + "\n";
        }

        return result;
    }
}


