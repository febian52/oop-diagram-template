package com.polman.oop.diagram2code

/**
 * - staffCode non-blank
 * - calculateFee() selalu 0.0
 */
class Librarian(
    id: String,
    name: String,
    val staffCode: String
) : Person(id, name) {

    init {
        require(staffCode.isNotBlank()) { "staffCode tidak boleh kosong" }
    }

    override fun showInfo(): String =
        "Librarian[id=$id, name=$name, staffCode=${staffCode.trim()}]"

    override fun calculateFee(daysLate: Int): Double {
        require(daysLate >= 0) { "daysLate harus >= 0" }
        return 0.0
    }
}
