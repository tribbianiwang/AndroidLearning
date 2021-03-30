package com.wl.androidlearning.designpattern.decorator

import com.wl.androidlearning.utils.LogUtils

class Rectangle:Shape {
    override fun draw() {

        LogUtils.d("decorator","draw a rectangle")
    }
}