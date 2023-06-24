package com.ajeet.practical.model

data class FoodList(
    val Bravges: List<Any>,
    val Result: List<Result>,
    val code: Int,
    val item_count: Int,
    val msg: String,
    val restaurant_on_off: String
)