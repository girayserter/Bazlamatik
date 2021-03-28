package com.bazlamatik.app.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bazlamatik.app.R;

import java.util.ArrayList;

public class KisiListesiAdapter extends ArrayAdapter<Kisi> {

    private LayoutInflater inflater;
    private Context context;
    private ViewHolder holder;
    private ArrayList<Kisi> persons;

    public KisiListesiAdapter(Context context, ArrayList<Kisi> persons) {
        super(context, 0, persons);
        this.context = context;
        this.persons = persons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Kisi getItem(int position) {
        return persons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return persons.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.kisiIsim = (TextView) convertView.findViewById(R.id.kisi_isim);
            holder.kisiSayisi = (TextView) convertView.findViewById(R.id.kisi_sayisi);
            holder.kisiSure = (TextView) convertView.findViewById(R.id.kisi_sure);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        Kisi person = persons.get(position);
        if(person != null){
            holder.kisiIsim.setText(person.getIsim());
            holder.kisiSayisi.setText(person.getKisiSayisi());
            holder.kisiSure.setText(person.getTimestamp());

        }
        return convertView;
    }

    //View Holder Pattern for better performance
    private static class ViewHolder {
        TextView kisiSayisi;
        TextView kisiSure;
        TextView kisiIsim;

    }
}