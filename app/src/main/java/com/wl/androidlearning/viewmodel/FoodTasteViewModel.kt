package com.wl.androidlearning.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hiltsample.retrofit.Province
import com.wl.androidlearning.bean.FoodTasteBeanItem
import com.wl.androidlearning.model.FoodTasteModel
import com.wl.androidlearning.retrofit.HttpResult
import com.wl.androidlearning.utils.AppConstans
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.launch

class FoodTasteViewModel @ViewModelInject constructor(private val foodTasteModel: FoodTasteModel):BaseViewModel() {

    val foodTastesLiveData: MutableLiveData<HttpResult<List<Province>>> = MutableLiveData()

    fun getFoodTaste(){
        queryStatusLiveData.value = AppConstans.QUERYSTATUSLOADING

        viewModelScope.launch {
            var httpresult = foodTasteModel.getProvince()
            queryStatusLiveData.value = httpresult.resultCode
            if(httpresult.resultCode==AppConstans.QUERYSTATUSSUCCESS){
                foodTastesLiveData.value = httpresult
            }else if(httpresult.resultCode==AppConstans.QUERYSTATUSFAILED){
                errorMsgLiveData.value = httpresult.errorMsg
            }


        }

//        viewModelScope.launch {
//            kotlin.runCatching {
//                foodTasteModel.getProvince()
//            }.onSuccess {
//                queryStatusLiveData.value = AppConstans.QUERYSTATUSSUCCESS
//                foodTastesLiveData.value = it
//            }.onFailure {
//                queryStatusLiveData.value = AppConstans.QUERYSTATUSFAILED
//                errorMsgLiveData.value = it.localizedMessage
//            }
//        }


    }

}