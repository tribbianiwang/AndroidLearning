package com.wl.androidlearning.designpattern.decorator

 abstract class ShapeDectorator :Shape{
     var dectoratoredShape:Shape

     constructor(dectoratoredShape: Shape) {
         this.dectoratoredShape = dectoratoredShape
     }

     override fun draw(){
         dectoratoredShape.draw()
     }

 }