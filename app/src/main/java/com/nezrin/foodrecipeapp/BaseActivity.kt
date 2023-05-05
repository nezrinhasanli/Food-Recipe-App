package com.nezrin.foodrecipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.nezrin.foodrecipeapp.databinding.ActivitySplashBinding
import com.nezrin.foodrecipeapp.entities.Category
import com.nezrin.foodrecipeapp.interfaces.GetDataService
import com.nezrin.foodrecipeapp.retrofitclient.RetrofitClientInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.*
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(),CoroutineScope {
    private lateinit var job:Job
    override val coroutineContext:CoroutineContext
        get() = job + Dispatchers.Main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}