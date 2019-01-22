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
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.desse.lea.tp_communication_ingredients.business.businessManagerInterface
import com.desse.lea.tp_communication_ingredients.business.getDataMock
import com.desse.lea.tp_communication_ingredients.view.activities.data.dao.AppDatabase
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient
import kotlinx.android.synthetic.main.activity_addingre.*
import kotlinx.android.synthetic.main.activity_basket.*
import org.jetbrains.anko.startActivity
import java.util.*


class BasketActivity : AppCompatActivity() {

    private var mGetData: businessManagerInterface = getDataMock(this)
    private lateinit var mlistview: ListView
    var mDb: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)

        add_ingredients.setOnClickListener { add() }
        remove_ingredients.setOnClickListener { remove() }


    }

    // mlistview = findViewById<ListView>(R.id.list_item)


    /*
    fun getbasket(ingredients: ArrayList<Ingredient>): List<String> {

        val list = ArrayList<String>()
        val ingre = mDb?.ingredientModel()?.loadAllIngredients()

        for (i in 0 until ingre.size) {
            val ingres = list[i]
            list[i] = ingre
        }




        return list
    }
    */

    private fun add() {

        setContentView(R.layout.activity_addingre)

        refreshList()

        add_button.setOnClickListener {

            val name: String = ingredient_name_edittext.text.toString()

            //mBasket.ingredients.add(Ingredient(name))
            mGetData.addIngredient(Ingredient(name))

            refreshList()

            //manageData(this).saveBasket( this, mGetData.getBasket())

            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()


        }

        mDb = AppDatabase.getInMemoryDatabase(application)
        val ingres = mDb?.ingredientModel()?.loadAllIngredients()

        //val liste = getbasket(ingre as ArrayList<Ingredient>)

        mlistview = findViewById<ListView>(R.id.list_item)


        val list = arrayOfNulls<String>(ingres?.size!!)


        for (i in 0 until ingres.size) {
            val ingre = ingres[i]
            list[i] = ingre.mName
        }

        //Log.d("TOST", "liste:" + liste.size + "ingre:" + ingre.size)


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        mlistview.adapter = adapter

    }

    private fun remove() {

        setContentView(R.layout.activity_removeingre)

        refreshList()

        /*
        add_button.setOnClickListener {

            val name: String = ingredient_name_edittext.text.toString()

            //mBasket.ingredients.add(Ingredient(name))
            mGetData.removeIngredient(Ingredient(name))

            refreshList()

            //manageData(this).saveBasket( this, mGetData.getBasket())

            Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()


        }
        */

        mDb = AppDatabase.getInMemoryDatabase(application)
        val ingres = mDb?.ingredientModel()?.loadAllIngredients()

        //val liste = getbasket(ingre as ArrayList<Ingredient>)

        mlistview = findViewById<ListView>(R.id.list_item3)
        mlistview.setOnItemClickListener { parent, view, position, id ->

            val name: Ingredient = ingres!![position]

            //mBasket.ingredients.add(Ingredient(name))
            mDb?.ingredientModel()?.deleteIngredient(name)

            finish()

            startActivity(intent)

            //refreshList()

            //manageData(this).saveBasket( this, mGetData.getBasket())

            //Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()

            Log.d("test", "" + position)
        }


        val list = arrayOfNulls<String>(ingres?.size!!)


        for (i in 0 until ingres.size) {
            val ingre = ingres[i]
            list[i] = ingre.mName
        }

        //Log.d("TOST", "liste:" + liste.size + "ingre:" + ingre.size)


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

        mlistview.adapter = adapter

    }

    fun refreshList() {

        val listItems =
                arrayOfNulls<String>(
                        mGetData.getBasketSize())
        for (i in 0 until mGetData.getBasketSize()) {
            listItems[i] = mGetData.getBasket().ingredients[i].mName
        }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
    }

    fun getBasket(): Array<String?> {
        val listItems =
                arrayOfNulls<String>(
                        mGetData.getBasketSize())
        for (i in 0 until mGetData.getBasketSize()) {
            listItems[i] = mGetData.getBasket().ingredients[i].mName
        }

        return listItems
    }

    fun BasketSize(): Int {
        return mGetData.getBasketSize()
    }

}



