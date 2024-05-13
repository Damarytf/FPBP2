package appprogram;
public class cMinuman {
   private String kode;
    private String nama;
    private int harga;
    private int stok;

    // Konstruktor
    cMinuman(String kd, String n, int h, int s){
        kode = kd;
        nama = n;
        harga = h;
        stok = s;
    }

    // Metode untuk mendapatkan kode minuman
    public String getKode() {
        return kode;
    }

    // Metode untuk mengatur stok minuman
    public void setStok(int st) {
        stok = st;
    }

    // Metode untuk menampilkan informasi minuman
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }
}
