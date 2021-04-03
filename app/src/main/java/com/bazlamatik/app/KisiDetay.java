package com.bazlamatik.app;

public class KisiDetay {
    int id;
    String isim;
    String telefon;
    String kisiSayisi;
    String not;

    public KisiDetay(int id, String isim, String telefon, String kisiSayisi, String not) {
        this.id = id;
        this.isim = isim;
        this.telefon = telefon;
        this.kisiSayisi = kisiSayisi;
        this.not = not;
    }

    public KisiDetay(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(String kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }




}
