package com.example.apiservicescleanarchitecture

import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiservicescleanarchitecture.adapters.ProductListAdapter
import com.example.apiservicescleanarchitecture.databinding.ActivityMainBinding
import com.example.apiservicescleanarchitecture.view.models.ProductViewModel
import com.example.base.activity.BaseActivity
import com.example.base.adapter.extension.setLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun initView() {
        productViewModel.getProductList()
        initAdapter()
        setupRecyclerView()
        setupObserver()

    }
    private lateinit var productListAdapter: ProductListAdapter
    private val productViewModel : ProductViewModel by viewModel()

    private fun adapterSet() {
        productListAdapter = ProductListAdapter()
        binding.rvProductShow.layoutManager = LinearLayoutManager(this)
        binding.rvProductShow.setHasFixedSize(true)
        binding.rvProductShow.adapter = productListAdapter
        binding.rvProductShow.itemAnimator = DefaultItemAnimator()
    }

    private fun initAdapter() {
        productListAdapter = ProductListAdapter()
    }
    private fun setupRecyclerView() {
        binding.rvProductShow.adapter = productListAdapter
        binding.rvProductShow.setHasFixedSize(true)
        binding.rvProductShow.setLayoutManager()
    }
    private fun setupObserver() {
        productViewModel.productData.observer{
            binding.mPrograss.visibility = View.GONE
            productListAdapter.submitList(it)
        }

    }
}