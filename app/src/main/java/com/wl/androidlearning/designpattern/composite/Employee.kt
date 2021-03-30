package com.wl.androidlearning.designpattern.composite

class Employee {

    var name:String=""
    var salary:Int = 0
    var dept:String=""
    var subordinates = ArrayList<Employee>()

    constructor(name: String, salary: Int, dept: String) {
        this.name = name
        this.salary = salary
        this.dept = dept
    }


    fun addEmployee(subordinate:Employee){
        subordinates.add(subordinate)
    }

    override fun toString(): String {

        return "name:${name}--salary:${salary}--dept:${dept}"
    }


}