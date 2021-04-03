package com.bazlamatik.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="Bazlamatik.db";//Veritabanı Adı
    private static final String KISILER_TABLE="Kisiler_Table";//Tablo Adı


    //Sütunlar
    private static final String ID="ID";
    private static final String Kisi_Adi="kisi_adi";
    private static final String Kisi_Sayisi="kisi_sayisi";
    private static final String Timestamp="timestamp";
    private static final String Telefon="telefon";
    private static final String Note="note";


    //Create table query si
    private static final String CREATE_TABLE1="CREATE TABLE "+ KISILER_TABLE+" ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            Kisi_Adi+ " TEXT, "+
            Kisi_Sayisi+ " TEXT, "+
            Timestamp+ " TEXT, "+
            Telefon+ " TEXT, "+
            Note+ " TEXT "+
            ")";


    //Constructor
    public DatabaseHelper(Context context)
    {
        super(context,DB_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE1);//Çalıştırıldığında tablo oluştur komutu

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ KISILER_TABLE);//Değişiklik durumunda tabloyu yeniden oluştur komutu
        onCreate(db);
    }


    //kisi girişi
    public boolean insertKisi(String isim, String kisi_sayisi, String timestamp, String telefon, String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues2=new ContentValues();
        contentValues2.put(Kisi_Adi,isim);
        contentValues2.put(Kisi_Sayisi,kisi_sayisi);
        contentValues2.put(Timestamp,timestamp);
        contentValues2.put(Telefon,telefon);
        contentValues2.put(Note,note);
        long result = db.insert(KISILER_TABLE,null,contentValues2);

        return result !=-1;
    }


    public Cursor kisilerOku(){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+KISILER_TABLE;
        Cursor cursor=db.rawQuery(query,null);

        return cursor;
    }


    //kisi silme
    public Integer kisiSil(int id){
        SQLiteDatabase db= this.getWritableDatabase();
        int result;
        result= db.delete(KISILER_TABLE,ID+"=" + id +" ;", null);
        return result;
    }


    public void tumKisileriSil(String plaka){
        SQLiteDatabase db= this.getWritableDatabase();
        String query="Delete FROM " + KISILER_TABLE ;
        db.execSQL(query);
    }


    public void kisiGuncelle(int id,String kisi_Adi,String kisi_Sayisi, String telefon, String note){
        SQLiteDatabase db= this.getWritableDatabase();
        String query = "UPDATE "+KISILER_TABLE+" SET "+Kisi_Adi+" = '"+kisi_Adi+ "',"+Kisi_Sayisi+" = '"+kisi_Sayisi+ "',"+Telefon+" = '"+telefon+ "',"+Note+" = '"+note+ "'  WHERE "+ID+" = "+ id;
        db.execSQL(query);
    }

    public KisiDetay kisiDetayAl(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + KISILER_TABLE + " WHERE " + ID + "=" + id,null);
        cursor.moveToFirst();

        //setting related user info in User Object
        KisiDetay kisi = new KisiDetay();
        kisi.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        kisi.setIsim(cursor.getString(cursor.getColumnIndex(Kisi_Adi)));
        kisi.setKisiSayisi(cursor.getString(cursor.getColumnIndex(Kisi_Sayisi)));
        kisi.setTelefon(cursor.getString(cursor.getColumnIndex(Telefon)));
        kisi.setNot(cursor.getString(cursor.getColumnIndex(Note)));

        //close cursor & database
        cursor.close();

        return kisi;

    }

}