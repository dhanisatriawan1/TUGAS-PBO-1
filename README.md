@startuml

class Main {
- akun: String[][]
- dataPortofolio: HashMap<String, Portofolio>
- scanner: Scanner
+ main(args: String[]): void
+ login(): void
+ menuAdmin(): void
+ menuCustomer(username: String): void
+ tambahSaham(): void
+ ubahHargaSaham(): void
+ hapusSaham(): void
+ tambahSBN(): void
+ tampilkanProduk(): void
+ beliSaham(p: Portofolio): void
+ jualSaham(p: Portofolio): void
+ beliSBN(p: Portofolio): void
  }

class DataStore {
+ daftarSaham: ArrayList<Saham>
+ daftarSBN: ArrayList<SuratBerhargaNegara>
+ tambahDataDummy(): void
  }

class Saham {
- kode: String
- namaPerusahaan: String
- harga: double
+ getKode(): String
+ getNamaPerusahaan(): String
+ getHarga(): double
+ setHarga(harga: double): void
+ toString(): String
  }

class SuratBerhargaNegara {
- nama: String
- bunga: double
- jangkaWaktu: int
- tanggalJatuhTempo: String
- kuotaNasional: double
+ getNama(): String
+ getBunga(): double
+ getJangkaWaktu(): int
+ getTanggalJatuhTempo(): String
+ getKuotaNasional(): double
+ kurangiKuota(jumlah: double): void
+ toString(): String
  }

class Portofolio {
- sahamDimiliki: HashMap<Saham, Integer>
- sbnDimiliki: HashMap<SuratBerhargaNegara, Double>
+ beliSaham(saham: Saham, jumlah: int): void
+ jualSaham(saham: Saham, jumlah: int): boolean
+ beliSBN(sbn: SuratBerhargaNegara, nominal: double): void
+ tampilkan(): void
+ simulasiSBN(): void
  }

Main --> DataStore
Main --> Saham
Main --> SuratBerhargaNegara
Main --> Portofolio
DataStore --> Saham
DataStore --> SuratBerhargaNegara
Portofolio "1" o-- "*" Saham
Portofolio "1" o-- "*" SuratBerhargaNegara

@enduml

## Skenario Program: Simulasi Investasi Saham & SBN

Berikut ini adalah skenario lengkap program berbasis terminal yang mensimulasikan proses login, pembelian/penjualan saham, pembelian dan simulasi SBN, hingga logout dan keluar dari program.

---

### Step 1: Login

![Login](src/skenarioprogram/step1.png)

Setelah program dijalankan, pengguna akan melihat menu utama dengan dua pilihan: Login dan Keluar.  
Pengguna memilih menu 1 (Login), lalu diminta memasukkan username dan password.  
Pada contoh ini, pengguna memasukkan username `user1` dan password `user123`.

---

### Step 2: Beli Saham

![Beli Saham](src/skenarioprogram/step2.png)

Setelah login, pengguna masuk ke Menu Customer dan memilih opsi 1 (Beli Saham).  
Program kemudian menampilkan daftar saham yang tersedia, seperti BBRI dan TLKM, lengkap dengan harga per lembar.  
Pengguna memilih saham BBRI dan memasukkan jumlah pembelian sebanyak 500 lembar.  
Program menampilkan pesan bahwa pembelian berhasil.

---

### Step 3: Jual Saham

![Jual Saham](src/skenarioprogram/step3.png)

Dari Menu Customer, pengguna memilih opsi 2 (Jual Saham).  
Program menampilkan daftar saham yang dimiliki, dalam contoh ini adalah BBRI dengan jumlah 500 lembar.  
Pengguna memilih saham BBRI dan memasukkan jumlah penjualan sebanyak 500 lembar.  
Program kemudian mengonfirmasi bahwa penjualan berhasil.

---

### Step 4: Beli SBN

![Beli SBN](src/skenarioprogram/step4.png)

Di Menu Customer, pengguna memilih opsi 3 (Beli SBN).  
Program menampilkan daftar produk SBN (Surat Berharga Negara) yang tersedia, seperti SBR012 dan ORI021, beserta detail bunga, tempo, dan kuota.  
Pengguna memilih SBR012 dan memasukkan nominal pembelian sebesar Rp 5.000.000.  
Program kemudian menampilkan pesan bahwa pembelian SBN berhasil.

---

### Step 5: Simulasi SBN

![Simulasi SBN](src/skenarioprogram/step5.png)

Pada Menu Customer, pengguna memilih opsi 4 (Simulasi SBN).  
Program meminta pengguna memasukkan nominal investasi untuk setiap produk SBN, seperti SBR012 dan ORI021.  
Setelah input nominal Rp 5.000.000 untuk kedua produk, program menghitung dan menampilkan estimasi bunga bulanan yang diperoleh, yaitu Rp 24.375,00 untuk SBR012 dan Rp 23.437,50 untuk ORI021.

---

### Step 6: Portofolio

![Portofolio](src/skenarioprogram/step6.png)

Pengguna memilih opsi 5 (Portofolio) dari Menu Customer.  
Program kemudian menampilkan semua aset investasi yang dimiliki, baik saham maupun SBN.  
Dalam kasus ini, hanya investasi di SBR012 yang tercatat, dengan nilai Rp 5.000.000,00 dan estimasi bunga bulanan Rp 24.375,00.

---

### Step 7: Logout

![Logout](src/skenarioprogram/step7.png)

Pengguna memilih opsi 6 (Logout) dari Menu Customer.  
Program kemudian mengarahkan pengguna kembali ke Menu Utama, di mana tersedia pilihan Login untuk masuk kembali atau Keluar untuk menutup program.

---

### Step 8: Keluar

![Keluar](src/skenarioprogram/step8.png)

Setelah logout dan kembali ke Menu Utama, pengguna memilih opsi 2 (Keluar).  
Program kemudian menampilkan pesan _"Program selesai. Terima kasih!"_ dan proses program diakhiri dengan exit code 0, yang menandakan bahwa program telah berhenti dengan normal tanpa error.

---
