package com.mecintaidiri.berpuasa;

import javax.xml.transform.sax.SAXResult;

public class Item {

    String judul;
    String gambar;

    public Item() {

    }

    public Item(String judul, String deskripsi, String gambar) {
        this.judul = judul;
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}

