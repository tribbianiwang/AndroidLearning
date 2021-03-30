package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Green:Color {
    override fun fill() {
        Log.d("factory","填充为绿色 test")
    }
}