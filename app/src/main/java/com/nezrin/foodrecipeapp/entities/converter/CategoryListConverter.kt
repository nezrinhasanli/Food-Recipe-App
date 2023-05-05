package com.nezrin.foodrecipeapp.entities.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nezrin.foodrecipeapp.entities.Category
import com.nezrin.foodrecipeapp.entities.CategoryX

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<CategoryX>): String {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryX>>() {
        }.type
        return gson.toJson(category, type)
    }

    @TypeConverter
    fun toCategoryList(categoryString: String): List<CategoryX> {
        val gson = Gson()
        val type = object : TypeToken<List<CategoryX>>() {
        }.type
        return gson.fromJson(categoryString,type)
    }
}