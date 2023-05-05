package com.nezrin.foodrecipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "MealItems")
data class MealX(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "idMeal")
//    @SerializedName("idMeal")
    val idMeal: String,

    @ColumnInfo(name = "categoryName")
    val categoryName: String,

    @ColumnInfo(name = "strMeal")
//    @SerializedName("strMeal")
    val strMeal: String,

    @ColumnInfo(name = "strMealThumb")
//    @SerializedName("strMealThumb")
    val strMealThumb: String
)