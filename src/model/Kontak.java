package model;

public class Kontak {
    private int id;
    private String nama;
    private String nomorTelepon;
    private String kategori;

    public Kontak(int id, String nama, String nomorTelepon, String kategori) {
        this.id = id;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.kategori = kategori;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public String getNomorTelepon() { return nomorTelepon; }
    public String getKategori() { return kategori; }
}
