package com.wl.androidlearning.designpattern.factory

import android.util.Log

class Rectangle:Shape{
    override fun draw() {
        Log.d("factorymode","画个长方形")

    }
}