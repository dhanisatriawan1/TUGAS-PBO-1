import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[][] akun = {
            {"admin", "admin123", "admin"},
            {"user1", "user123", "customer"}
    };
    static HashMap<String, Portofolio> dataPortofolio = new HashMap<>();

    public static void main(String[] args) {
        DataStore.tambahDataDummy();
        while (true) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> login();
                case 2 -> {
                    System.out.println("Program selesai. Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void login() {
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Password: ");
        String inputPass = scanner.nextLine();

        for (String[] user : akun) {
            if (user[0].equals(inputUser) && user[1].equals(inputPass)) {
                if (user[2].equals("admin")) {
                    menuAdmin();
                } else {
                    menuCustomer(inputUser);
                }
                return;
            }
        }

        System.out.println("Login gagal.");
    }

    public static void menuAdmin() {
        while (true) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Tambah Saham");
            System.out.println("2. Ubah Harga Saham");
            System.out.println("3. Hapus Saham");
            System.out.println("4. Tambah SBN");
            System.out.println("5. Tampilkan Daftar Produk");
            System.out.println("6. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahSaham();
                case 2 -> ubahHargaSaham();
                case 3 -> hapusSaham();
                case 4 -> tambahSBN();
                case 5 -> tampilkanProduk();
                case 6 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahSaham() {
        System.out.print("Kode Saham: ");
        String kode = scanner.nextLine();
        System.out.print("Nama Perusahaan: ");
        String nama = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        DataStore.daftarSaham.add(new Saham(kode, nama, harga));
        System.out.println("Saham berhasil ditambahkan.");
    }

    public static void ubahHargaSaham() {
        for (int i = 0; i < DataStore.daftarSaham.size(); i++) {
            System.out.println((i + 1) + ". " + DataStore.daftarSaham.get(i));
        }
        System.out.print("Pilih saham: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < DataStore.daftarSaham.size()) {
            System.out.print("Harga baru: ");
            double hargaBaru = scanner.nextDouble();
            scanner.nextLine();
            DataStore.daftarSaham.get(idx).setHarga(hargaBaru);
            System.out.println("Harga berhasil diubah.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public static void tambahSBN() {
        System.out.print("Nama SBN: ");
        String nama = scanner.nextLine();
        System.out.print("Bunga: ");
        double bunga = scanner.nextDouble();
        System.out.print("Jangka Waktu (bulan): ");
        int waktu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tanggal Jatuh Tempo (DD-MM-YYYY): ");
        String tanggal = scanner.nextLine();
        System.out.print("Kuota Nasional (Rp): ");
        double kuota = scanner.nextDouble();
        scanner.nextLine();
        DataStore.daftarSBN.add(new SuratBerhargaNegara(nama, bunga, waktu, tanggal, kuota));
        System.out.println("SBN berhasil ditambahkan.");
    }

    public static void tampilkanProduk() {
        System.out.println("\n--- DAFTAR SAHAM ---");
        if (DataStore.daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham.");
        } else {
            for (Saham s : DataStore.daftarSaham) {
                System.out.println(s);
            }
        }

        System.out.println("\n--- DAFTAR SBN ---");
        if (DataStore.daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN.");
        } else {
            for (SuratBerhargaNegara s : DataStore.daftarSBN) {
                System.out.println(s);
            }
        }
    }

    public static void hapusSaham() {
        if (DataStore.daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia.");
            return;
        }

        for (int i = 0; i < DataStore.daftarSaham.size(); i++) {
            System.out.println((i + 1) + ". " + DataStore.daftarSaham.get(i));
        }

        System.out.print("Pilih saham yang ingin dihapus: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx >= 0 && idx < DataStore.daftarSaham.size()) {
            Saham s = DataStore.daftarSaham.remove(idx);
            System.out.println("Saham " + s.getNamaPerusahaan() + " berhasil dihapus.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public static void menuCustomer(String username) {
        Portofolio portofolio = dataPortofolio.getOrDefault(username, new Portofolio());
        dataPortofolio.put(username, portofolio);
        while (true) {
            System.out.println("\n===== MENU CUSTOMER =====");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1 -> beliSaham(portofolio);
                case 2 -> jualSaham(portofolio);
                case 3 -> beliSBN(portofolio);
                case 4 -> portofolio.simulasiSBN();
                case 5 -> portofolio.tampilkan();
                case 6 -> { return; }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void beliSaham(Portofolio p) {
        for (int i = 0; i < DataStore.daftarSaham.size(); i++) {
            System.out.println((i + 1) + ". " + DataStore.daftarSaham.get(i));
        }
        System.out.print("Pilih: ");
        int idx = scanner.nextInt() - 1;
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        p.beliSaham(DataStore.daftarSaham.get(idx), jumlah);
        System.out.println("Pembelian berhasil.");
    }

    public static void jualSaham(Portofolio p) {
        ArrayList<Saham> list = new ArrayList<>(p.sahamDimiliki.keySet());
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i) + " (Dimiliki: " + p.sahamDimiliki.get(list.get(i)) + ")");
        }
        System.out.print("Pilih: ");
        int idx = scanner.nextInt() - 1;
        System.out.print("Jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();
        if (p.jualSaham(list.get(idx), jumlah)) {
            System.out.println("Penjualan berhasil.");
        } else {
            System.out.println("Jumlah melebihi kepemilikan.");
        }
    }

    public static void beliSBN(Portofolio p) {
        for (int i = 0; i < DataStore.daftarSBN.size(); i++) {
            System.out.println((i + 1) + ". " + DataStore.daftarSBN.get(i));
        }
        System.out.print("Pilih: ");
        int idx = scanner.nextInt() - 1;
        System.out.print("Nominal: ");
        double nominal = scanner.nextDouble();
        scanner.nextLine();
        SuratBerhargaNegara sbn = DataStore.daftarSBN.get(idx);
        if (nominal <= sbn.getKuotaNasional()) {
            sbn.kurangiKuota(nominal);
            p.beliSBN(sbn, nominal);
            System.out.println("Pembelian SBN berhasil.");
        } else {
            System.out.println("Kuota tidak mencukupi.");
        }
    }
}

