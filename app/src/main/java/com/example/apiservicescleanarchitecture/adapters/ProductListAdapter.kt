package com.example.apiservicescleanarchitecture.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservicescleanarchitecture.databinding.LayoutProductBinding
import com.example.apiservicescleanarchitecture.utils.diff.ProductDiffUtil
import com.example.apiservicescleanarchitecture.view.holder.ProductViewHolder
import com.example.base.adapter.BaseListAdapter
import com.example.domain.models.UiProductList

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 25/04/2024
 */

class ProductListAdapter : BaseListAdapter<UiProductList,ProductDiffUtil>(ProductDiffUtil()){
    override fun onViewHolderCreate(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = ProductViewHolder(
        LayoutProductBinding.inflate(LayoutInflater.from(parent.context), parent,false ))
    override fun onViewHolderBind(holder: RecyclerView.ViewHolder, position: Int) = (holder as ProductViewHolder).bind(getItem(position), position)
}
