package com.desse.lea.tp_communication_ingredients.business

import com.desse.lea.tp_communication_ingredients.RecipesCallBack
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient


interface businessManagerInterface {

    fun  getBasket() : Basket
    fun addIngredient (ingredient: Ingredient)
    fun getBasketSize() : Int

    fun getRecipes (ingredients: ArrayList<Ingredient>): List<String>
    fun getRecipes (recipesCallBack : RecipesCallBack)



}