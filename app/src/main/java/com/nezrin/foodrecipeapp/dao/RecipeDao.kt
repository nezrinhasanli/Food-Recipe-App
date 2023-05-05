package com.nezrin.foodrecipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nezrin.foodrecipeapp.entities.Category
import com.nezrin.foodrecipeapp.entities.CategoryX
import com.nezrin.foodrecipeapp.entities.MealX
import com.nezrin.foodrecipeapp.entities.Recipes

@Dao
interface RecipeDao {

    @Query("SELECT * FROM categoryItems ORDER BY id DESC")
   suspend fun getAllCategory():List<CategoryX>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCategory(categoryX: List<CategoryX>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(mealX: MealX)

    @Query("DELETE FROM categoryItems")
    suspend fun clearDB()

    @Query("SELECT * FROM MealItems WHERE categoryName = :categoryName ORDER BY id DESC")
    suspend fun getSpecificMealList(categoryName:String) : List<MealX>
}