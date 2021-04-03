package com.bazlamatik.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bazlamatik.app.DatabaseHelper;
import com.bazlamatik.app.KisiDetay;
import com.bazlamatik.app.R;

public class KisiDetayActivity extends AppCompatActivity {

    Button yesil;
    Button kirmizi;
    Button kaydet;
    Button sil;
    EditText isim;
    EditText kisiSayisi;
    EditText telefon;
    EditText not;
    TextView kisiAdi;
    int id;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_detay);

        db=new DatabaseHelper(this);

        yesil=findViewById(R.id.btn_yesil);
        kirmizi=findViewById(R.id.btn_kirmizi);
        kaydet=findViewById(R.id.btn_kaydet);
        sil=findViewById(R.id.btn_sil);
        isim=findViewById(R.id.txt_isim);
        kisiSayisi=findViewById(R.id.txt_kisi_sayisi);
        telefon=findViewById(R.id.txt_telefon);
        not=findViewById(R.id.txt_not);
        kisiAdi =findViewById(R.id.lbl_kisi_adi);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getInt("id");
        }

        KisiDetay kisi=db.kisiDetayAl(id);
        isim.setText(kisi.getIsim());
        kisiSayisi.setText(kisi.getKisiSayisi());
        telefon.setText(kisi.getTelefon());
        not.setText(kisi.getNot());
        kisiAdi.setText(kisi.getIsim());



        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.kisiGuncelle(id,isim.getText().toString(),kisiSayisi.getText().toString(),telefon.getText().toString(),not.getText().toString());
                setResult(Activity.RESULT_OK);
                finish();
            }
        });

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.kisiSil(id);
                setResult(Activity.RESULT_OK);
                finish();
            }
        });



    }
}