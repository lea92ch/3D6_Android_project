package fr.jips.smartmitton.data

import fr.jips.smartmitton.data.model.Basket

interface getDataInterface {

    fun getBasket() : Basket

    fun saveBasket(basket : Basket)

}