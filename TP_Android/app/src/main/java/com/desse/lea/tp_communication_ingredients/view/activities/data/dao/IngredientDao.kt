package com.desse.lea.tp_communication_ingredients.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.IGNORE
import android.arch.persistence.room.Query
import com.desse.lea.tp_communication_ingredients.view.activities.data.model.Ingredient

@Dao
interface IngredientDao {

    @Query("select * from ingredient")
    fun loadAllIngredients(): List<Ingredient>

    @Insert(onConflict = IGNORE)
    fun insertIngredient(ingredient: Ingredient)


    @Query("select * from ingredient where mName = :id")
    fun loadIngredientById(id: String): Ingredient

    @Query("select * from ingredient where mName = :firstName ")
    fun findIngredientByNameAndLastName(firstName: String): List<Ingredient>



    @Delete
    fun deleteIngredient(ingredient: Ingredient)

    @Query("delete from ingredient where mName like :badName")
    fun deleteIngredientsByName(badName: String): Int

    @Insert(onConflict = IGNORE)
    fun insertOrReplaceIngredients(vararg ingredients: Ingredient)

    @Delete
    fun deleteIngredients(ingredient1: Ingredient, ingredient2: Ingredient)

    @Query("DELETE FROM Ingredient")
    fun deleteAll()

}