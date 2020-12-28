package dev.loosername.fragments.model

data class Hotel(
    var id: Long = 0,
    var name: String = "",
    var address: String = "",
    var rating: Float = 0.0f
) {
    override fun toString(): String = name
}