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
