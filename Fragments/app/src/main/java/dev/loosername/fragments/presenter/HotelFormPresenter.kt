package dev.loosername.fragments.presenter

import dev.loosername.fragments.model.Hotel
import dev.loosername.fragments.model.HotelRepository
import dev.loosername.fragments.model.HotelValidator
import dev.loosername.fragments.view.HotelFormView
import java.lang.Exception

class HotelFormPresenter (
    private val view: HotelFormView,
    private val repository: HotelRepository
) {
    private val validator = HotelValidator()

    fun loadHotel(id: Long) {
        repository.hotelById(id) { hotel ->
            if (hotel != null) {
                view.showHotel(hotel)
            }
        }
    }

    fun saveHotel(hotel: Hotel): Boolean {
        return if (validator.validate(hotel)) {
            try {
                repository.save(hotel)
                true
            } catch (e: Exception) {
                view.errorSaveHotel()
                false
            }
        } else {
            view.errorInvalidHotel()
            false
        }
    }
}