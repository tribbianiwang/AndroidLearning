package com.wl.androidlearning.designpattern.factory

object ShapeFactory {

    fun createShape(shapeType:String):Shape?{
        when(shapeType){
            "circle"->return Circle()
            "rectangle"->return Rectangle()
            "square"->return Square()
            else->return null
        }

    }


}