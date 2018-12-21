package com.example.gajanand.mvvmdemo.utils

import android.text.TextUtils

class Utils{
    companion object {
        fun isValidNumber(num: String):Boolean{
            return TextUtils.isDigitsOnly(num)
        }
    }
}