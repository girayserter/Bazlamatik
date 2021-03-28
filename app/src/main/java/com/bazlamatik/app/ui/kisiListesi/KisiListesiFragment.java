package com.bazlamatik.app.ui.kisiListesi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kisi_listesi, container, false);

        listView = root.findViewById(R.id.lw_kisi_listesi);
        kisiEkleButon=root.findViewById(R.id.btn_kisi_ekle);

        kisiler.add(new Kisi("giray","4","sadfs"));
        ArrayAdapter<Kisi> saveAdapter = new KisiListesiAdapter(getActivity(),kisiler);
        listView.setAdapter(saveAdapter);
        saveAdapter.notifyDataSetChanged();

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
                String isim=data.getStringExtra("isim");
                String kisiSayisi=data.getStringExtra("kisi_sayisi");
                String telefon=data.getStringExtra("telefon");
                String not=data.getStringExtra("not");
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss");
                String format = s.format(new Date());
                kisiler.add(new Kisi(isim,kisiSayisi,format));
                ArrayAdapter<Kisi> saveAdapter = new KisiListesiAdapter(getActivity(),kisiler);
                listView.setAdapter(saveAdapter);
                saveAdapter.notifyDataSetChanged();
                System.out.println("sdafsafdasdf");
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }

    }//onActivityResult




}