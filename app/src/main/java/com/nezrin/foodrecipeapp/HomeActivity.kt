package com.nezrin.foodrecipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nezrin.foodrecipeapp.adapter.MainCategoryAdapter
import com.nezrin.foodrecipeapp.adapter.SubCategoryAdapter
import com.nezrin.foodrecipeapp.database.RecipeDatabase
import com.nezrin.foodrecipeapp.databinding.ActivityHomeBinding
import com.nezrin.foodrecipeapp.databinding.ActivitySplashBinding
import com.nezrin.foodrecipeapp.entities.CategoryX
import com.nezrin.foodrecipeapp.entities.MealX
import com.nezrin.foodrecipeapp.entities.Recipes
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    var arrMainCategory = ArrayList<CategoryX>()
    var arrSubCategory = ArrayList<MealX>()
    var mainCategoryAdapter=MainCategoryAdapter()
    var subCategoryAdapter=SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFromDb()
        mainCategoryAdapter.setClickListener(onCLicked)
        subCategoryAdapter.setClickListener(onCLickedSubItem)
    }

    private val onCLicked  = object : MainCategoryAdapter.OnItemClickListener {
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }
    private val onCLickedSubItem  = object : SubCategoryAdapter.OnItemClickListener{
        override fun onClicked(id: String) {
            var intent = Intent(this@HomeActivity,DetailActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryX>
                arrMainCategory.reverse()

                getMealDataFromDb(cat[0].strCategory.toString())
                mainCategoryAdapter.setData(arrMainCategory)
                binding.rvMainCategory.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                binding.rvMainCategory.adapter = mainCategoryAdapter
            }
        }
    }
    private fun getMealDataFromDb(categoryName:String){
        binding.tvCategory.text = "$categoryName Category"
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealX>
                subCategoryAdapter.setData(arrSubCategory)
                binding.rvSubCategory.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL,false)
                binding.rvSubCategory.adapter = subCategoryAdapter
            }
        }
    }
}