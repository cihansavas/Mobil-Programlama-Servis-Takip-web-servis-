package com.example.cihan_sf2ak5t.mobilservis;

/**
 * Created by cihan_sf2ak5t on 27.12.2016.
 */

public class ServisAyar {
    private String id;
    private String baslik;
    private String aciklama;
    private String yorum;
    private String durum;

    public ServisAyar(String mid,String mbaslik,String maciklama,String myorum,String mdurum)
    {
        id=mid;
        baslik=mbaslik;
        aciklama=maciklama;
        yorum=myorum;
        durum=mdurum;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }





}
