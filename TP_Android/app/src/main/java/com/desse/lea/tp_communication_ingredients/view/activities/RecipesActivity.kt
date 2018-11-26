package com.desse.lea.tp_communication_ingredients

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.desse.lea.tp_communication_ingredients.business.businessManagerInterface
import com.desse.lea.tp_communication_ingredients.business.getDataMock
import kotlinx.android.synthetic.main.activity_recipies.*

class RecipesActivity : AppCompatActivity() ,RecipesCallBack {

    val handler = Handler()

    override fun onRecipesReceived(recipes: ArrayList<String>) {

        handler.post(Runnable {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes)

            recipes_list.adapter = adapter

        })
    }

    private var mGetData : businessManagerInterface = getDataMock(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipies)

        mGetData.getRecipes(this)

    }


}

interface RecipesCallBack {
    fun onRecipesReceived(recipes : ArrayList<String>)
}
