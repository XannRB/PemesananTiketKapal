package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.controllers.HasilTransaksiController;
import com.controllers.TiketControllers;
import com.controllers.TransaksiController;
import com.models.Tiket;
import com.models.Transaksi;

public class App {
    static Scanner scan = new Scanner(System.in);
    public static final Locale locale = new Locale("in", "ID");

    public static void main(String[] args) throws Exception {
        List<Tiket> listTiket = new ArrayList<Tiket>();
        List<Transaksi> listTransaksi = new ArrayList<Transaksi>();

        do {
            System.out.println("=== TRANSAKSI PEMESANA TIKET KAPAL FERRY ===");
            System.out.println("[1] jenis tiket");
            System.out.println("[2] Transaksi");
            System.out.println("[3] Laporan Transaksi");
            System.out.println("---------------------");
            System.out.print("Pilih menu> ");
        } while (showMenu(listTiket, listTransaksi) != 0);

    }

    public static int showMenu(List<Tiket> lTiket, List<Transaksi> lTransaksi) {
        int selectedMenu = Utility.inputInt(scan.nextLine());

        switch (selectedMenu) {
            case 1:
                new TiketControllers(lTiket);
                break;
            case 2:
                new TransaksiController(lTransaksi, lTiket);
                break;
            case 3:
                new HasilTransaksiController(lTransaksi);
                break;

        }

        return selectedMenu;
    }

}
