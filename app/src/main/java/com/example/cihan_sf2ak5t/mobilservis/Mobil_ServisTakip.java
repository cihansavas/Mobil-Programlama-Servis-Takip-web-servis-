package com.example.cihan_sf2ak5t.mobilservis;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Mobil_ServisTakip extends AppCompatActivity {

    public String response;
    ListView liste_ekrani;
    public  String veriler;
    String veri=null;
    public List<ServisAyar> servistalepleri = new ArrayList<ServisAyar>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    CallSoap callSoap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobil__servis_takip);
        liste_ekrani = (ListView) findViewById(R.id.liste_ekrani);
        BaglantiAdaptor Baglanti = new BaglantiAdaptor(this, servistalepleri);
        liste_ekrani.setAdapter(Baglanti);

        //servistalepleri.add(new ServisAyar("3","ç","i","j","k"));
        //servistalepleri.add(new ServisAyar("4","ö","z","y","l"));


        //Toast.makeText(getApplicationContext(), "Veriler çekiliyor", Toast.LENGTH_LONG).show();


        try {
            String sveri=new AsyncCallSoap().execute().get();
            //Toast.makeText(getApplicationContext(), sveri, Toast.LENGTH_LONG).show();
            String[] stringArray = sveri.split("#");
            String ids,basliks,yorums,durums,aciklamas;
            int sayac=stringArray.length/5;
            //String yaz=
            //Toast.makeText(getApplicationContext(), String.valueOf(sayac), Toast.LENGTH_LONG).show();
            for(int i=0;i<sayac;i++)
            {
                ids=stringArray[(i*5)];
                basliks=stringArray[(i*5)+1];
                durums=stringArray[(i*5)+2];
                aciklamas=stringArray[(i*5)+3];
                yorums=stringArray[(i*5)+4];
                /*Toast.makeText(getApplicationContext(), durums, Toast.LENGTH_LONG).show();
                if(durums.equals("1"))
                {
                    Toast.makeText(getApplicationContext(), "Tamamlandı", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Beklemede", Toast.LENGTH_LONG).show();
                }*/
                servistalepleri.add(new ServisAyar(ids,basliks,aciklamas,yorums,durums));
                //Toast.makeText(getApplicationContext(), "id:"+ids+"\n baslik:"+basliks+"\n aciklama:"+aciklamas+"\n durum:"+durums+"\n yorum:"+yorums, Toast.LENGTH_LONG).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //Toast.makeText(getApplicationContext(), veriler, Toast.LENGTH_LONG).show();
        /*
        String[] stringArray = veriler.split("#");
        String ids,basliks,yorums,durums,aciklamas;
        int sayac=stringArray.length;

        for(int i=0;i<1;i++)
        {
            ids=stringArray[i];
            basliks=stringArray[i+1];
            durums=stringArray[i+2];
            aciklamas=stringArray[i+3];
            yorums=stringArray[i+4];
            servistalepleri.add(new ServisAyar(ids,basliks,aciklamas,durums,yorums));
        }
        */


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Mobil_ServisTakip Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    class AsyncCallSoap extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            CallSoap CS = new CallSoap();
            response = CS.StringVeri();
            return response;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }
    }
}
