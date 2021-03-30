package com.wl.androidlearning.designpattern.facade

import com.wl.androidlearning.utils.LogUtils

class Square:Shape {
    override fun draw() {
        LogUtils.d("facade","画一个正方形")
    }
}