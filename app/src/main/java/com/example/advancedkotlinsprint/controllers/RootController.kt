package com.example.advancedkotlinsprint.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import com.example.advancedkotlinsprint.*
import kotlinx.android.synthetic.main.root_controller.view.*

class RootController: Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller, container, false)

        view.calculate_button.setOnClickListener {
            val matrix = Matrix().matrix

            matrix.set(0,0, view.et_top_left_top.getNumber())
            matrix[0][1] = view.et_top_right_top.getNumber()
            matrix[1][0] = view.et_top_left_bottom.getNumber()
            matrix[1][1] = view.et_top_right_bottom.getNumber()


            val matrix2 = Matrix().matrix2

            matrix2[0][0] = view.et_bottom_left_top.getNumber()
            matrix2[0][1] = view.et_bottom_right_top.getNumber()
            matrix2[1][0] = view.et_bottom_left_bottom.getNumber()
            matrix2[1][1] = view.et_bottom_right_bottom.getNumber()


            val finalProduct = matrix.times(matrix2)
            args.putStringArrayList(MainActivity.BUNDLE_KEY, finalProduct)


            router.pushController(RouterTransaction.with(ChildController(args))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        return view
    }
}