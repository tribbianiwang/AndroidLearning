package com.wl.androidlearning.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * 这里可以对异步请求做一些统一处理，例如显示网络错误提示
 */
open class BaseViewModel: ViewModel(), LifecycleObserver{
    val errorMsgLiveData: MutableLiveData<String> = MutableLiveData()
    val queryStatusLiveData: MutableLiveData<String> = MutableLiveData()
}