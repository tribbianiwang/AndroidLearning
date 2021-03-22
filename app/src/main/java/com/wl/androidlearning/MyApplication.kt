package com.wl.androidlearning

import android.app.Application
import com.wl.androidlearning.hilt.HiltSample
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication:Application() {

    @Inject
    lateinit var  hiltSample:HiltSample
    override fun onCreate() {
        super.onCreate()
        hiltSample.doSomeThing()
    }
}