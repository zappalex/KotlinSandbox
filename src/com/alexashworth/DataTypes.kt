package com.alexashworth

import com.alexashworth.java.DummyJavaClass

fun main(args: Array<String>) {

    // We do not automatically widen like in java -
    // myLong = myInt <- automatically widened to Long
    var myLong = 56L
    var myInt = 56
    // in Kotlin, we use conversion functions
    myLong = myInt.toLong()

    // characters get single quotes
    val myChar = 'r'

    // How do we use java class and pass kotlin data object where a primitive is required?
    val onVacation = true
    val vacationTime = DummyJavaClass().isVacationTime(onVacation)
    println(vacationTime)

}