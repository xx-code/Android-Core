package com.learning.androidcore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


class home : Fragment() {

    lateinit var goButton: Button
    lateinit var nameInput: EditText
    lateinit var emailInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        nameInput = view.findViewById(R.id.nameEdite)
        emailInput = view.findViewById(R.id.emailEdit)

        goButton = view.findViewById(R.id.gogButton)

        goButton.setOnClickListener {
            val bundle= bundleOf("email" to emailInput.text.toString(), "name" to nameInput.text.toString())
            view.findNavController().navigate(R.id.action_home2_to_second, bundle)
        }

        return view
    }

}