package fr.jips.smartmitton.business

import fr.jips.smartmitton.data.model.Basket
import fr.jips.smartmitton.data.model.Ingredient
import fr.jips.smartmitton.view.activities.RecipesCallBack

interface businessManagerInterface {

    fun  getBasket() : Basket
    fun addIngredient (ingredient: Ingredient)
    fun getBasketSize() : Int

    fun getRecipes (ingredients: ArrayList<Ingredient>): List<String>
    fun getRecipes (recipesCallBack : RecipesCallBack)



}