package com.controllers;

import java.util.List;
import java.util.Scanner;

import com.Utility;
import com.models.Tiket;

public class TiketControllers {
    private List<Tiket> listTiket;
    static Scanner scan = new Scanner(System.in);

    public TiketControllers(List<Tiket> listTiket) {
        this.listTiket = listTiket;
        MenuTiket();
    }

    void MenuTiket() {
        int pilih = 0;
        do {
            show();

            System.out.println("[1] Input Tiket");
            System.out.println("[2] Update Tiket");
            System.out.println("[3] Batalkan Pemesanan Tiket");
            System.out.println("[0] Halaman Utama");
            System.out.println("Pilih Menu \n ============");
            pilih = Utility.inputInt(scan.nextLine());

            switch (pilih) {
                case 0:
                    System.out.println("");
                    break;
                case 1:
                    store();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    destroy();
                    break;
                default:
                    break;
            }
        } while (pilih != 0);
    }

    void show() {
        System.out.println(
                "===============================================================================================================");
        System.out.println(
                "| NO |       TIKET       |       HARGA       |       STOK       |       ASAL       |          TUJUAN          |");
        System.out.println(
                "===============================================================================================================");
        int i = 1;
        for (Tiket Tiket : listTiket) {
            System.out.printf("|%-4s|%-18s|%-25s|%-23s|%-20s|%-20s| %n", i++, Tiket.getTiket(),
                    Utility.toRupiah(Tiket.getHarga()),
                    Tiket.getStok(), Tiket.getAsal(), Tiket.getTujuan());
        }
    }

    void store() {

        Tiket b = new Tiket();
        System.out.println("Masukkan Jenis Tiket");
        b.setTiket(scan.nextLine());
        System.out.println("Masukkan Harga");
        b.setHarga(Utility.inputInt(scan.nextLine()));
        System.out.println("Masukkan Stok Tiket");
        b.setStok(Utility.inputInt(scan.nextLine()));
        System.out.println("Masukkan Asal");
        b.setAsal(scan.nextLine());
        System.out.println("Masukkan Tujuan");
        b.setTujuan(scan.nextLine());
        listTiket.add(b);
    }

    void update() {
        System.out.println("======Ubah Data Pemesanan tiket kapal ferry======");
        System.out.println("~Kosongkan Data Jika Tidak Ingin Dirubah~");
        System.out.println("~Ketik 0 kembali ke menu utama-");
        System.out.println("Pilih NO :");
        int inputan = Utility.inputInt(scan.nextLine());
        if (inputan > 0 && --inputan < listTiket.size()) {
            System.out.println("Masukkan nama");
            String nama = scan.nextLine();

            if (!nama.equals("")) {
                listTiket.get(inputan).setTiket(nama);
            }
            System.out.println("Masukkan Harga");
            int harga = Utility.inputInt(scan.nextLine());

            if (harga >= 0) {
                listTiket.get(inputan).setHarga(harga);
            }

            System.out.println("Masukkan Stok");
            int stok = Utility.inputInt(scan.nextLine());
            if (stok >= 0) {
                listTiket.get(inputan).setStok(stok);
            }

            System.out.println("Masukkan Asal");
            String asal = scan.nextLine();
            if (!asal.equals("")) {
                listTiket.get(inputan).setAsal(asal);
            }

            System.out.println("Masukkan Tujuan");
            String tujuan = scan.nextLine();
            if (!tujuan.equals(" ")) {
                listTiket.get(inputan).setTujuan(tujuan);
            }
        }
    }

    void destroy() {
        System.out.println("Masukkan No");
        int inputan = Utility.inputInt(scan.nextLine());

        if (inputan > 0 && --inputan < listTiket.size()) {
            listTiket.remove(inputan);
            System.out.println("\n Data Berhasil Dihapus \n");
        }
    }

}
