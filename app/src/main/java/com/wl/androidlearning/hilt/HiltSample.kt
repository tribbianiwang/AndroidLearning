package com.wl.androidlearning.hilt

import com.wl.androidlearning.utils.LogUtils
import javax.inject.Inject

class HiltSample @Inject constructor(){
    fun doSomeThing(){
        LogUtils.d("hiltSample","dosomething....")
    }
}
