package com.wl.androidlearning.hilt

import com.wl.androidlearning.utils.LogUtils
import javax.inject.Inject

class ElectricEngine @Inject constructor():Engine {
    override fun startUp() {

        LogUtils.d("truck","ElectEngine-startup")

    }

    override fun shutDown() {

        LogUtils.d("truck","ElectEngine-shutdown")
    }
}