package com.example.newskoin.di

import com.example.newskoin.module.RestHelper
import com.example.newskoin.repository.MainRepository
import com.example.newskoin.utils.NetworkHelper
import com.example.newskoin.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ConfigurationClass {

    fun modules() = commonModule + repositoryModule + viewModelModule
}

val repositoryModule  = module {
    single { MainRepository(get()) }
}

val viewModelModule = module {
    viewModel { NewsViewModel(get(),get()) }
}

val commonModule = module {
    single {
        NetworkHelper(androidContext())
    }
    single { RestHelper.client }
}