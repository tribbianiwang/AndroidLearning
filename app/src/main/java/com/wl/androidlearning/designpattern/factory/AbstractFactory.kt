package com.wl.androidlearning.designpattern.factory

abstract class AbstractFactory {
    abstract fun createColor(colorKey:String):Color?
    abstract fun createShape(shapeKey:String):Shape?
}