package com.desse.lea.tp_communication_ingredients.view.activities.data

import android.app.Activity
import android.content.Context
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Basket


class manageData(activity: Activity) : getDataInterface {


    val BASKET : String = "BASKET"
    val mActivity = activity

    override fun getBasket(): Basket {

        val sharedPref = mActivity.getPreferences(Context.MODE_PRIVATE)
        val json = sharedPref.getString(BASKET,"")

        val gson = Gson()
        val basket = gson.fromJson<Basket>(json,Basket::class.java)

        if(basket == null){
            return Basket()
        }

        return basket

    }

    override fun saveBasket(basket: Basket) {

        val gson = Gson()
        val json = gson.toJson(basket)

        val sharedPref = mActivity.getPreferences(Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(BASKET,json)
        editor.commit()

    }

}