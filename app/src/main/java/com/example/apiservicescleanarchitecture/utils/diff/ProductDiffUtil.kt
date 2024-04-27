package com.example.apiservicescleanarchitecture.utils.diff

import com.example.base.adapter.diffutil.BaseDiffUtil
import com.example.domain.models.UiProductList

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
class ProductDiffUtil :BaseDiffUtil<UiProductList>() {

    override fun areContentsTheSame(oldItem: UiProductList, newItem: UiProductList): Boolean {
        return oldItem==newItem
    }

}