package com.nezrin.foodrecipeapp.entities

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nezrin.foodrecipeapp.entities.converter.CategoryListConverter

@Entity(tableName = "category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "categories")
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    val categories: List<CategoryX>?=null
    //table icinde basqa table saxladigimiz ucun type converter istifade edirik
)