package com.desse.lea.tp_communication_ingredients

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.desse.lea.tp_communication_ingredients.view.activities.data.dao.AppDatabase

class MainActivity : AppCompatActivity() {

    lateinit var mBasketButton : Button
    lateinit var mRecipesButton : Button
    lateinit var mSearchButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBasketButton = findViewById(R.id.basket_button) as Button
        mRecipesButton = findViewById(R.id.recipes_button) as Button
        mSearchButton = findViewById(R.id.search_button) as Button

        mBasketButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val basketActivity = Intent(this@MainActivity, BasketActivity::class.java)
                startActivity(basketActivity)
            }
        })

        mRecipesButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val recipesActivity = Intent(this@MainActivity, RecipesActivity::class.java)
                startActivity(recipesActivity)
            }
        })

        mSearchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val searchActivity = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(searchActivity)
            }
        })
    }
}
