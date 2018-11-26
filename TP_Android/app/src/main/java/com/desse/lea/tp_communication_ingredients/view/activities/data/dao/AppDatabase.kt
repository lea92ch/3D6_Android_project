package com.desse.lea.tp_communication_ingredients.view.activities.data.dao


import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.desse.lea.tp_communication_ingredients.data.dao.IngredientDao
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient

@Database(entities = arrayOf(Ingredient::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun ingredientModel(): IngredientDao


    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInMemoryDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "dbtp")
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}