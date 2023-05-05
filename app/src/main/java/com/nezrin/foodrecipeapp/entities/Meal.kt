package com.nezrin.foodrecipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.nezrin.foodrecipeapp.entities.converter.MealListConverter

@Entity(tableName = "Meal")
data class Meal(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "meals")
    @SerializedName("meals")
    @TypeConverters(MealListConverter::class)
    val meals: List<MealX>?=null
)