package com.example.cihan_sf2ak5t.mobilservis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ServisTalebi extends AppCompatActivity {

    public String id;
    public String yorum;
    public String durum;
    public String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servis_talebi);
        Button anasayfayagonder=(Button) findViewById(R.id.anasayfayagit);
        TextView idtext=(TextView) findViewById(R.id.id_textView);
        EditText basliktext=(EditText) findViewById(R.id.baslik_editText);
        EditText aciklamatext=(EditText) findViewById(R.id.aciklamaeditText2);
        final EditText yorumtext=(EditText) findViewById(R.id.yorum_editText);
        final RadioButton beklemede=(RadioButton) findViewById(R.id.beklemede);
        final RadioButton tamamlandi=(RadioButton) findViewById(R.id.tamamlandi);
        Button button=(Button) findViewById(R.id.button);


        final Bundle extras = getIntent().getExtras();
        idtext.setText(extras.getString("id"));
        basliktext.setText(extras.getString("baslik"));
        aciklamatext.setText(extras.getString("aciklama"));
        yorumtext.setText(extras.getString("yorum"));
        String durumcuk=extras.getString("durum");
        if(durumcuk.equals("0"))
        {
            beklemede.setChecked(true);
        }
        else
        {
            tamamlandi.setChecked(true);
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(tamamlandi.isChecked())
                {
                    durum="1";
                }
                else if(beklemede.isChecked())
                {
                    durum="0";
                }
                id=extras.getString("id");
                yorum=yorumtext.getText().toString();

                new GuncellemeYap().execute();
            }
        });

        anasayfayagonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),Mobil_ServisTakip.class);
                startActivity(intent2);
            }
        });
    }

    public class GuncellemeYap extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            CallSoap CS = new CallSoap();
            String response = CS.Guncelle(id,durum,yorum);
            return response;
        }

        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            /*if(result=="ok")
            {
                Toast.makeText(getApplicationContext(),"Güncelleme başarıyla yapılmıştır", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Bir hata meydana geldi", Toast.LENGTH_LONG).show();
            }*/

            Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
        }
    }
}
