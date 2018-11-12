package com.desse.lea.tp_communication_ingredients.view.activities.data

import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket


interface getDataInterface {

    fun getBasket() : Basket

    fun saveBasket(basket : Basket)

}