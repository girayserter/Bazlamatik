package com.bazlamatik.app.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bazlamatik.app.DatabaseHelper;
import com.bazlamatik.app.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KisiEkleActivity extends AppCompatActivity {

    Button kaydet;
    Button iptal;
    EditText isim;
    EditText kisiSayisi;
    EditText telefon;
    EditText not;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_ekle);

        db=new DatabaseHelper(this);

        kaydet=findViewById(R.id.btn_kaydet);
        iptal=findViewById(R.id.btn_iptal);
        isim=findViewById(R.id.txt_isim);
        kisiSayisi=findViewById(R.id.txt_kisi_sayisi);
        telefon=findViewById(R.id.txt_telefon);
        not=findViewById(R.id.txt_not);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isim.getText().toString().isEmpty()){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(KisiEkleActivity.this);
                    dlgAlert.setMessage("İsim kısmı boş olamaz!");
                    dlgAlert.setTitle("Hata");
                    dlgAlert.setPositiveButton("Tamam", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
                else if(kisiSayisi.getText().toString().isEmpty()){
                    AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(KisiEkleActivity.this);
                    dlgAlert.setMessage("Kişi sayısı kısmı boş olamaz!");
                    dlgAlert.setTitle("Hata");
                    dlgAlert.setPositiveButton("Tamam", null);
                    dlgAlert.setCancelable(true);
                    dlgAlert.create().show();
                }
                else {
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("isim",isim.getText().toString());
                    returnIntent.putExtra("kisi_sayisi",kisiSayisi.getText().toString());
                    returnIntent.putExtra("telefon",telefon.getText().toString());
                    returnIntent.putExtra("not",not.getText().toString());
                    setResult(Activity.RESULT_OK,returnIntent);
                    SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                    String timestamp = s.format(new Date());
                    if(db.insertKisi(isim.getText().toString(),kisiSayisi.getText().toString(),timestamp,telefon.getText().toString(),not.getText().toString()))
                    {
                        Toast.makeText(KisiEkleActivity.this,"Kişi Eklendi",Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            }
        });

        iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });
    }
}