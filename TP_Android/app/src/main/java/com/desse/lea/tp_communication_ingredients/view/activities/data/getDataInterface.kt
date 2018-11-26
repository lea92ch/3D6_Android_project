package com.desse.lea.tp_communication_ingredients.data.model

import android.app.Activity
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient


interface getDataInterface {

    fun getBasket(activity: Activity) : Basket

    fun saveBasket(activity: Activity, basket : Ingredient)

}