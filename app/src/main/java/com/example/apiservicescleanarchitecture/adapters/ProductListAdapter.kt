package com.example.apiservicescleanarchitecture.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apiservicescleanarchitecture.databinding.LayoutProductBinding
import com.example.apiservicescleanarchitecture.models.Product

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 25/04/2024
 */
class ProductListAdapter : ListAdapter<Product, ProductListAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val legoTheme = getItem(position)
        holder.apply {
            bind(createOnClickListener(legoTheme.id.toInt(), legoTheme.name), legoTheme)
            itemView.tag = legoTheme
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(id: Int, name: String): View.OnClickListener {
        return View.OnClickListener {
//            val direction = LegoThemeFragmentDirections.actionThemeFragmentToSetsFragment(id, name)
//            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: LayoutProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Product) {

            binding.txtId.text = item.id.toString()
            binding.txtPrice.text = item.price
            binding.txtBrand.text = item.brand
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}