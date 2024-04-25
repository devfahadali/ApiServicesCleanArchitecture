package com.example.apiservicescleanarchitecture

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiservicescleanarchitecture.adapters.ProductListAdapter
import com.example.apiservicescleanarchitecture.api.ProductApi
import com.example.apiservicescleanarchitecture.databinding.ActivityMainBinding
import com.example.apiservicescleanarchitecture.models.Product
import com.example.apiservicescleanarchitecture.retofit.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mutableList: MutableList<Product> = mutableListOf()
    private lateinit var productListAdapter: ProductListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterSet()
        apiCall()

    }

    fun adapterSet() {
        productListAdapter = ProductListAdapter()

        binding.rvProductShow.layoutManager = LinearLayoutManager(this)
        binding.rvProductShow.setHasFixedSize(true)
        binding.rvProductShow.adapter = productListAdapter
        binding.rvProductShow.itemAnimator = DefaultItemAnimator()
    }

    fun apiCall() {
        val productApi = RetrofitHelper.getInstance().create(ProductApi::class.java)



        GlobalScope.launch {

            val result = productApi.getProductList()
            val productList = result.body()!!

            mutableList.addAll(productList.products)

            productListAdapter.submitList(mutableList)

            Log.d("resultsProduct", result.body().toString())
        }

    }
}