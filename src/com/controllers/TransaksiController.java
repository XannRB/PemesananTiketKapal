package com.controllers;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Tiket;
import com.models.Transaksi;

public class TransaksiController {
    private List<Transaksi> listTransaksi;
    private List<Tiket> listTiket;
    Scanner scan = new Scanner(System.in);

    public TransaksiController(List<Transaksi> listTransaksi, List<Tiket> listTiket) {
        this.listTransaksi = listTransaksi;
        this.listTiket = listTiket;
        shohwTiket();
        store();
    }

    void shohwTiket() {
        System.out.println(
                "===============================================================================================================");
        System.out.println(
                "| NO |       TIKET       |       HARGA       |       STOK       |       ASAL       |          TUJUAN          |");
        System.out.println(
                "===============================================================================================================");
        int i = 1;
        for (Tiket Tiket : listTiket) {
            System.out.printf("|%-4s|%-21s|%-25s|%-23s|%-20s|%-20s| %n", i++, Tiket.getTiket(),
                    Utility.toRupiah(Tiket.getHarga()),
                    Tiket.getStok(), Tiket.getAsal(), Tiket.getTujuan());
        }
    }

    void store() {
        String inputan = "Y";
        do {

            System.out.println("\n~Ketik 0 kembali ke menu utama-");
            System.out.println("Input No :");
            int lokasiTiket = Utility.inputInt(scan.nextLine());
            if (lokasiTiket > 0 && --lokasiTiket < listTiket.size()) {

                System.out.println("Jumlah");
                int jumlah = Utility.inputInt(scan.nextLine());
                int stok = listTiket.get(lokasiTiket).getStok();

                if (jumlah <= stok) {

                    listTiket.get(lokasiTiket).setStok(stok -= jumlah);

                    String namaTiket = listTiket.get(lokasiTiket).getTiket();
                    int Harga = listTiket.get(lokasiTiket).getHarga();
                    String asal = listTiket.get(lokasiTiket).getAsal();
                    String tujuan = listTiket.get(lokasiTiket).getTujuan();

                    System.out.println("------------------------------------------------------------");
                    System.out.printf("Jenis Tiket |%-21s|Harga  |%-25s|Stok|%-10s|Asal  |%-10s|Tujuan  |%-10s|%n",
                            namaTiket,
                            Utility.toRupiah(Harga),
                            listTiket.get(lokasiTiket).getStok(), asal, tujuan);

                    System.out.println("total : " + Utility.toRupiah(jumlah * Harga));
                    Transaksi Transaksi = new Transaksi();
                    Transaksi.setTiket(namaTiket);
                    Transaksi.setQty(jumlah);
                    Transaksi.setHarga(Harga);
                    Transaksi.setAsal(asal);
                    Transaksi.setTujuan(tujuan);
                    listTransaksi.add(Transaksi);
                    System.out.println("Pemesanan Berhasil");
                } else {
                    System.out.println("Jumlah Pemesanan Melebihi Stok");
                }
            }

            System.out.println("apakah ingin melanjutkan transaksi (Y/N) ? ");
            inputan = scan.nextLine();
        } while (inputan.equalsIgnoreCase("y"));
    }
}
