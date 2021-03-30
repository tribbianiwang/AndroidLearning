package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Red:Color {
    override fun fill() {
        Log.d("factory","填充为红色")
    }
}