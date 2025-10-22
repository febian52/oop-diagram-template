package com.polman.oop.diagram2code

interface Loanable {
    /** true jika berhasil dipinjam; false bila stok habis (tanpa exception) */
    fun loan(to: Member): Boolean
}
