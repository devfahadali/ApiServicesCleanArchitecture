package com.example.apiservicescleanarchitecture.view.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UiProductList
import com.example.domain.repositories.ProductRepository
import kotlinx.coroutines.launch

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */


class ProductViewModel(val repo: ProductRepository): ViewModel() {


  private  val _productData: MutableLiveData<List<UiProductList>> by lazy {
        MutableLiveData()
    }

    val productData :LiveData<List<UiProductList>>
        get() = _productData

    fun getProductList() = viewModelScope.launch {

        _productData.value = repo.getProductList()

    }
}