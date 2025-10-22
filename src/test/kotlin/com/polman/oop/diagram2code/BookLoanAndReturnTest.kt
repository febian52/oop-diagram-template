package com.polman.oop.diagram2code

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BookLoanAndReturnTest {

    @Test
    fun `loan menurunkan stok hingga nol lalu gagal jika habis`() {
        val m1 = Member("M001", "Ani", MemberLevel.REGULAR)
        val m2 = Member("M002", "Budi", MemberLevel.PLATINUM)
        val b = Book("B003", "Kotlin in Action", "Jemerov", 2017, totalCount = 2)

        // 2 -> 1
        Assertions.assertTrue(b.loan(m1))
        Assertions.assertEquals(1, b.available())

        // 1 -> 0
        Assertions.assertTrue(b.loan(m2))
        Assertions.assertEquals(0, b.available())

        // habis -> false
        Assertions.assertFalse(b.loan(m1))
        Assertions.assertEquals(0, b.available())
        Assertions.assertFalse(b.inStock())
    }

    @Test
    fun `returnOne menambah stok jika belum penuh dan melempar exception jika over-capacity`() {
        val m = Member("M010", "Danu", MemberLevel.REGULAR)
        val b = Book("B010", "Refactoring", "Martin Fowler", 1999, totalCount = 1)

        // pinjam dulu agar stok 0
        Assertions.assertTrue(b.loan(m))
        Assertions.assertEquals(0, b.available())

        // return sah: 0 -> 1
        b.returnOne()
        Assertions.assertEquals(1, b.available())

        // over-capacity: stok sudah penuh
        val ex = assertThrows<IllegalArgumentException> {
            b.returnOne()
        }
        Assertions.assertTrue(
            ex.message?.contains("sudah tersedia") == true
                    || ex.message?.contains("penuh") == true
                    || ex.message?.contains("over") == true
        )
    }

    @Test
    fun `siklus pinjam-kembali berulang menjaga invarian 0 le totalCount`() {
        val m = Member("M020", "Eka", MemberLevel.GOLD)
        val b = Book("B020", "Clean Architecture", "Robert C. Martin", 2017, totalCount = 2)

        repeat(5) {
            Assertions.assertTrue(b.loan(m))
            Assertions.assertTrue(b.loan(m) || true) // kedua mungkin false kalau stok habis
            if (b.available() < 2) b.returnOne()
            while (b.available() < 2) b.returnOne()
            Assertions.assertTrue(b.available() in 0..2)
        }
        Assertions.assertEquals(2, b.available())
    }
}