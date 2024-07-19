[# Api_Automation

# Proyek Pengujian UI Web menggunakan Cucumber, Java, Gradle, RestAssurt dengan konsep Page Objek Model
-Api ini dibuat berdasarkan api dari [https://gorest/](https://gorest.co.in/)

Proyek ini mengimplementasikan pengujian otomatis untuk Api menggunakan restassurt sebagai library pengujian berbasis behavior-driven development (BDD), Java untuk bahasa pemrograman, Gradle untuk manajemen dependensi dan build, serta Selenium untuk otomatisasi browser.

## Persiapan
- Seluruh dependensi yang ada di proyek ini semuanya diambil dari https://mvnrepository.com/

## Tujuan Proyek
- Mengelola dan menjalankan pengujian otomatis untuk metode get,create,delete pada Api
- Memastikan bahwa Api berperilaku sesuai dengan spesifikasi dalam berbagai skenario.

## Cara Menjalankan Pengujian
1. Pastikan JDK dan Gradle sudah terinstal di komputer Anda.
2. Clone repositori ini ke komputer Anda.
3. Buka terminal atau command prompt dan masuk ke direktori proyek.
4. Jalankan perintah `gradle test` untuk menjalankan semua pengujian.
5. Lihat laporan hasil pengujian di direktori `build/reports/tests`.

## Struktur Proyek
- `src/test/resources`: Berisi file `.feature` untuk skenario Gherkin.
- `src/main/java/Page`: Berisi kelas Model Objek Halaman.
- `src/test/java/Step`: Berisi kelas Step Definitions untuk implementasi langkah-langkah pengujian.




---

Selengkapnya tentang pengaturan proyek, dependensi, dan konfigurasi dapat ditemukan di file `build.gradle`.
