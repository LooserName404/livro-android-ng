package dev.loosername.fragments.view

import dev.loosername.fragments.model.Hotel

interface HotelDetailsView {
    fun showHotelDetails(hotel: Hotel)
    fun errorHotelNotFound()
}