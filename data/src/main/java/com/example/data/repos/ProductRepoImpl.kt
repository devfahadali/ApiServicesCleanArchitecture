package com.example.data.repos

import com.example.basenetwork.repository.BaseApiRepo
import com.example.basenetwork.response.BaseNetworkResponse
import com.example.data.api.ProductApi
import com.example.domain.models.UiProductList
import com.example.domain.repositories.ProductRepository

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
class ProductRepoImpl(val api : ProductApi): ProductRepository, BaseApiRepo() {
    override suspend fun getProductList(): List<UiProductList> {
        val response = apiCall { api.getProductList()

        }
        val uiProductList:MutableList<UiProductList>  = mutableListOf()

      return  when(response){
            is BaseNetworkResponse.Success->{
               for (i in response.value.body()?.products!!){
                    uiProductList.add(UiProductList(i.id.toInt(),i.price,i.brand))
               }
                uiProductList
            }

            is BaseNetworkResponse.Failure-> uiProductList

        }
    }


}