package com.example.pizzadeliveryapp.activities

import MainHorAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzadeliveryapp.R
import com.example.pizzadeliveryapp.activities.adapters.MainHorizontalItem

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val horizontalRecyclerView = findViewById<RecyclerView>(R.id.horizontalRecyclerView)
        val items = createSampleItems() // Replace with your data
        horizontalRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = MainHorAdapter(this, items)



    }

    private fun createSampleItems(): List<MainHorizontalItem> {
        // Replace with your actual data
        return listOf(
            MainHorizontalItem(R.drawable.pepperoni1, "Pepperoni Pizza", 30.5,"Description 1"),
            MainHorizontalItem(R.drawable.margarita1, "Margarita Pizza", 40.0,"Description 3"),
            MainHorizontalItem(R.drawable.vegie1, "Vegie Pizza", 25.0 ,"Description 3")


        )
    }
}