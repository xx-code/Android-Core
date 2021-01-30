package com.learning.androidcore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class Second : Fragment() {

    lateinit var email: TextView
    lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        email = view.findViewById(R.id.emailText)
        name = view.findViewById(R.id.nameText)

        email.text = arguments?.getString("email")
        name.text = arguments?.getString("name")

        return view
    }

}