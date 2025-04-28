
public class SuratBerhargaNegara {
    private String nama, tanggalJatuhTempo;
    private double bunga, kuotaNasional;
    private int jangkaWaktu;

    public SuratBerhargaNegara(String nama, double bunga, int jangkaWaktu, String tanggalJatuhTempo, double kuotaNasional) {
        this.nama = nama;
        this.bunga = bunga;
        this.jangkaWaktu = jangkaWaktu;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
        this.kuotaNasional = kuotaNasional;
    }

    public String getNama() { return nama; }
    public double getBunga() { return bunga; }
    public int getJangkaWaktu() { return jangkaWaktu; }
    public String getTanggalJatuhTempo() { return tanggalJatuhTempo; }
    public double getKuotaNasional() { return kuotaNasional; }
    public void kurangiKuota(double jumlah) { kuotaNasional -= jumlah; }

    @Override
    public String toString() {
        return nama + " - Bunga: " + bunga + "%, Tempo: " + tanggalJatuhTempo + ", Kuota: Rp " + kuotaNasional;
    }
}
