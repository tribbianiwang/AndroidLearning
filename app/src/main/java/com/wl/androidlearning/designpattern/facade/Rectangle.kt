package com.wl.androidlearning.designpattern.facade

import com.wl.androidlearning.utils.LogUtils

class Rectangle :Shape {
    override fun draw() {
        LogUtils.d("facade","画一个长方形")
    }
}