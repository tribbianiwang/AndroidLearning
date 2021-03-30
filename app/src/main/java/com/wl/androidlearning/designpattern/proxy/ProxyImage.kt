package com.wl.androidlearning.designpattern.proxy

class ProxyImage:Image {
    var realImage:RealImage?=null
    var fileName:String=""

    constructor(fileName: String) {
        this.fileName = fileName
    }


    override fun display() {
        if(realImage==null){
            realImage = RealImage(fileName)
        }
        realImage?.display()
    }
}