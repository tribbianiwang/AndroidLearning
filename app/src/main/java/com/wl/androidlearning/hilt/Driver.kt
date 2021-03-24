package com.wl.androidlearning.hilt

import android.content.Context
import com.wl.androidlearning.MyApplication
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Driver @Inject constructor(val myApplication: MyApplication){

}