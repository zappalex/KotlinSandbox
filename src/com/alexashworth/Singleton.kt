package com.alexashworth

import java.time.Year

fun main(args: Array<String>) {
    println(CompanyCommunications.getTagLine())
    println(CompanyCommunications.getCopyRightLine())
}

/*
    - When using the object keyword, we will get one and only one copy of a class
    - No constructors in objects, no one can create an instance.
    - We can extend classes and implement interfaces as well
 */
object CompanyCommunications {
    val currentYear = Year.now().value

    fun getTagLine() = "Our company is great"
    fun getCopyRightLine() = "Copyright, Our company, all rights reserved whatever"

}