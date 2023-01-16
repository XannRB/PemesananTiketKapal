package com.models;

public class Tiket {
    private String Tiket, Asal, Tujuan;
    private int Harga, Stok;

    public String getTiket() {
        return Tiket;
    }

    public void setTiket(String tiket) {
        Tiket = tiket;
    }

    public String getAsal() {
        return Asal;
    }

    public void setAsal(String asal) {
        Asal = asal;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public void setTujuan(String tujuan) {
        Tujuan = tujuan;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        Harga = harga;
    }

    public int getStok() {
        return Stok;
    }

    public void setStok(int stok) {
        Stok = stok;
    }

}
