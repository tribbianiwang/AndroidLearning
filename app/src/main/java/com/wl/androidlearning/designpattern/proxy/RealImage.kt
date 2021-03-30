package com.wl.androidlearning.designpattern.proxy

import com.wl.androidlearning.utils.LogUtils

class RealImage:Image {
    var fileName:String = ""

    constructor(fileName: String) {
        this.fileName = fileName
    }


    override fun display() {
        loadFromFile()
    LogUtils.d("proxy","start playing:${fileName}")
    }

    fun loadFromFile(){
        LogUtils.d("proxy","load form file:${fileName}")
    }

}