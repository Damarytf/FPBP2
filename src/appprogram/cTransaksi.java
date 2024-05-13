package appprogram;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class cTransaksi {
    private String kode;
    private cPembeli pbl;
    private cProduk[] prd;
    private int[] jumprd;
    private int[] totprd;
    private int idxprd;
    private int maksprd;
    private int total;

    public cTransaksi() {
        prd = new cProduk[7];
        jumprd = new int[7];
        totprd = new int[7];
        idxprd = 0;
        maksprd = 7;
        kode = "";
        total = 0;
    }

    public void setPembeli(String kd, String n, String a) {
        pbl = new cPembeli(kd, n, a);
    }

    public void setPembeli(cPembeli pb) {
        pbl = pb;
    }

    public void setKode(String kd) {
        kode = kd;
    }

    public void setJumlah(int j) {
        total = j;
    }

    public cPembeli getPembeli() {
        return pbl;
    }

    public cProduk[] getProduk() {
        return prd;
    }

    public String getKode() {
        return kode;
    }

    public int getJumlah() {
        return total;
    }

    public int getTotal() {
        return total;
    }

    public int getIdxprd() {
        return idxprd;
    }

    public void tambahProduk(cProduk p, int j) {
        prd[idxprd] = p;
        jumprd[idxprd] = j;
        totprd[idxprd] = j * p.getHarga();
        idxprd++;
        if (idxprd < maksprd) {
            JOptionPane.showMessageDialog(null, "Tambah sukses..");
        } else {
            JOptionPane.showMessageDialog(null, "Keranjang penuh!");
        }
    }

    public StringBuilder lihatTransaksi() {
        StringBuilder struk = new StringBuilder();
        struk.append("\n=== Daftar Belanja ===");
        struk.append("\nKode: ").append(kode).append(" Nama: ").append(pbl.getNama());
        for (int i = 0; i < idxprd; i++) {
            struk.append("\n").append((i + 1)).append(". ").append(prd[i].getKode()).append(" ").append(prd[i].getNama())
                    .append(" [").append(jumprd[i]).append("]").append(" Rp").append(prd[i].getHarga());
        }
        struk.append("\nTotal: Rp").append(totalHarga());
        return struk;
    }

    public StringBuilder lihatTransaksi(int bayar, int kembalian, boolean pelanggan) {
        StringBuilder struk = lihatTransaksi();
        if (pelanggan) {
            double diskon = 0.1 * totalHarga();
            struk.append("\nDiskon: Rp").append(diskon);
        } else {
            struk.append("\nDiskon: 0");
        }
        struk.append("\nBayar: Rp").append(bayar);
        struk.append("\nKembalian: Rp").append(kembalian);
        return struk;
    }

    public void hapusproduk(String np) {
        boolean ketemu = false;
        for (int i = 0; i < idxprd; i++) {
            if (np.equalsIgnoreCase(prd[i].getKode() + " [" + jumprd[i] + "]")) {
                ketemu = true;
                int jwb = JOptionPane.showConfirmDialog(null, "Yakin hapus?", "", JOptionPane.YES_NO_OPTION);
                if (jwb == JOptionPane.YES_OPTION) {
                    for (int j = i; j < idxprd - 1; j++) {
                        prd[j] = prd[j + 1];
                        jumprd[j] = jumprd[j + 1];
                        totprd[j] = totprd[j + 1];
                    }
                    prd[idxprd - 1] = null;
                    jumprd[idxprd - 1] = 0;
                    totprd[idxprd - 1] = 0;
                    idxprd--;
                    JOptionPane.showMessageDialog(null, "Hapus sukses..");
                } else {
                    JOptionPane.showMessageDialog(null, "Batal Hapus!");
                }
                break;
            }
        }
        if (!ketemu) {
            JOptionPane.showMessageDialog(null, "Produk tidak ditemukan");
        }
    }

    public int totalHarga() {
        int totalHarga = 0;
        for (int i = 0; i < idxprd; i++) {
            totalHarga += totprd[i];
        }
        return totalHarga;
    }

   public  void tambahproduk(cMakanan cMakanan, int j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void tambahProduk(cMinuman minuman, int jumlah) {
    // Implementasi logika untuk menambahkan minuman ke transaksi
}
}