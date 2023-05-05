package com.nezrin.foodrecipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nezrin.foodrecipeapp.R
import com.nezrin.foodrecipeapp.entities.MealX
import com.nezrin.foodrecipeapp.entities.Recipes

class SubCategoryAdapter: RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrSubCategory = ArrayList<MealX>()

   inner class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

        var dishName:TextView
       var imageDish: ImageView

       init {
            dishName=view.findViewById(R.id.tv_sub_dish_name)
           imageDish=view.findViewById(R.id.img_dish_sub)

       }
    }


    fun setData(arrData : List<MealX>){
        arrSubCategory = arrData as ArrayList<MealX>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        arrSubCategory[position]
        holder.dishName.text=arrSubCategory[position].strMeal

        Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(holder.imageDish)
        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrSubCategory[position].idMeal)
        }
    }

    interface OnItemClickListener{
        fun onClicked(id:String)
    }
}