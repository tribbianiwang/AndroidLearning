package com.wl.androidlearning.model


import com.example.hiltsample.retrofit.Province
import com.example.hiltsample.retrofit.RetrofitService
import com.wl.androidlearning.bean.FoodTasteBeanItem
import javax.inject.Inject

class FoodTasteModel @Inject constructor(
    private val retrofitService: RetrofitService,
    ) {

    suspend fun getProvince(): List<Province> {
        return retrofitService.getProvinces()
    }


}