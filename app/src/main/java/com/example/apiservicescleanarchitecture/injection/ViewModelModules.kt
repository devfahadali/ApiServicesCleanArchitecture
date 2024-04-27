package com.example.apiservicescleanarchitecture.injection

import com.example.apiservicescleanarchitecture.view.models.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
val viewModule= module {

    viewModel {
        ProductViewModel(get())
    }

}