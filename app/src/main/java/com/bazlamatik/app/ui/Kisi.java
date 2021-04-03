package com.bazlamatik.app.ui;

public class Kisi {

    private int id;
    private String isim;
    private String kisiSayisi;
    private String timestamp;

    public Kisi(int id,String isim,String kisiSayisi,  String timestamp) {
        this.id=id;
        this.isim = isim;
        this.kisiSayisi = kisiSayisi;
        this.timestamp = timestamp;

    }

    public String getIsim() {
        return isim;
    }

    public String getKisiSayisi() {
        return kisiSayisi;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public int getId() {
        return id;
    }
}
