package com.desse.lea.tp_communication_ingredients.view.activities.data

import android.app.Activity
import com.desse.lea.tp_communication_ingredients.data.model.getDataInterface
import com.desse.lea.tp_communication_ingredients.view.activities.data.dao.AppDatabase
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient
import java.util.ArrayList


class ManageData(activity: Activity) : getDataInterface {


    val BASKET : String = "BASKET"
    val mActivity = activity

    override fun getBasket(activity: Activity): Basket {

        val mDb = AppDatabase.getInMemoryDatabase(activity)

        var list : List<Ingredient>? = mDb?.ingredientModel()?.loadAllIngredients()

        val basket = Basket()
        basket.ingredients = list as ArrayList<Ingredient>

        return Basket()
    }

    override fun saveBasket(activity: Activity, ingredient: Ingredient) {

        val mDb = AppDatabase.getInMemoryDatabase(activity)
        mDb?.ingredientModel()?.insertIngredient(ingredient)
        
    }

}