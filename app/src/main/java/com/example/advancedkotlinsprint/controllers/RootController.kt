package com.example.advancedkotlinsprint.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler

import com.example.advancedkotlinsprint.*
import kotlinx.android.synthetic.main.root_controller.view.*

class RootController: Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.root_controller, container, false)

        view.calculate_button.setOnClickListener {
            Matrix.height = 3
            Matrix.width2 = 3
            Matrix.width = 3
            Matrix.height2 = 3
            val matrix = matrix(Matrix.height, Matrix.width)


            matrix.set(0,0, view.et_top_left_top.getNumber())
            matrix[0][1] = view.et_top_right_top.getNumber()
            matrix[1][0] = view.et_top_left_bottom.getNumber()
            matrix[1][1] = view.et_top_right_bottom.getNumber()

            matrix.forEach {
                it.forEach {
                    println(it)
                }
            }


            val matrix2 = matrix(Matrix.height2, Matrix.width2)

            matrix2[0][0] = view.et_bottom_left_top.getNumber()
            matrix2[0][1] = view.et_bottom_right_top.getNumber()
            matrix2[1][0] = view.et_bottom_left_bottom.getNumber()
            matrix2[1][1] = view.et_bottom_right_bottom.getNumber()

            if (Matrix.width == Matrix.height2){
                val finalProduct = matrix.times(matrix2)
                args.putStringArrayList(MainActivity.BUNDLE_KEY, finalProduct)
                router.pushController(RouterTransaction.with(ChildController(args))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
                )
            } else {
                val alert = "The number of columns in the first matrix should be equal to the number of rows in the second."
                Toast.makeText(view.context, alert, Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
}