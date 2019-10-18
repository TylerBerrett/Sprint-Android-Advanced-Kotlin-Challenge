package com.example.advancedkotlinsprint

class Matrix {

    //TODO: Fix adjusting size
    //TODO: Overload index

    var height: Int = 2
        get() = field
        set(value){
            field = value
        }

    var width: Int = 2
        get() = field
        set(value){
            field = value
        }

    var height2 = 2
    var width2 = 2


    val matrix = Array(height) {Array(width) { 0 } }

    val matrix2 = Array(height2) {Array(width2) { 0 } }

}




operator fun Array<Array<Int>>.times(a: Array<Array<Int>>): ArrayList<String> {
    val column1 = this.size
    val row1 = this[0].size
    val column2 = a.size
    val row2 = a[0].size

    val product = Array(row1) {IntArray(column2)}
    for (i in 0 until row1){
        for (j in 0 until column2) {
            for (k in 0 until column1){
                    product[i][j] += this[i][k] * a[k][j]
            }
        }
    }

    val list = ArrayList<String>()

    product.forEach {
        it.forEach {
            list.add("$it")
        }
    }

    return list
}
