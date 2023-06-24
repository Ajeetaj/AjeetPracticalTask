package com.ajeet.practical.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajeet.practical.model.FoodList
import com.ajeet.practical.repository.FoodRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val foodRepo: FoodRepo): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            foodRepo.getFood("",-1,"en",23.04565431097748,72.51181852072477,1334,"",40818)
        }
    }
    val foods: LiveData<FoodList>
        get() = foodRepo.foods
}