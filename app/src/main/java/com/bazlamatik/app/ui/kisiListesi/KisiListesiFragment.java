package com.bazlamatik.app.ui.kisiListesi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bazlamatik.app.DatabaseHelper;
import com.bazlamatik.app.R;
import com.bazlamatik.app.ui.Kisi;
import com.bazlamatik.app.ui.KisiEkleActivity;
import com.bazlamatik.app.ui.KisiListesiAdapter;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KisiListesiFragment extends Fragment {

    private KisiListesiViewModel kisiListesiViewModel;
    private ArrayList<Kisi> kisiler=new ArrayList<Kisi>();
    private ListView listView;
    private KisiListesiAdapter listViewAdapter;
    private Button kisiEkleButon;
    private DatabaseHelper db;
    private ArrayAdapter<Kisi> saveAdapter;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kisi_listesi, container, false);
        db=new DatabaseHelper(getActivity());


        listView = root.findViewById(R.id.lw_kisi_listesi);
        kisiEkleButon=root.findViewById(R.id.btn_kisi_ekle);

        kisiler.clear();
        viewData();

        /*kisiler.add(new Kisi("giray","4","sadfs"));
        ArrayAdapter<Kisi> saveAdapter = new KisiListesiAdapter(getActivity(),kisiler);
        listView.setAdapter(saveAdapter);
        saveAdapter.notifyDataSetChanged();*/

        kisiEkleButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int LAUNCH_SECOND_ACTIVITY = 1;
                Intent i = new Intent(getActivity(), KisiEkleActivity.class);
                startActivityForResult(i, LAUNCH_SECOND_ACTIVITY);

            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                kisiler.clear();
                viewData();
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }

    }//onActivityResult

    private void viewData() {
        Cursor cursor =db.kisilerOku();//Veritabanından verileri sırayla alacak cursor

        //Veri var mı kontrol
        if(cursor.getCount()==0){
            Toast.makeText(getActivity(),"Gösterilecek kişi yok",Toast.LENGTH_SHORT).show();
        }
        //veri varsa Array list e ekleme
        else{
            while (cursor.moveToNext()){
                kisiler.add(new Kisi(cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }
            //Arraylist i listview e uyarlayan adapter

            saveAdapter = new KisiListesiAdapter(getActivity(),kisiler);
            listView.setAdapter(saveAdapter);
            saveAdapter.notifyDataSetChanged();
        }
    }




}