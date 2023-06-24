package com.ajeet.practical.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ajeet.practical.api.ApiInterface
import com.ajeet.practical.model.FoodList

class FoodRepo(private val apiservice:ApiInterface) {
    private val foodLiveData=MutableLiveData<FoodList>()

    val foods:LiveData<FoodList>
    get() = foodLiveData


    suspend fun getFood(date:String,slot:Int,language:String,latitude:Double,longitude:Double,resID:Int,starttime:String,vdrID:Int){
        val result=apiservice.getFood(date,slot,language,latitude,longitude,resID,starttime,vdrID)
        if (result!=null){
            foodLiveData.postValue(result.body())
        }
    }
}