package com.nezrin.foodrecipeapp.database

import android.content.Context
import androidx.room.*
import com.nezrin.foodrecipeapp.dao.RecipeDao
import com.nezrin.foodrecipeapp.entities.*
import com.nezrin.foodrecipeapp.entities.converter.CategoryListConverter
import com.nezrin.foodrecipeapp.entities.converter.MealListConverter
@Database(entities = [Recipes::class,CategoryX::class,Category::class,Meal::class,MealX::class],
    version = 3, exportSchema = true)
@TypeConverters(CategoryListConverter::class,MealListConverter::class)
abstract class RecipeDatabase:RoomDatabase() {

    companion object{

        var INSTANCE:RecipeDatabase?=null

        @Synchronized
        fun getDatabase(context: Context):RecipeDatabase{
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,RecipeDatabase::class.java,"recipe.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }
    abstract fun recipeDao():RecipeDao

}