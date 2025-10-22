package com.polman.oop.diagram2code

class Book(
    val id: String,
    val title: String,
    val author: String,
    val year: Int,
    val totalCount: Int
) : Loanable {

    // stok tersedia saat ini
    private var availableCount: Int = totalCount

    init {
        require(id.isNotBlank()) { "id tidak boleh kosong" }
        require(title.isNotBlank()) { "title tidak boleh kosong" }
        require(author.isNotBlank()) { "author tidak boleh kosong" }
        require(year in 1400..2100) { "year harus dalam rentang 1400..2100" }
        require(totalCount >= 0) { "totalCount harus >= 0" }
        availableCount = totalCount
        // invarian dasar
        check(availableCount in 0..totalCount) { "stok awal tidak valid" }
    }

    fun inStock(): Boolean = availableCount > 0

    override fun loan(to: Member): Boolean {
        return if (inStock()) {
            availableCount -= 1
            // jaga invarian
            check(availableCount >= 0) { "stok tidak boleh negatif" }
            true
        } else {
            false
        }
    }

    fun returnOne() {
        if (availableCount >= totalCount) {
            throw IllegalArgumentException("Tidak bisa return: semua eksemplar sudah tersedia (over-capacity)")
        }
        availableCount += 1
        // jaga invarian
        check(availableCount in 0..totalCount) { "stok melebihi totalCount" }
    }

    fun available(): Int = availableCount

    fun info(): String =
        "Book[id=$id, title=$title, author=$author, year=$year, stock=${availableCount}/$totalCount]"
}
