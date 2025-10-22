package com.polman.oop.diagram2code

fun main() {
    println("=== PERSONS ===")
    val m1 = Member("M001", "Ani", MemberLevel.REGULAR)
    val m2 = Member("M002", "Budi", MemberLevel.GOLD)
    val m3 = Member("M003", "Cici", MemberLevel.PLATINUM)
    val lib = Librarian("L001", "Sari", "LIB-777")

    println(m1.showInfo())
    println(m2.showInfo())
    println(m3.showInfo())
    println(lib.showInfo())

    // Uji setter name (trim)
    m1.name = " Ani Putri "
    println("Setter trim check → '${m1.name}'")

    // === FEE POLIMORFIK ===
    println("\n=== FEE (POLIMORFIK) ===")
    val daysLate = 3
    println("${m1.id} | ${m1.level} | $daysLate | ${m1.calculateFee(daysLate)}")
    println("${m2.id} | ${m2.level} | $daysLate | ${m2.calculateFee(daysLate)}")
    println("${m3.id} | ${m3.level} | $daysLate | ${m3.calculateFee(daysLate)}")
    println("${lib.id} | LIBRARIAN | $daysLate | ${lib.calculateFee(daysLate)}")

    // === BOOKS ===
    println("\n=== BOOKS ===")
    val b1 = Book("B001", "Clean Code", "Robert C. Martin", 2008, 2)
    val b2 = Book("B002", "Refactoring", "Martin Fowler", 1999, 1)

    println(b1.info())
    println(b2.info())

    println("\n=== LOAN / RETURN TEST ===")
    println("${b1.id} inStock? ${b1.inStock()}")
    println("loan(m1) = ${b1.loan(m1)} → stok=${b1.available()}")
    println("loan(m2) = ${b1.loan(m2)} → stok=${b1.available()}")
    println("loan(m1) (habis) = ${b1.loan(m1)} → stok=${b1.available()}")

    println("returnOne() OK → sebelum=${b1.available()}")
    b1.returnOne()
    println("setelah=${b1.available()}")
    b1.returnOne()
    println("setelah=${b1.available()}")

    try {
        b1.returnOne() // harus lempar exception
    } catch (e: IllegalArgumentException) {
        println("OK: exception over-capacity → ${e.message}")
    }

    println("\n=== LAPORAN AKHIR ===")
    println(b1.info())
    println(b2.info())
}
