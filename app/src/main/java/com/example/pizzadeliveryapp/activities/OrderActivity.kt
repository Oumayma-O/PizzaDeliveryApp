package com.example.pizzadeliveryapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.pizzadeliveryapp.R

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val pizzaOrder = findViewById<TextView>(R.id.order)

        val PizzaOrder = intent.getStringExtra("orderText")

        if (PizzaOrder != "") {
            pizzaOrder.setText(PizzaOrder)
        }
    }
}