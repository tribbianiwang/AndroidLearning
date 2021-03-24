package com.wl.androidlearning.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.wl.androidlearning.retrofit.Repository

class MyViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    fun doWork() {
        repository.doRepositoryWork()
    }

}