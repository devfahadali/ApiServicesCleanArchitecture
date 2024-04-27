package com.example.apiservicescleanarchitecture.app

import android.app.Application
import com.example.apiservicescleanarchitecture.injection.viewModule
import com.example.data.injection.apiInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
class BaseApplication:Application() {

    private val dependencyModules = mutableListOf<Module>()
    override fun onCreate() {
        super.onCreate()
        addKoinModules()
        startKoin {
            androidContext(applicationContext)
            modules(dependencyModules)
        }
    }

    private fun addKoinModules() {

        dependencyModules.add(viewModule)

        dependencyModules.add(apiInjection)

    }
}