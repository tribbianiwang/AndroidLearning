package com.wl.androidlearning.designpattern.decorator

import com.wl.androidlearning.utils.LogUtils

class RedShapeDectorator(dectoratoredShape: Shape) : ShapeDectorator(dectoratoredShape) {


    override fun draw() {
        super.draw()
        drawRedShape()
    }

    fun drawRedShape(){
        LogUtils.d("decorator","draw a red shape")
    }

}