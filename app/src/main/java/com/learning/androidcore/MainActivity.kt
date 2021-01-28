package com.learning.androidcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        val STATE_NUMBER = "number"
    }

    var number = 0

    lateinit var addButton: Button
    lateinit var removeButton: Button
    lateinit var numberText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState !== null) {
            number = savedInstanceState.getInt(STATE_NUMBER)
        }

        numberText = findViewById(R.id.numberTextView)
        addButton = findViewById(R.id.addButton)
        removeButton = findViewById(R.id.removeButton)

        numberText.text = number.toString()

        addButton.setOnClickListener { addNumber() }
        removeButton.setOnClickListener { removeNumber() }


    }


    fun addNumber () {
        number++
        numberText.text = number.toString()
    }
    fun removeNumber () {
        number--
        numberText.text = number.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("GoGog", number.toString())
        outState.putInt(STATE_NUMBER, number)

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState !== null) {
            number = savedInstanceState.getInt(STATE_NUMBER)
        }
    }
}