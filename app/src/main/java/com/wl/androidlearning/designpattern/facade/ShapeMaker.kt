package com.wl.androidlearning.designpattern.facade

 object ShapeMaker {
     var circle:Circle
     var rectangle:Rectangle
     var square:Square
    init {
        circle = Circle()
        rectangle = Rectangle()
        square = Square()
    }



     fun drawCircle(){
        circle.draw()
    }

     fun drawRectangle(){
         rectangle.draw()
     }

     fun drawSquare(){
         square.draw()
     }
}