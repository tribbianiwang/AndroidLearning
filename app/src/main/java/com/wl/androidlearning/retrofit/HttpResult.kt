package com.wl.androidlearning.retrofit

data class HttpResult<T>(val data:T?,val resultCode:String,val errorMsg:String)