package com.example.hiltsample.retrofit

import com.wl.androidlearning.bean.FoodTasteBeanItem
import retrofit2.http.GET

interface ApiService {

    @GET("ldcy/Line/Line.asmx/SelectRequest")
    suspend fun getFoodTaste(): List<FoodTasteBeanItem>


}