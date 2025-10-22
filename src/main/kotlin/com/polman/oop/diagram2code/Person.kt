package com.polman.oop.diagram2code

/**
 * Invarian:
 * - id non-blank
 * - name 2..100 chars (setiap set & init selalu di-trim dan divalidasi)
 */
abstract class Person(
    val id: String,
    name: String
) {
    var name: String = name
        set(value) {
            validateName(value)
            field = value.trim()
        }

    init {
        require(id.isNotBlank()) { "id tidak boleh kosong" }
        validateName(name)
        this.name = name.trim()
    }

    /**
     * Validasi nama:
     * - tidak kosong setelah trim
     * - panjang 2..100
     */
    protected fun validateName(n: String) {
        val t = n.trim()
        require(t.isNotEmpty()) { "name tidak boleh kosong" }
        require(t.length in 2..100) { "name harus 2..100 karakter" }
    }

    /** Ringkasan identitas untuk audit/log. */
    abstract fun showInfo(): String

    /**
     * Kontrak umum:
     * - daysLate >= 0 -> hasil >= 0.0
     * - Untuk input negatif, lempar IllegalArgumentException.
     */
    abstract fun calculateFee(daysLate: Int): Double
}