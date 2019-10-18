package com.example.advancedkotlinsprint.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.advancedkotlinsprint.MainActivity
import com.example.advancedkotlinsprint.R
import kotlinx.android.synthetic.main.child_controller.view.*

class ChildController: Controller {
    constructor() : super()
    constructor(args: Bundle?) : super(args){
        args?.getStringArrayList(MainActivity.BUNDLE_KEY)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.child_controller, container, false)
        val list = args.getStringArrayList(MainActivity.BUNDLE_KEY)
        

        view.child_et_top_left_top.setText(list?.get(0))
        view.child_et_top_right_top.setText(list?.get(1))
        view.child_et_top_left_bottom.setText(list?.get(2))
        view.child_et_top_right_bottom.setText(list?.get(3))


        return view
    }
}