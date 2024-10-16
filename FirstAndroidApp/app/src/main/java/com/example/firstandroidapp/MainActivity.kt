package com.example.firstandroidapp

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.service.voice.VisibleActivityInfo
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val displayMessage = findViewById<TextView>(R.id.displayMessage)
        val nameInputFieldText = findViewById<TextView>(R.id.nameInputField)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        var name = ""

        submitBtn.setOnClickListener {
             name = nameInputFieldText.text.toString()
            if (name == "") {
                Toast.makeText(
                    this@MainActivity, "Please enter the value", Toast.LENGTH_SHORT
                ).show()
            } else {
                displayMessage.text = "Welcome $name"
                nextBtn.visibility = VISIBLE
            }
        }

        nextBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", name)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}