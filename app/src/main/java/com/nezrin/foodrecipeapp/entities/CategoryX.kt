package com.nezrin.foodrecipeapp.entities

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "categoryItems")
data class CategoryX(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

//    @SerializedName("idCategorySer")
    @ColumnInfo(name = "idCategory")
    val idCategory: String? ,

//    @SerializedName("strCategorySer")
    @ColumnInfo(name = "strCategory")
     val strCategory: String?,

//    @SerializedName("strCategoryDescriptionSer")
    @ColumnInfo(name = "strCategoryDescription")
     val strCategoryDescription: String?,

//    @SerializedName("strCategoryThumbSer")
    @ColumnInfo(name = "strCategoryThumb")
     val strCategoryThumb: String?
)