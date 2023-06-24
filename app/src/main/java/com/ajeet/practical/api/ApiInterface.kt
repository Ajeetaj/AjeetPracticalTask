package com.ajeet.practical.api

import com.ajeet.practical.model.FoodList
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("api/v1/restaurantmenus")
    suspend fun getFood(
        @Field("date") date:String,
        @Field("delivery_type_time_slots") slot:Int,
        @Field("is_langauge") language:String,
        @Field("latitude") latitude:Double,
        @Field("longitude") longitude:Double,
        @Field("restaurant_id") restaurant_id:Int,
        @Field("starttime") starttime:String,
        @Field("vendor_id") vendor_id:Int
    ):Response<FoodList>
}