package dev.loosername.basico

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
class Cliente(var codigo: Int, var nome: String) {
    @ParcelConstructor constructor(): this(0, "")
}