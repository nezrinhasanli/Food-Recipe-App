package com.nezrin.foodrecipeapp.interfaces

import com.nezrin.foodrecipeapp.entities.Category
import com.nezrin.foodrecipeapp.entities.Meal
import com.nezrin.foodrecipeapp.entities.MealResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetDataService {

    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>

}