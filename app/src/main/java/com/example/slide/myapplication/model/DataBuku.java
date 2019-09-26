package com.example.slide.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class DataBuku {
    @SerializedName("nama_buku")
    String namaBuku;
    @SerializedName("no_panggil")
    String noPanggil;
    @SerializedName("pengarang_buku")
    String pengarang;
    @SerializedName("penerbit_buku")
    String penerbit;
    @SerializedName("deskripsi_buku")
    String deskripsi;
    @SerializedName("subjek_buku")
    String subjek;
    @SerializedName("konten_digital_buku")
    String kontenDigital;
    @SerializedName("eksemplar_buku")
    String eksemplar;


    public DataBuku(){

    }

    public DataBuku(String namaBuku, String noPanggil, String pengarang, String penerbit, String deskripsi, String subjek, String kontenDigital, String eksemplar) {
        this.namaBuku = namaBuku;
        this.noPanggil = noPanggil;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.subjek = subjek;
        this.kontenDigital = kontenDigital;
        this.eksemplar = eksemplar;
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
