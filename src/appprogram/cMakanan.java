package appprogram;
public class cMakanan {
    private String kode;
    private String nama;
    private int harga;
    private int stok;

    // Konstruktor
    cMakanan(String kd, String n, int h, int s){
        kode = kd;
        nama = n;
        harga = h;
        stok = s;
    }

    // Metode untuk mendapatkan kode makanan
    public String getKode() {
        return kode;
    }

    // Metode untuk mengatur stok makanan
    public void setStok(int st) {
        stok = st;
    }

    // Metode untuk menampilkan informasi makanan
    public String toString() {
        return "Kode: " + kode + ", Nama: " + nama + ", Harga: " + harga + ", Stok: " + stok;
    }
}
