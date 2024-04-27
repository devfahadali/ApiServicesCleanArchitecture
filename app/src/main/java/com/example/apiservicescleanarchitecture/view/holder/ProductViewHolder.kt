package com.example.apiservicescleanarchitecture.view.holder

import com.example.apiservicescleanarchitecture.databinding.LayoutProductBinding
import com.example.base.adapter.viewholder.BaseViewHolder
import com.example.domain.models.UiProductList

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
class ProductViewHolder(private val binding: LayoutProductBinding,):BaseViewHolder<LayoutProductBinding,UiProductList>(binding) {
    override fun bind(item: UiProductList, position: Int) {
        binding.txtId.text = item.id.toString()
        binding.txtPrice.text = item.productName
        binding.txtBrand.text = item.productBrand
    }
}