package com.bazlamatik.app.ui;

public class Kisi {
    private String isim;
    private String kisiSayisi;
    private String timestamp;

    public Kisi(String isim,String kisiSayisi,  String timestamp) {
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

}
