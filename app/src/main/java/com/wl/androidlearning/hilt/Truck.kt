package com.wl.androidlearning.hilt

import com.wl.androidlearning.utils.LogUtils
import javax.inject.Inject

class Truck @Inject constructor(var driver: Driver){
    @Inject()
    lateinit var engine: Engine

    fun deliver(){
        engine.startUp()
        LogUtils.d("truck","truck is delivering$driver")
        engine.shutDown()
    }

}