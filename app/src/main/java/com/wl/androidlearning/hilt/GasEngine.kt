package com.wl.androidlearning.hilt

import com.wl.androidlearning.utils.LogUtils
import javax.inject.Inject

class GasEngine @Inject constructor():Engine {
    override fun startUp() {

        LogUtils.d("truck","GasEngine-startup")

    }

    override fun shutDown() {

        LogUtils.d("truck","GasEngine-shutdown")
    }
}