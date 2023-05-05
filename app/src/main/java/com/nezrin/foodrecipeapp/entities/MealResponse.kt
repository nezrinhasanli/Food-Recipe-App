package com.nezrin.foodrecipeapp.entities

import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    var mealsEntity: List<MealsEntity>
)

data class MealsEntity(
    @SerializedName("idMeal")
    val idmeal: String,
    @SerializedName("strMeal")
    val strmeal: String,
    @SerializedName("strCategory")
    val strcategory: String,
    @SerializedName("strArea")
    val strarea: String,
    @SerializedName("strInstructions")
    val strinstructions: String,
    @SerializedName("strMealThumb")
    val strmealthumb: String,
    @SerializedName("strTags")
    val strtags: String,
    @SerializedName("strYoutube")
    val stryoutube: String,
    @SerializedName("strIngredient1")
    val stringredient1: String,
    @SerializedName("strIngredient2")
    val stringredient2: String,
    @SerializedName("strIngredient3")
    val stringredient3: String,
    @SerializedName("strIngredient4")
    val stringredient4: String,
    @SerializedName("strIngredient5")
    val stringredient5: String,
    @SerializedName("strIngredient6")
    val stringredient6: String,
    @SerializedName("strIngredient7")
    val stringredient7: String,
    @SerializedName("strIngredient8")
    val stringredient8: String,
    @SerializedName("strIngredient9")
    val stringredient9: String,
    @SerializedName("strIngredient10")
    val stringredient10: String,
    @SerializedName("strIngredient11")
    val stringredient11: String,
    @SerializedName("strIngredient12")
    val stringredient12: String,
    @SerializedName("strIngredient13")
    val stringredient13: String,
    @SerializedName("strIngredient14")
    val stringredient14: String,
    @SerializedName("strIngredient15")
    val stringredient15: String,
    @SerializedName("strIngredient16")
    val stringredient16: String,
    @SerializedName("strIngredient17")
    val stringredient17: String,
    @SerializedName("strIngredient18")
    val stringredient18: String,
    @SerializedName("strIngredient19")
    val stringredient19: String,
    @SerializedName("strIngredient20")
    val stringredient20: String,
    @SerializedName("strMeasure1")
    val strmeasure1: String,
    @SerializedName("strMeasure2")
    val strmeasure2: String,
    @SerializedName("strMeasure3")
    val strmeasure3: String,
    @SerializedName("strMeasure4")
    val strmeasure4: String,
    @SerializedName("strMeasure5")
    val strmeasure5: String,
    @SerializedName("strMeasure6")
    val strmeasure6: String,
    @SerializedName("strMeasure7")
    val strmeasure7: String,
    @SerializedName("strMeasure8")
    val strmeasure8: String,
    @SerializedName("strMeasure9")
    val strmeasure9: String,
    @SerializedName("strMeasure10")
    val strmeasure10: String,
    @SerializedName("strMeasure11")
    val strmeasure11: String,
    @SerializedName("strMeasure12")
    val strmeasure12: String,
    @SerializedName("strMeasure13")
    val strmeasure13: String,
    @SerializedName("strMeasure14")
    val strmeasure14: String,
    @SerializedName("strMeasure15")
    val strmeasure15: String,
    @SerializedName("strMeasure16")
    val strmeasure16: String,
    @SerializedName("strMeasure17")
    val strmeasure17: String,
    @SerializedName("strMeasure18")
    val strmeasure18: String,
    @SerializedName("strMeasure19")
    val strmeasure19: String,
    @SerializedName("strMeasure20")
    val strmeasure20: String,
    @SerializedName("strSource")
    val strsource: String
)
