package com.ajeet.practical

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajeet.practical.model.FoodList
import com.ajeet.practical.model.Result
import com.bumptech.glide.Glide

class RecyclerAdapter(var ctx:Context):
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    private var list:List<FoodList> = listOf()

    fun updateData(data: List<FoodList>) {
        this.list = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(ctx).inflate(R.layout.display_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (this.list != null) this.list.size else 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemName.text= list[position].Result[position].menu_item_detail[position].item_name
        holder.itemPrice.text= list[position].Result[position].menu_item_detail[position].price.toString()
        holder.itemQuantity.text= list[position].Result[position].menu_item_detail[position].quantity.toString()
        Glide.with(ctx).load(list[position].Result[position].menu_item_detail[position].item_images).into(holder.itemImg)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImg=itemView.findViewById<ImageView>(R.id.itemImage)
        var itemName=itemView.findViewById<TextView>(R.id.itemName)
        var itemPrice=itemView.findViewById<TextView>(R.id.itemPrice)
        var itemQuantity=itemView.findViewById<TextView>(R.id.itemQuantity)
    }

}