package com.wl.androidlearning.designpattern.factory

object ShapeFactory:AbstractFactory(){
    override fun createColor(colorKey: String): Color? {
        return null
    }

    override fun createShape(shapeType:String):Shape?{
        when(shapeType){
            "circle"->return Circle()
            "rectangle"->return Rectangle()
            "square"->return Square()
            else->return null
        }

    }


}