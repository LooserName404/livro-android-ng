package dev.loosername.fragments.view

import dev.loosername.fragments.model.Hotel

interface HotelFormView {
    fun showHotel(hotel: Hotel)
    fun errorInvalidHotel()
    fun errorSaveHotel()
}