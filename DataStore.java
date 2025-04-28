
import java.util.ArrayList;

public class DataStore {
    public static ArrayList<Saham> daftarSaham = new ArrayList<>();
    public static ArrayList<SuratBerhargaNegara> daftarSBN = new ArrayList<>();

    public static void tambahDataDummy() {
        daftarSaham.add(new Saham("BBRI", "Bank BRI", 5200));
        daftarSaham.add(new Saham("TLKM", "Telkom", 4200));

        daftarSBN.add(new SuratBerhargaNegara("SBR012", 6.5, 24, "01-01-2027", 100000000));
        daftarSBN.add(new SuratBerhargaNegara("ORI021", 6.25, 36, "01-01-2028", 80000000));
    }
}
