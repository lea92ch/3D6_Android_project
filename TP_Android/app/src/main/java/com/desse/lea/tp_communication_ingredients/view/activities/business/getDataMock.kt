package com.desse.lea.tp_communication_ingredients.business

import android.app.Activity
import com.desse.lea.tp_communication_ingredients.RecipesCallBack
import com.desse.lea.tp_communication_ingredients.view.activities.data.ManageData
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient

class getDataMock(activity: Activity) : businessManagerInterface {


    override fun getRecipes(recipesCallBack: RecipesCallBack) {

        val thread = Thread(

                Runnable {
                    Thread.sleep(10 * 1000) //Fake network call

                    var list: ArrayList<String> = ArrayList()

                    //fake data
                    /*
                    list.add("Kebab")
                    list.add("Grand Kebab")
                    list.add("Steak")
                    list.add("Escalope")
                    list.add("Pizza")
                    list.add("Tartiflette")
                    list.add("Lasagne")
                    list.add("Raclette")
                    */


                    recipesCallBack.onRecipesReceived(list)
                }
        )

        thread.start()

    }



    val mActivity: Activity = activity

    override fun getRecipes(ingredients: ArrayList<Ingredient>): List<String> {

        val list = ArrayList<String>()

        //Omelette
        if (ingredients.contains(Ingredient("oeuf"))
        ) {
            list.add("Omelette")
        }

        //Quiche
        if (ingredients.contains(Ingredient("oeuf")) &&
                ingredients.contains(Ingredient("jambon")) &&
                ingredients.contains(Ingredient("fromage")) &&
                ingredients.contains(Ingredient("creme fraiche")) &&
                ingredients.contains(Ingredient("pate"))
        ) {

            list.add("Quiche Lorraine")

        }

        //Croque Mr
        if (ingredients.contains(Ingredient("pain")) &&
                ingredients.contains(Ingredient("jambon")) &&
                ingredients.contains(Ingredient("fromage"))
        ) {

            list.add("Croque monsieur")

        }

        return list
    }



    override fun getBasket(): Basket {

        //get value from sharedPreference
        return ManageData(mActivity).getBasket(mActivity)
    }


    override fun addIngredient(ingredient: Ingredient) {

        val basket = ManageData(mActivity).getBasket(mActivity)
        basket.ingredients.add(ingredient)
        ManageData(mActivity).saveBasket(mActivity, ingredient)

    }

    override fun getBasketSize(): Int {
        return ManageData(mActivity).getBasket(mActivity).ingredients.size
    }


    override fun removeIngredient(ingredient: Ingredient) {

        val basket = ManageData(mActivity).getBasket(mActivity)
        basket.ingredients.remove(ingredient)
        ManageData(mActivity).saveBasket(mActivity, ingredient)

    }


}