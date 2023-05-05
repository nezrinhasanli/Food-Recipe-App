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
import com.nezrin.foodrecipeapp.entities.CategoryX
import com.nezrin.foodrecipeapp.entities.Recipes

class MainCategoryAdapter: RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listener: OnItemClickListener? = null
    var ctx: Context? = null
    var arrMainCategory = ArrayList<CategoryX>()

   inner class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

        var dishName:TextView
        var imageDish:ImageView
        init {
            dishName=view.findViewById(R.id.tv_dish_name)
            imageDish=view.findViewById(R.id.img_dish)
        }
    }


    fun setData(arrData : List<CategoryX>){
        arrMainCategory = arrData as ArrayList<CategoryX>
    }

    fun setClickListener(listener1: OnItemClickListener){
        listener = listener1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        arrMainCategory[position]
        holder.dishName.text=arrMainCategory[position].strCategory

        Glide.with(ctx!!).load(arrMainCategory[position].strCategoryThumb).into(holder.imageDish)
        holder.itemView.rootView.setOnClickListener {
            listener!!.onClicked(arrMainCategory[position].strCategory.toString())
        }
    }

    interface OnItemClickListener{
        fun onClicked(categoryName:String)
    }
}