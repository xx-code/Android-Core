package com.learning.androidcore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    companion object {
        val EMAIL = "akaaugustejunior@gmail.com"
    }

    lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener { navigateToNext()}
    }

    fun navigateToNext () {
        val intent = Intent(this, SecondActivity::class.java ).apply {
            putExtra(Intent.EXTRA_EMAIL, "akaaugustejunior@gmail.com")
        }
        startActivity(intent)
    }
}