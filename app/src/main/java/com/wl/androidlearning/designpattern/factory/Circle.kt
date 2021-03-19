package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Circle:Shape {
    override fun draw() {
        Log.d("factorymode","画个圆")
    }
}