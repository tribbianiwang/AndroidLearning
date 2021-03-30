package com.wl.androidlearning.designpattern.flyweight

import com.wl.androidlearning.utils.LogUtils

class Circle:Shape {
     var color:String=""
     var x:Int =0
     var y:Int =0
     var radius:Int = 0




    constructor(color: String) {
        this.color = color
    }



    override fun draw() {
        LogUtils.d("flyweight","color:${color},x:${x},y:${y},radius:${radius}")
    }
}