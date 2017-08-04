package com.example.cihan_sf2ak5t.mobilservis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by cihan_sf2ak5t on 27.12.2016.
 */

public class BaglantiAdaptor extends BaseAdapter {
    LayoutInflater layoutInflater;
    List<ServisAyar> servisAyarList;
    Activity activity;
    public BaglantiAdaptor(Activity activity, List<ServisAyar> mServisAyarList){
        layoutInflater=(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        servisAyarList=mServisAyarList;
        this.activity=activity;
    }


    @Override
    public int getCount() {
        return servisAyarList.size();
    }

    @Override
    public Object getItem(int position) {
        return servisAyarList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
View satirView;
        satirView=layoutInflater.inflate(R.layout.satir,null);
        final TextView idBaglanti=(TextView) satirView.findViewById(R.id.id_textviev);
        final TextView baslikBaglanti=(TextView) satirView.findViewById(R.id.baslik_textviev);
        final TextView aciklamaBaglanti=(TextView) satirView.findViewById(R.id.aciklama_textviev);
        final TextView durumBaglanti=(TextView) satirView.findViewById(R.id.durum_textviev);
        final TextView yorumBaglanti=(TextView) satirView.findViewById(R.id.yorum_textviev);
        final Button button1=(Button) satirView.findViewById(R.id.baslat);


final ServisAyar talep=servisAyarList.get(position);

        idBaglanti.setText(talep.getId().toString());
        baslikBaglanti.setText(talep.getBaslik().toString());
        aciklamaBaglanti.setText(talep.getAciklama().toString());
        if(talep.getDurum().toString().equals("1"))
        {
            durumBaglanti.setText("Tamamlandı");
        }
        else
        {
            durumBaglanti.setText("Beklemede");
        }
        //durumBaglanti.setText(talep.getDurum().toString());
        yorumBaglanti.setText(talep.getYorum().toString());

button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Toast.makeText(activity,talep.getId().toString()+"  "+talep.getBaslik().toString()+"  "+talep.getAciklama().toString()+"  "+talep.getYorum().toString()+"  "+talep.getDurum().toString(),Toast.LENGTH_SHORT).show();
//button1.setText("Degisti");
        Intent intent=new Intent(activity.getApplicationContext(),ServisTalebi.class);
        intent.putExtra("id",talep.getId().toString());
        intent.putExtra("baslik",talep.getBaslik().toString());
        intent.putExtra("aciklama",talep.getAciklama().toString());
        intent.putExtra("durum",talep.getDurum().toString());
        intent.putExtra("yorum",talep.getYorum().toString());

        activity.startActivity(intent);


    }
});

        return satirView;
    }
}
