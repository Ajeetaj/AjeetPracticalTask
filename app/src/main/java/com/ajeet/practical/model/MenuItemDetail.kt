package com.ajeet.practical.model

data class MenuItemDetail(
    val image: String,
    val is_customization: Int,
    val is_featured: String,
    val is_sold_out: String,
    val item_id: String,
    val item_images: List<ItemImage>,
    val item_name: String,
    val item_packaging_charge: String,
    val item_type: String,
    val mrp: Int,
    val price: Int,
    val quantity: Int,
    val time_slot: String
)