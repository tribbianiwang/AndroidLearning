package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Square:Shape {
    override fun draw() {
        Log.d("factorymode","画个正方形")
    }
}