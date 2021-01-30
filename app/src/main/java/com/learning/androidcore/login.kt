package com.learning.androidcore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class login : Fragment() {

    lateinit var logButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        logButton = view.findViewById(R.id.logButton)

        logButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_login_to_nav_graph)
        }

        return view
    }

}