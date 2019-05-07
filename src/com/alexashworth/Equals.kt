package com.alexashworth

import com.alexashworth.models.Employee

fun main(args: Array<String>) {

    // == Equals Operator ============= "==" Structural / "===" Referential
    val employeeOne = Employee("Charles", 50)
    val employeeTwo = Employee("James", 56)
    val employeeThree = Employee("James", 56)

    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)

    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)

    // Strings - structual equality does not need override.  referential appears to cache value
    val string1 = "Hippo"
    val string2 = "Hippo"

    println(string1 == string2)
    println(string1 === string2)


}
