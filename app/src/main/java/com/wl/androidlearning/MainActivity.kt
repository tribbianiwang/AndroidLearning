package com.wl.androidlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wl.androidlearning.designpattern.factory.ShapeFactory
import com.wl.androidlearning.fragment.HomeFragment
import com.wl.androidlearning.hilt.HiltSample
import com.wl.androidlearning.hilt.Truck
import com.wl.androidlearning.utils.LogUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var hiltSample:HiltSample
    @Inject
    lateinit var truck: Truck

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        truck.deliver()

        //工厂模式

        var circle = ShapeFactory.createShape("circle")
        var rectangle = ShapeFactory.createShape("rectangle")
        var square = ShapeFactory.createShape("square")

        circle?.draw()
        rectangle?.draw()
        square?.draw()

        LogUtils.d("mair")
        hiltSample.doSomeThing()

        supportFragmentManager.beginTransaction().replace(R.id.cons_root,HomeFragment::class.java,null).commit()
    }
}