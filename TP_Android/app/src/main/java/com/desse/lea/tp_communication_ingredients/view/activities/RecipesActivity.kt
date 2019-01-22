package com.desse.lea.tp_communication_ingredients

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.desse.lea.tp_communication_ingredients.R.id.recipes_list
import com.desse.lea.tp_communication_ingredients.business.businessManagerInterface
import com.desse.lea.tp_communication_ingredients.business.getDataMock
import com.desse.lea.tp_communication_ingredients.view.activities.data.dao.AppDatabase
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient
import kotlinx.android.synthetic.main.activity_recipies.*

class RecipesActivity : AppCompatActivity() ,RecipesCallBack {

    val handler = Handler()

    private lateinit var mlistview: ListView
    var mDb: AppDatabase? = null

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

        mDb = AppDatabase.getInMemoryDatabase(application)
        val ingre = mDb?.ingredientModel()?.loadAllIngredients()

        val liste = getrecepies(ingre as ArrayList<Ingredient>)

        mlistview = findViewById<ListView>(R.id.recipes_list)

        Log.d("TOST", "liste:" + liste.size + "ingre:" + ingre.size)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, liste)

        mlistview.adapter = adapter

        mGetData.getRecipes(this)

    }

    fun getrecepies(ingredients: ArrayList<Ingredient>): List<String> {

        val list = ArrayList<String>()

        //Omelette
        var size = mDb?.ingredientModel()?.findIngredientByNameAndLastName("oeuf")!!.size
        if (size > 0) {
            list.add("Omelette")
        }


        //oeuf mollet
        size = mDb?.ingredientModel()?.findIngredientByNameAndLastName("oeuf")!!.size
        if (size > 0) {
            list.add("oeuf brouillés")
        }

        var size2 = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("pain")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("fromage")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("jambon")!!.size)
        if (size2 > 2) {
            list.add("croque monsieur")
        }

        var size3 = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("pain")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("nutella")!!.size)

        if (size3 > 1) {
            list.add("tartine nutella")
        }

        var size4 = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("patefeuillete")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("oeuf")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("saumon")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("poireau")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("fromage")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("cremefraiche")!!.size)

        if (size4 > 5) {
            list.add("quiche au saumon poireau")
        }

        var size5 = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("pommedeterre")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("beurre")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("cremefraiche")!!.size)

        if (size5 > 2) {
            list.add("pure")
        }


        return list
    }


}

interface RecipesCallBack {
    fun onRecipesReceived(recipes : ArrayList<String>)
}


/*
class RecipesActivity : AppCompatActivity() {


    private lateinit var mlistview: ListView
    var mDb: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipies)

        mDb = AppDatabase.getInMemoryDatabase(application)
        val ingre = mDb?.ingredientModel()?.loadAllIngredients()

        val liste = getrecette(ingre as ArrayList<Ingredient>)

        mlistview = findViewById<ListView>(R.id.recipes_list)

        Log.d("TOST", "liste:" + liste.size + "ingre:" + ingre.size)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, liste)

        mlistview.adapter = adapter


    }



    fun getrecette(ingredients: ArrayList<Ingredient>): List<String> {

        val list = ArrayList<String>()

        //Omelette
        var size = mDb?.ingredientModel()?.findIngredientByNameAndLastName("oeuf")!!.size
        if (size > 0) {
            list.add("Omelette")
        }


        //oeuf mollet
        size = mDb?.ingredientModel()?.findIngredientByNameAndLastName("oeuf")!!.size
        if (size > 0) {
            list.add("oeuf mollet")
        }

        var size2 = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("pain")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("fromage")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("jambon")!!.size)
        if (size2 > 2) {
            list.add("croque monsieur")
        }

        var coucou = (mDb?.ingredientModel()?.findIngredientByNameAndLastName("pain")!!.size) +
                (mDb?.ingredientModel()?.findIngredientByNameAndLastName("nutella")!!.size)

        if (coucou > 1) {
            list.add("tartine nutella")
        }


        return list
    }

    interface RecipesCallBack {
        fun onRecipesReceived(recipes : ArrayList<String>)
    }
}*/