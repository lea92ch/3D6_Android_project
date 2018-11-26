package com.desse.lea.tp_communication_ingredients

/*
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import com.desse.lea.tp_communication_ingredients.R

class BasketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
    }
}
*/


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.desse.lea.tp_communication_ingredients.business.businessManagerInterface
import com.desse.lea.tp_communication_ingredients.business.getDataMock
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient
import kotlinx.android.synthetic.main.activity_basket.*


class BasketActivity : AppCompatActivity() {

    private var mGetData : businessManagerInterface = getDataMock(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        refreshList()

        add_button.setOnClickListener {

            val name : String = ingredient_name_edittext.text.toString()

            //mBasket.ingredients.add(Ingredient(name))
            mGetData.addIngredient(Ingredient(name))

            refreshList()

            //manageData(this).saveBasket( this, mGetData.getBasket())

            Toast.makeText(applicationContext,name,Toast.LENGTH_SHORT).show()

        }

    }

    fun refreshList(){

        val listItems =
                arrayOfNulls<String>(
                        mGetData.getBasketSize())
        for (i in 0 until mGetData.getBasketSize()) {
            listItems[i] = mGetData.getBasket().ingredients[i].mName
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)

        list_item.adapter = adapter

    }

}
