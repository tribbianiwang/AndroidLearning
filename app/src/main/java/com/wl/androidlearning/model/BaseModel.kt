package com.wl.androidlearning.model

import androidx.lifecycle.viewModelScope
import com.wl.androidlearning.retrofit.HttpResult
import com.wl.androidlearning.utils.AppConstans
import kotlinx.coroutines.launch

open class BaseModel {

    suspend fun <T> requestHttp(block:(suspend ()->T)):HttpResult<T>{


            kotlin.runCatching {
                block()
            }.onSuccess {
                return HttpResult(it,AppConstans.QUERYSTATUSSUCCESS,"")

            }.onFailure {
                return HttpResult(null,AppConstans.QUERYSTATUSFAILED,it.localizedMessage)
            }

            return HttpResult(null,"","");
    }


}