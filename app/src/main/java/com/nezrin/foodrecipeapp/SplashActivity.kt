package com.nezrin.foodrecipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.nezrin.foodrecipeapp.database.RecipeDatabase
import com.nezrin.foodrecipeapp.databinding.ActivitySplashBinding
import com.nezrin.foodrecipeapp.entities.Category
import com.nezrin.foodrecipeapp.entities.CategoryX
import com.nezrin.foodrecipeapp.entities.Meal
import com.nezrin.foodrecipeapp.entities.MealX
import com.nezrin.foodrecipeapp.interfaces.GetDataService
import com.nezrin.foodrecipeapp.retrofitclient.RetrofitClientInstance
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.*

class SplashActivity : BaseActivity(), EasyPermissions.RationaleCallbacks,
    EasyPermissions.PermissionCallbacks {
    private lateinit var binding: ActivitySplashBinding
    private var READ_STORAGE_PERM = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readStorageTask()

        binding.btnGetStarted.setOnClickListener {
            var intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance?.create(GetDataService::class.java)
        val call = service?.getCategoryList()
        call?.enqueue(object : Callback<Category> {

            override fun onFailure(call: Call<Category>, t: Throwable) {
                Toast.makeText(this@SplashActivity, "Something went wrong, using cached data", Toast.LENGTH_SHORT)
                    .show()

            }

            override fun onResponse(call: Call<Category>,response: Response<Category>) {
                for (arr in response.body()!!.categories!!) {
                    getMeal(arr.strCategory!!)
                }
                insertDataIntoRoomDb(response.body())
            }

        })
    }
    fun getMeal(categoryName: String) {
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getMealList(categoryName)
        call.enqueue(object : Callback<Meal> {
            override fun onFailure(call: Call<Meal>, t: Throwable) {

                binding.loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<Meal>,
                response: Response<Meal>
            ) {

                insertMealDataIntoRoomDb(categoryName, response.body())
            }

        })
    }

    fun insertDataIntoRoomDb(category: Category?) {
        launch {
            this.let {

                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().insertCategory(category!!.categories!!)

            }
        }
    }
    fun insertMealDataIntoRoomDb(categoryName: String, meal: Meal?) {

        launch {
            this.let {

                for (arr in meal!!.meals!!) {
                    var mealItemModel = MealX(
                        arr.id,
                        arr.idMeal,
                        categoryName,
                        arr.strMeal,
                        arr.strMealThumb
                    )
                    RecipeDatabase.getDatabase(this@SplashActivity)
                        .recipeDao().insertMeal(mealItemModel)
                    Log.d("mealData", arr.toString())
                }

                binding.btnGetStarted.visibility = View.VISIBLE
            }
        }
    }
    fun clearDataBase() {
        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearDB()
            }
        }
    }



    private fun hasReadStoragePermission(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    private fun readStorageTask() {
        if (hasReadStoragePermission()) {
            clearDataBase()
            getCategories()
        } else {
            EasyPermissions.requestPermissions(
                this, "This app needs access to your storage",
                READ_STORAGE_PERM, android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onRationaleAccepted(requestCode: Int) {
    }

    override fun onRationaleDenied(requestCode: Int) {
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

}