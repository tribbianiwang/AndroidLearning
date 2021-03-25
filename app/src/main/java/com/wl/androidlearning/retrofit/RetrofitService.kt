package com.example.hiltsample.retrofit

import com.wl.androidlearning.bean.FoodTasteBeanItem
import dagger.Binds
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
interface  RetrofitService {
    @GET("api/china")
    suspend fun getProvinces(): List<Province>


}