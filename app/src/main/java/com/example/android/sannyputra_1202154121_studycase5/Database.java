package com.example.android.sannyputra_1202154121_studycase5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    //deklarasi variable yang akan digunakan
    Context cntx;
    SQLiteDatabase db;

    public static final String nama_datab = "listtodo.db";
    public static final String nama_tbl = "daftartodo";
    public static final String kolom_satu = "todo";
    public static final String kolom_dua = "description";
    public static final String kolom_tiga = "priority";

    //kontruktor
    public Database(Context context) {
        super(context, nama_datab, null, 1);
        this.cntx = context;
        db = this.getWritableDatabase();
        db.execSQL("create table if not exists "+nama_tbl+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }

    //ketika database dibuat
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists "+nama_tbl+" (todo varchar(35) primary key, description varchar(50), priority varchar(3))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+nama_tbl);
        onCreate(sqLiteDatabase);
    }

    public boolean inputdata(AddDataActivity list) {
        //mencocokkan kolom beserta nilainya
        ContentValues val = new ContentValues();
        val.put(kolom_satu, list.getTodo());
        val.put(kolom_dua, list.getDesc());
        val.put(kolom_tiga, list.getPrior());
        long hasil = db.insert(nama_tbl, null, val);
        if (hasil==-1) {
            return false;
        }else {
            return true;
        }
    }

    //method untuk menghapus data pada database
    public boolean removedata(String ToDo) {
        return db.delete(nama_tbl, kolom_satu+"=\""+ToDo+"\"", null)>0;
    }

    //method untuk mengakses dan membaca data dari database
    public void readdata(ArrayList<AddDataActivity> daftar){
        Cursor cursor = this.getReadableDatabase().rawQuery("select todo, description, priority from "+nama_tbl, null);
        while (cursor.moveToNext()){
            daftar.add(new AddDataActivity(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
        }
    }
}

