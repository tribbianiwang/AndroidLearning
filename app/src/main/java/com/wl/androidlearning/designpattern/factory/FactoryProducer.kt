package com.wl.androidlearning.designpattern.factory

object FactoryProducer {

    fun createFactory(factoryKey:String):AbstractFactory?{
        when(factoryKey){
            "shapeFactory"->return ShapeFactory
            "colorFactory"->return ColorFactory
        }

        return null
    }
}