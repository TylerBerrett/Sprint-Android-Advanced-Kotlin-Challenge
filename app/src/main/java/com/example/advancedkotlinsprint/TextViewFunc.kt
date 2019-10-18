package com.example.advancedkotlinsprint

import android.widget.EditText

fun EditText.getNumber(): Int {
    return text.toString().toInt()
}