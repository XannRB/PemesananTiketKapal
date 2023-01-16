package com.controllers;

import java.util.List;

import com.Utility;
import com.models.Transaksi;

public class HasilTransaksiController {
    private List<Transaksi> listTransaksi;

    public HasilTransaksiController(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
        showHasil();
    }

    void showHasil() {
        System.out.println(
                "=====================================================================================================================================");
        System.out.println(
                "| NO |       TIKET       |       JUMLAH       |       HARGA       |       TOTAL       |        ASAL       |         TUJUAN          |");
        System.out.println(
                "=====================================================================================================================================");
        int i = 1;
        for (Transaksi transaksi : listTransaksi) {
            System.out.printf("|%-4s|%-16s|%-12s|%-17s|%-9s|%-19s|%-20s| %n",
                    i++,
                    transaksi.getTiket(),
                    transaksi.getQty(),
                    Utility.toRupiah(transaksi.getHarga()),
                    Utility.toRupiah(transaksi.getQty() * transaksi.getHarga()),
                    transaksi.getAsal(),
                    transaksi.getTujuan());
        }
    }
}
