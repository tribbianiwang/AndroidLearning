package com.wl.androidlearning.model


import com.example.hiltsample.retrofit.Province
import com.example.hiltsample.retrofit.RetrofitService
import com.wl.androidlearning.bean.FoodTasteBeanItem
import com.wl.androidlearning.retrofit.HttpResult
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FoodTasteModel @Inject constructor(
    private val retrofitService: RetrofitService,
    ):BaseModel() {

    suspend fun getProvince(): HttpResult<List<Province>> {

      return  requestHttp {
            retrofitService.getProvinces()
        }

    }


}