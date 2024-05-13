package appprogram;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class MainMenu {
    private static cMakanan[] mkn = new cMakanan[6];  
    private static cMinuman[] mnm = new cMinuman[6];
    private static cPembeli[] pbl = new cPembeli[5];
    private static cPembeli pb = new cPembeli();
    private static cTransaksi tr = new cTransaksi();
    public static void main(String[] args) {
        Mainmenu();
    }
    
    private static void isiArray(){
        mkn[0] = new cMakanan("F001", "Soto Daging Sapi", 20000, 10);
        mkn[1] = new cMakanan("F002", "Rawon", 17000, 20);
        mkn[2] = new cMakanan("F003", "Pecel", 12000, 25);
        mnm[0] = new cMinuman("D001", "Air Mineral", 3000, 15);
        mnm[1] = new cMinuman("D002", "Es Teh", 4000, 10);
        mnm[2] = new cMinuman("D003", "Teh Panas", 3000, 12);
        pbl[0] = new cPembeli("PLG001","Damar","Rungkut");
        pbl[1] = new cPembeli("PLG002","Ricky","Gunung Anyar");
        pbl[2] = new cPembeli("PLG003","Amir","Keputih");
    }
    
    public void showMainMenu() {
        JOptionPane.showMessageDialog(null, "SELAMAT DATANG DI SOTO CAK PIPIN", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        isiArray();
        int pilih = 0;
        do {
            String input = JOptionPane.showInputDialog(null,
                    "\n=== MENU ===\n" +
                            "1. Produk\n" +
                            "2. Pembeli\n" +
                            "3. Transaksi\n" +
                            "4. Keluar\n" +
                            "Pilih: ");
            pilih = Integer.parseInt(input);
            switch (pilih) {
                case 1:
                    menuProduk();
                    break;
                case 2:
                    menuPembeli();
                    break;
                case 3:
                    menuTransaksi();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Program Selesai, Terima Kasih");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Pilihan tidak valid");
            }
        } while (pilih != 4);
    }

    private static void menuProduk() {
        int pilih2 = 0;
        do {
            String input = JOptionPane.showInputDialog(null,
                    "[Produk]\n" +
                            "1.Tambah\n" +
                            "2.Ubah\n" +
                            "3.Hapus\n" +
                            "4.Lihat\n" +
                            "5.Kembali\n" +
                            "Pilih = ");
            pilih2 = Integer.parseInt(input);
            boolean kembali=true;
            switch (pilih2) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    ubahProduk();
                    break;
                case 3:
                    hapusProduk();
                    break;
                case 4:
                    lihatProduk();
                    break;
                case 5:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Pilihan tidak valid");
            }
        } while (pilih2 != 5);
    }

    private static void tambahProduk() {
        String jwb = JOptionPane.showInputDialog(null,
                "1.Makanan\n" +
                        "2.Minuman\n" +
                        "Pilih = ");
        String nm = JOptionPane.showInputDialog(null, "Nama = ");
        int hg = Integer.parseInt(JOptionPane.showInputDialog(null, "Harga = "));
        int st = Integer.parseInt(JOptionPane.showInputDialog(null, "Stok = "));
        int jwbInt = Integer.parseInt(jwb);
        if (jwbInt == 1) {
            for (int i = 0; i < mkn.length; i++) {
                if (mkn[i] == null) {
                    mkn[i] = new cMakanan("F00" + (i + 1), nm, hg, st);
                    JOptionPane.showMessageDialog(null, "Produk makanan berhasil ditambahkan");
                    break;
                }
            }
        } else if (jwbInt == 2) {
            for (int i = 0; i < mnm.length; i++) {
                if (mnm[i] == null) {
                    mnm[i] = new cMinuman("D00" + (i + 1), nm, hg, st);
                    JOptionPane.showMessageDialog(null, "Produk minuman berhasil ditambahkan");
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilihan tidak ada");
        }
    }

    private static void ubahProduk() {
        String kode = JOptionPane.showInputDialog(null, "Kode produk: ");
        boolean ubahPrd = false;
        for (int i = 0; i < mkn.length; i++) {
        if (mkn[i] != null && mkn[i].getKode().equalsIgnoreCase(kode)) {
        int hg = Integer.parseInt(JOptionPane.showInputDialog(null, "Harga Baru: "));    
        int st = Integer.parseInt(JOptionPane.showInputDialog(null, "Stok Baru: "));
        int jwb3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Yakin Ubah?\n1.Ya\n2.Tidak"));
        if (jwb3 == 1) {
            mkn[i].setStok(st);
            JOptionPane.showMessageDialog(null, "Produk " + kode + " berhasil diubah");
            ubahPrd = true;
            break;
        } else {
            JOptionPane.showMessageDialog(null, "Ubah produk batal");
        }   } else {
    }
}

// Tambahkan pesan kesalahan jika produk tidak ditemukan
if (!ubahPrd) {
    JOptionPane.showMessageDialog(null, "Produk dengan kode " + kode + " tidak ditemukan");
}
        if (!ubahPrd) {
            for (int i = 0; i < mnm.length; i++) {
                if (mnm[i] != null && mnm[i].getKode().equalsIgnoreCase(kode)) {
                    int st = Integer.parseInt(JOptionPane.showInputDialog(null, "Stok Baru: "));
                    int jwb3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Yakin Ubah?\n1.Ya\n2.Tidak"));
                    if (jwb3 == 1) {
                        mnm[i].setStok(st);
                        JOptionPane.showMessageDialog(null, "Produk " + kode + " berhasil diubah");
                        ubahPrd = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ubah produk batal");
                    }
                }
            }
        }
    }

    private static void hapusProduk() {
        String kode2 = JOptionPane.showInputDialog(null, "Kode produk: ");
        boolean hapusPrd = false;
        for (int i = 0; i < mkn.length; i++) {
            if (mkn[i] != null && mkn[i].getKode().equalsIgnoreCase(kode2)) {
                int jwb4 = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Yakin Hapus?\n1.Ya\n2.Tidak"));
                if (jwb4 == 1) {
                    mkn[i] = null;
                    JOptionPane.showMessageDialog(null, "Produk " + kode2 + " dihapus");
                    hapusPrd = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Produk batal dihapus");
                }
            }
        }
        if (!hapusPrd) {
            for (int i = 0; i < mnm.length; i++) {
                if (mnm[i] != null && mnm[i].getKode().equalsIgnoreCase(kode2)) {
                    int jwb4 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Yakin Hapus?\n1.Ya\n2.Tidak"));
                    if (jwb4 == 1) {
                        mnm[i] = null;
                        JOptionPane.showMessageDialog(null, "Produk " + kode2 + " dihapus");
                        hapusPrd = true;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Produk batal dihapus");
                    }
                }
            }
        }
    }

    private static void lihatProduk() {
        StringBuilder makananStr = new StringBuilder("=== Makanan ===\n");
        for (int i = 0; i < mkn.length; i++) {
            if (mkn[i] != null) {
                makananStr.append((i + 1)).append(". ").append(mkn[i].toString()).append("\n");
            } else {
                makananStr.append("Objek kosong\n");
            }
        }

        StringBuilder minumanStr = new StringBuilder("=== Minuman ===\n");
        for (int i = 0; i < mnm.length; i++) {
            if (mnm[i] != null) {
                minumanStr.append((i + 1)).append(". ").append(mnm[i].toString()).append("\n");
            } else {
                minumanStr.append("Objek kosong\n");
            }
        }

        JOptionPane.showMessageDialog(null, makananStr.toString() + minumanStr.toString());
    }

    private static void menuPembeli() {
        int pilih3 = 0;
        do {
            pilih3 = Integer.parseInt(JOptionPane.showInputDialog("[Pembeli]\n" +
                    "  1.Tambah\n" +
                    "  2.Ubah\n" +
                    "  3.Hapus\n" +
                    "  4.Lihat\n" +
                    "  5.Kembali\n" +
                    "  Pilih = "));
            switch (pilih3) {
                case 1:
                    tambahPembeli();
                    break;
                case 2:
                    ubahPembeli();
                    break;
                case 3:
                    hapusPembeli();
                    break;
                case 4:
                    lihatPembeli();
                    break;
                case 5:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Pilihan tidak valid");
            }
        } while (pilih3 != 5);
    }

    private static void tambahPembeli() {
        String nm = JOptionPane.showInputDialog("Nama = ");
        String alm = JOptionPane.showInputDialog("Alamat = ");
        for (int i = 0; i < pbl.length; i++) {
            if (pbl[i] == null) {
                pbl[i] = new cPembeli("PLG00" + (i + 1), nm, alm);
                break;
            }
        }
    }

    private static void ubahPembeli() {
        String ubahPbl = JOptionPane.showInputDialog("Kode pembeli: ");
        for (int i = 0; i < pbl.length; i++) {
            if (pbl[i] != null && pbl[i].getKode().equalsIgnoreCase(ubahPbl)) {
                String almPbl = JOptionPane.showInputDialog("Alamat Baru: ");
                int jwb = JOptionPane.showConfirmDialog(null, "Yakin Ubah?", "", JOptionPane.YES_NO_OPTION);
                if (jwb == JOptionPane.YES_OPTION) {
                    pbl[i].setAlamat(almPbl);
                    JOptionPane.showMessageDialog(null, "Data dari " + ubahPbl + " berhasil diubah");
                } else {
                    JOptionPane.showMessageDialog(null, "Ubah pelanggan batal");
                }
            }
        }
    }

    private static void hapusPembeli() {
        String hapusPbl = JOptionPane.showInputDialog("Kode pembeli: ");
        for (int i = 0; i < pbl.length; i++) {
            if (pbl[i] != null && pbl[i].getKode().equalsIgnoreCase(hapusPbl)) {
                int jwb2 = JOptionPane.showConfirmDialog(null, "Yakin Hapus?", "", JOptionPane.YES_NO_OPTION);
                if (jwb2 == JOptionPane.YES_OPTION) {
                    pbl[i] = null;
                    JOptionPane.showMessageDialog(null, "Pelanggan " + hapusPbl + " telah dihapus");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Hapus pelanggan batal");
                    break;
                }
            }
        }
    }

    private static void lihatPembeli() {
        StringBuilder output = new StringBuilder("=== Pelanggan ===\n");
        for (int i = 0; i < pbl.length; i++) {
            if (pbl[i] != null) {
                output.append((i + 1)).append(". ").append(pbl[i].ToString()).append("\n");
            } else {
                output.append("Objek kosong\n");
            }
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }

    private static void menuTransaksi() {
        int pilih4 = 0;
        pilih4 = Integer.parseInt(JOptionPane.showInputDialog("[Transaksi]\n" +
                "  1.Tambah\n" +
                "  2.Hapus\n" +
                "  3.Bayar\n" +
                "  4.Kembali\n" +
                "  Pilih = "));
        switch (pilih4) {
            case 1:
                String kodeTr = JOptionPane.showInputDialog("Kode transaksi: ");
                tr.setKode(kodeTr);
                String n = JOptionPane.showInputDialog("Nama pembeli: ");
                pb = new cPembeli(n);
                tr.setPembeli(pb);
                StringBuilder menuProduk = new StringBuilder("=== Makanan ===\n");
                for (int i = 0; i < mkn.length; i++) {
                    if (mkn[i] != null) {
                        menuProduk.append("~ ").append(mkn[i].toString()).append("\n");
                    }
                }
                menuProduk.append("=== Minuman ===\n");
                for (int i = 0; i < mnm.length; i++) {
                    if (mnm[i] != null) {
                        menuProduk.append("~ ").append(mnm[i].toString()).append("\n");
                    }
                }
                boolean tambahPrd = false;
                while (!tambahPrd) {
                    String kd = JOptionPane.showInputDialog(menuProduk.toString() + "\nMasukkan kode: ");
                    int j = Integer.parseInt(JOptionPane.showInputDialog("Masukkan jumlah: "));
                    for (int i = 0; i < mkn.length; i++) {
                        if (mkn[i] != null && mkn[i].getKode().equalsIgnoreCase(kd)) {
                            tr.tambahproduk(mkn[i], j);
                            tambahPrd = true;
                        } else {
                        }
                    }
                    if (!tambahPrd) {
                        for (int i = 0; i < mnm.length; i++) {
                            if (mnm[i] != null && mnm[i].getKode().equalsIgnoreCase(kd)) {
                                tr.tambahProduk(mnm[i], j);
                                tambahPrd = true;
                            }
                        }
                    }
                    if (!tambahPrd) {
                        JOptionPane.showMessageDialog(null, "Produk tidak ada");
                    } else {
                        int jwb = JOptionPane.showConfirmDialog(null, "Tambah lagi?", "",
                                JOptionPane.YES_NO_OPTION);
                        tambahPrd=false;
                        if (jwb == JOptionPane.NO_OPTION) {
                            StringBuilder struk = tr.lihatTransaksi();
                            JOptionPane.showMessageDialog(null, tr.lihatTransaksi());
                            break;
                        }
                    }
                }
                break;
            case 2:
                String kodeTr2 = JOptionPane.showInputDialog("Kode transaksi = ");
                tr.setKode(kodeTr2);
                String pr = JOptionPane.showInputDialog(tr.lihatTransaksi().toString()+"\nKode produk = ");
                tr.hapusproduk(pr);
                JOptionPane.showMessageDialog(null, tr.lihatTransaksi());
                break;
            case 3:
                String kodeTr3 = JOptionPane.showInputDialog("Kode transaksi = ");
                tr.setKode(kodeTr3);
                boolean pelanggan=false;
                StringBuilder struk = tr.lihatTransaksi();
                int total=tr.totalHarga();
                int jwb = Integer.parseInt(JOptionPane.showInputDialog
                      ("\nApakah anda pelanggan?\n1.Ya\n2.Tidak\nJawab = "));
                if (jwb == 1) {
                    String kodePelanggan = JOptionPane.showInputDialog("Masukkan kode pelanggan: ");    
                    for (int i = 0; i < pbl.length; i++) {
                        if (pbl[i] != null && pbl[i].getKode().equalsIgnoreCase(kodePelanggan)) {
                            pelanggan = true;
                            break;
                        }
                    }
                    if (pelanggan) {
                        total *= 0.9;
                        JOptionPane.showMessageDialog(null, "Selamat, anda mendapatkan diskon sebesar 10%");
                        pelanggan=true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode pelanggan tidak valid.");
                    }
                }
                int bayar = Integer.parseInt(JOptionPane.showInputDialog(struk.toString()+"\nBayar = "));                  
                int kembalian=bayar-total;
                StringBuilder struk2 = tr.lihatTransaksi(bayar, kembalian, pelanggan);
                if (kembalian>=0){
                    JOptionPane.showMessageDialog(null,tr.lihatTransaksi(bayar, kembalian, pelanggan));
                }else{
                    JOptionPane.showMessageDialog(null,"Uang anda tidak mencukupi. Pembayaran tidak dapat diproses");
                    }
                break;
            case 4:
                return;
        }         
    }

    private static void Mainmenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

