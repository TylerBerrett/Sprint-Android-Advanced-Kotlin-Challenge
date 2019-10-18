package com.example.advancedkotlinsprint.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.advancedkotlinsprint.R

class ChildController: Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.child_controller, container, false)
        return view
    }
}