package com.example.advancedkotlinsprint.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import com.example.advancedkotlinsprint.R
import kotlinx.android.synthetic.main.root_controller.view.*

class RootController: Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller, container, false)

        view.calculate_button.setOnClickListener {
            router.pushController(RouterTransaction.with(ChildController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        return view
    }
}