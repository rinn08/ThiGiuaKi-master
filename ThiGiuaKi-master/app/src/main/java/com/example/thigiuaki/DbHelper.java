package com.example.thigiuaki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QuanLySanPham", null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Áo thun', 100, 'image1.jpg'), " +
                "(2, 'Quần jean', 200, 'image2.jpg'), " +
                "(3, 'Giày sneaker', 150, 'image3.jpg'), " +
                "(4, 'Túi xách', 180, 'image4.jpg'), " +
                "(5, 'Đồng hồ', 300, 'image5.jpg')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}