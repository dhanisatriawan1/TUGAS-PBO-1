
import java.util.HashMap;

public class Portofolio {
    public HashMap<Saham, Integer> sahamDimiliki = new HashMap<>();
    public HashMap<SuratBerhargaNegara, Double> sbnDimiliki = new HashMap<>();

    public void beliSaham(Saham saham, int jumlah) {
        sahamDimiliki.put(saham, sahamDimiliki.getOrDefault(saham, 0) + jumlah);
    }

    public boolean jualSaham(Saham saham, int jumlah) {
        int dimiliki = sahamDimiliki.getOrDefault(saham, 0);
        if (jumlah > dimiliki) return false;
        if (jumlah == dimiliki) sahamDimiliki.remove(saham);
        else sahamDimiliki.put(saham, dimiliki - jumlah);
        return true;
    }

    public void beliSBN(SuratBerhargaNegara sbn, double nominal) {
        sbnDimiliki.put(sbn, sbnDimiliki.getOrDefault(sbn, 0.0) + nominal);
    }

    public void tampilkan() {
        System.out.println("--- SAHAM ---");
        sahamDimiliki.forEach((s, j) -> {
            double nilaiPasar = j * s.getHarga();
            System.out.printf("%s - %d lembar, Nilai: Rp %.2f%n", s.getNamaPerusahaan(), j, nilaiPasar);
        });

        System.out.println("--- SBN ---");
        sbnDimiliki.forEach((s, n) -> {
            double bungaBulanan = s.getBunga() / 12 / 100 * 0.9 * n;
            System.out.printf("%s - Rp %.2f, Bunga/Bulan: Rp %.2f%n", s.getNama(), n, bungaBulanan);
        });
    }

    public void simulasiSBN() {
        System.out.println("--- SIMULASI BUNGA SBN ---");
        DataStore.daftarSBN.forEach(s -> {
            System.out.printf("%s - Masukkan nominal: ", s.getNama());
            double nominal = Main.scanner.nextDouble();
            double bunga = s.getBunga() / 12 / 100 * 0.9 * nominal;
            System.out.printf("Bunga/bulan: Rp %.2f%n", bunga);
        });
    }
}
