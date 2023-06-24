package com.ajeet.practical.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ajeet.practical.repository.FoodRepo

class MainViewModelFactory(private val foodrepo: FoodRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(foodrepo) as T
    }
}