package com.example.pizzadeliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pizzadeliveryapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonConnect = findViewById<Button>(R.id.login)
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword)

        buttonConnect.setOnClickListener(View.OnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Vérification de l'authentification
            if (email == "ouma@gmail.com" && password == "0000") {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                showToast("Authentication failed")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
