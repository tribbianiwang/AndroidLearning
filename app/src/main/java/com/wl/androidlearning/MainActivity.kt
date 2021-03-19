package com.wl.androidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wl.androidlearning.designpattern.factory.ShapeFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //工厂模式

        var circle = ShapeFactory.createShape("circle")
        var rectangle = ShapeFactory.createShape("rectangle")
        var square = ShapeFactory.createShape("square")

        circle?.draw()
        rectangle?.draw()
        square?.draw()
    }
}