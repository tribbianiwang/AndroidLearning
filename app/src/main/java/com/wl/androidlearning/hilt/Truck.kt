package com.wl.androidlearning.hilt

import com.wl.androidlearning.utils.LogUtils
import javax.inject.Inject

class Truck @Inject constructor(var driver: Driver){
    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine



    fun deliver(){
        gasEngine.startUp()
        electricEngine.startUp()
        LogUtils.d("truck","truck is delivering$driver")
        gasEngine.shutDown()
        electricEngine.shutDown()
    }

}