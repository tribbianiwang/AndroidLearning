package com.wl.androidlearning.designpattern.factory

object ColorFactory:AbstractFactory(){
    override fun createColor(colorKey: String): Color? {
        when(colorKey){
            "red"->return Red()
            "green"->return Green()
            "blue"->return Blue()
        }

        return null

    }

    override fun createShape(shapeKey: String): Shape? {
        return null
    }
}