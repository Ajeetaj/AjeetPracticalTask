package com.ajeet.practical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajeet.practical.api.ApiInterface
import com.ajeet.practical.api.RetrofitClient
import com.ajeet.practical.repository.FoodRepo
import com.ajeet.practical.viewmodel.MainViewModel
import com.ajeet.practical.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var recView:RecyclerView
    lateinit var recAdapter:RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView=findViewById(R.id.rv)
        recView.layoutManager = LinearLayoutManager(this)
        recAdapter=RecyclerAdapter(this)
        recView.adapter=recAdapter

        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        val repo=FoodRepo(apiInterface)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModel::class.java)

       mainViewModel.foods.observe(this, Observer {

           recAdapter.updateData(listOf(it))
           recAdapter.notifyDataSetChanged()
           recView.adapter=recAdapter
           //Log.d("ABCDEFG",listOf(it.Result).toString())
       })
    }
}