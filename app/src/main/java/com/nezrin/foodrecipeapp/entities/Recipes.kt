package com.nezrin.foodrecipeapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipes(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "dishName")
    var dishName: String
) : java.io.Serializable