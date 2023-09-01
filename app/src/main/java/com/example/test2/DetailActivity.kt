package com.example.test2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Hide the system UI elements (status bar and action bar)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        // Initialize the back arrow ImageView and set a click listener to finish the activity
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            finish() // Close the current activity and go back to the previous one (main page)
        }

        // Get data from the intent and populate the TextViews with details
        val date = intent.getStringExtra("date")
        val name = intent.getStringExtra("name")
        val type = intent.getStringExtra("type")

        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val typeTextView = findViewById<TextView>(R.id.typeTextView)

        dateTextView.text = date
        nameTextView.text = name
        typeTextView.text = type
    }
}
