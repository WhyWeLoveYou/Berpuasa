package com.mecintaidiri.berpuasa;

import javax.xml.transform.sax.SAXResult;

public class Item {

    String judul;
    String gambar;

    String link;

    public Item() {

    }

    public Item(String judul, String gambar, String link) {
        this.judul = judul;
        this.gambar = gambar;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

