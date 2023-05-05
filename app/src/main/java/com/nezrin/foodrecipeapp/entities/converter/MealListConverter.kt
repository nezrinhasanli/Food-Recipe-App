package com.nezrin.foodrecipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nezrin.foodrecipeapp.entities.MealX

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealX>): String? {
        if (category == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealX>() {

            }.type
            return gson.toJson(category, type)
        }
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<MealX>? {
        if (categoryString == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealX>() {

            }.type
            return gson.fromJson(categoryString, type)
        }
    }
}