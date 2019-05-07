package com.alexashworth

import com.alexashworth.models.Employee

fun main(args: Array<String>) {

    // Must override toString in Object, otherwise we will get a reference.
    val employeeOne = Employee("Deb", 76)
    println(employeeOne)

    // Escaping $
    val change = 4.55
    println("Your change is $change")
    println("Your change is \$change")
    println("Your change is $$change")

    // We can do expressions as well...
    println("We will divide 12 by 4 and get ${12/4}")

    // Objects must be treated in this manner as well
    println("Employee One's ID is ${employeeOne.id}")


    // === Raw Strings ===============
    // use """ for raw strings
    val filePath = """c://home/blah/i/dont/have/to/escape/anything"""
    println(filePath)

    // multi-line
    val poem = """Humpty dumpty
        |fell off the wall
        |something like that
        """.trimMargin()
    println(poem)

}