package com.ajeet.practical.model

data class Result(
    val is_display_image: String,
    val menu_image: String,
    val menu_item_detail: List<MenuItemDetail>,
    val menu_name: String,
    val restaurant_menu_id: Int
)