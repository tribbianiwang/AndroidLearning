package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Blue:Color {
    override fun fill() {

        Log.d("factory","填充为蓝色")
    }
}