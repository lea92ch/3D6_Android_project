package com.desse.lea.tp_communication_ingredients.view.activities.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "ingredient")
class Ingredient{

    @PrimaryKey
    @NonNull
    var mName : String

    constructor(name: String){
        mName = name
    }

}