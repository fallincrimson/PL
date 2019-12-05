package com.example.slide.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class BookData {
    @SerializedName("nama_buku")
    private String namaBuku;
    @SerializedName("no_panggil")
    private String noPanggil;
    @SerializedName("pengarang_buku")
    private String pengarang;
    @SerializedName("penerbit_buku")
    private String penerbit;
    @SerializedName("deskripsi_buku")
    private String deskripsi;
    @SerializedName("subjek_buku")
    private String subjek;
    @SerializedName("konten_digital_buku")
    private String kontenDigital;
    @SerializedName("eksemplar_buku")
    private String eksemplar;
    @SerializedName("key")
    private String key;


    public BookData() {

    }

    public BookData(String namaBuku, String noPanggil, String pengarang, String penerbit, String deskripsi, String subjek, String kontenDigital, String eksemplar, String key) {
        this.namaBuku = namaBuku;
        this.noPanggil = noPanggil;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.subjek = subjek;
        this.kontenDigital = kontenDigital;
        this.eksemplar = eksemplar;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNoPanggil() {
        return noPanggil;
    }

    public void setNoPanggil(String noPanggil) {
        this.noPanggil = noPanggil;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }

    public String getKontenDigital() {
        return kontenDigital;
    }

    public void setKontenDigital(String kontenDigital) {
        this.kontenDigital = kontenDigital;
    }

    public String getEksemplar() {
        return eksemplar;
    }

    public void setEksemplar(String eksemplar) {
        this.eksemplar = eksemplar;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }
}
