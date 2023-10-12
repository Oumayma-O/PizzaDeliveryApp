package com.example.pizzadeliveryapp.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.pizzadeliveryapp.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val minusButton = findViewById<Button>(R.id.minusButton)
        val plusButton = findViewById<Button>(R.id.plusButton)
        val quantityTextView = findViewById<TextView>(R.id.quantityTextView)
        val pizzaImageView = findViewById<ImageView>(R.id.PizzaImageView)
        val pizzaTitle = findViewById<TextView>(R.id.PizzaTitle)

        // Retrieve the selected pizza image resource ID
        val selectedPizzaImageResId = intent.getIntExtra("selectedPizzaImageResId", 0)

        val selectedPizzaTitle = intent.getStringExtra("selectedPizzaTitle")

        if (selectedPizzaTitle != "") {
            pizzaTitle.setText(selectedPizzaTitle)
        }
        // Set the selected pizza image to the ImageView
        if (selectedPizzaImageResId != 0) {
            pizzaImageView.setImageResource(selectedPizzaImageResId)
        }

// Initialize the quantity
        var quantity = 1

        minusButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityTextView.text = quantity.toString()
            }
        }

        plusButton.setOnClickListener {
            quantity++
            quantityTextView.text = quantity.toString()
        }

        val placeOrderButton = findViewById<Button>(R.id.placeOrder)
        val regularImageView = findViewById<ImageView>(R.id.regular)
        val mediumImageView = findViewById<ImageView>(R.id.medium)
        val largeImageView = findViewById<ImageView>(R.id.large)

        var size =""

        regularImageView.setOnClickListener {
            // Set the size to "Regular" when the regular image is clicked
            size = "Regular"
        }

        mediumImageView.setOnClickListener {
            // Set the size to "Medium" when the medium image is clicked
            size = "Medium"
        }

        largeImageView.setOnClickListener {
            // Set the size to "Large" when the large image is clicked
            size = "Large"
        }

        placeOrderButton.setOnClickListener {
            val selectedPizzaTitle = pizzaTitle.text.toString()
            val quantity = quantityTextView.text.toString()
             // Implement your size determination logic

            val emailSubject = "Pizza Order"
            val emailBody = "Pizza : $selectedPizzaTitle\nQuantity: $quantity\nSize: $size"

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // Use the mailto: scheme

            // Set the recipient (replace with your recipient's email address)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("oumaymaouerfelli3@gmail.com"))

            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            intent.putExtra(Intent.EXTRA_TEXT, emailBody)

            // Check if there is an email app available to handle the intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                // Handle the case where there's no email app available
            }

            val orderIntent = Intent(this, OrderActivity::class.java)
            orderIntent.putExtra("orderText", emailBody) // Send the order text to OrderActivity
            startActivity(orderIntent)
        }


    }
}