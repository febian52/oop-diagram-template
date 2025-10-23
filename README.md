# OOP-Diagram-Template

Proyek ini merupakan implementasi diagram Object-Oriented Programming (OOP) menggunakan bahasa Kotlin. Studi kasus yang digunakan adalah sistem manajemen perpustakaan sederhana yang menerapkan konsep abstraksi, enkapsulasi, pewarisan, dan polimorfisme.

Memulai
Instruksi ini akan membantu Anda mendapatkan salinan proyek yang berjalan di mesin lokal Anda untuk tujuan pengembangan dan pengujian.

Prasyarat
Hal-hal yang perlu Anda instal untuk perangkat lunak dan cara menginstalnya:
Java Development Kit (JDK) 11 atau lebih tinggi
Gradle (biasanya sudah dibundel dengan proyek Kotlin)

Membangun dan Menjalankan
Untuk membangun proyek, navigasikan ke direktori root proyek dan jalankan:
./gradlew build

Untuk menjalankan aplikasi utama, gunakan:
./gradlew run

Untuk menjalankan tes, gunakan:
./gradlew test

Contoh Output
Berikut adalah contoh output yang diharapkan saat menjalankan perintah di atas:
Build

Task :compileKotlin UP-TO-DATE

Task :compileJava NO-SOURCE

Task :processResources NO-SOURCE

Task :classes UP-TO-DATE

Task :jar UP-TO-DATE

Task :testClasses UP-TO-DATE

Task :test

BUILD SUCCESSFUL in 12s
Run
Task :run

=== PERSONS ===

Member[id=M001, name=Ani, level=REGULAR]

Member[id=M002, name=Budi, level=GOLD]

Member[id=M003, name=Cici, level=PLATINUM]

Librarian[id=L001, name=Sari, staffCode=LIB-777]

Setter trim check ? 'Ani Putri'

=== FEE (POLIMORFIK) ===
M001 | REGULAR  | 3 | 6000.0
M002 | GOLD     | 3 | 4500.0
M003 | PLATINUM | 3 | 3000.0
L001 | LIBRARIAN| 3 | 0.0

=== BOOKS ===
Book[id=B001, title=Clean Code, author=Robert C. Martin, year=2008, stock=2/2]
Book[id=B002, title=Refactoring, author=Martin Fowler, year=1999, stock=1/1]

=== LOAN / RETURN TEST ===
B001 inStock? true
loan(m1) = true ? stok=1
loan(m2) = true ? stok=0
loan(m1) (habis) = false ? stok=0
returnOne() sebelumnya=0
setelah=1
setelah=2
OK: exception over-capacity? Tidak bisa return: semua eksemplar sudah tersedia (over-capacity)

=== LAPORAN AKHIR ===
Book[id=B001, title=Clean Code, author=Robert C. Martin, year=2008, stock=2/2]
Book[id=B002, title=Refactoring, author=Martin Fowler, year=1999, stock=1/1]

Test
> Task :test
8 tests passed
BUILD SUCCESSFUL in 12s
