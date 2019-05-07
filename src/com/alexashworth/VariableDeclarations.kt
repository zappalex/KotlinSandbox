package com.alexashworth

import com.alexashworth.models.Employee

// top level declaration, can be used in this file.
typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {

    // ===  Immutable ===========
    // NOTE: best practice in Kotlin is to declare val unless var is needed. This is opposite of Java thinking.

    // preferred way to do it with type inference.  Type is fixed at declaration time and cannot be changed.
    val number = 25

    // can be done this way as well.  If we look, we can declare the variable, and then declare it later, but only once.
    val number2: Int
    number2 = 4

    // Explicit type declaration best for widening or narrowing, as type inference will select for you.
    val number3: Short = 45


    // == Mutable ==============
    var number4 = 67
    number4 = 34


    // === Objects =============
    // Here the object is immutable, but has mutable data.  This is fine, it just cannot be assigned to another Employee object.
    val employee1 = Employee("David", 45);
    employee1.name = "Jules"


    // === Type Alias ===========
    val employees: EmployeeSet


    // === Enums ==============
    println(Department.ACCOUNTING.getDeptInfo())
    println(Department.SALES.getDeptInfo())
}

// Enums with properties and function
enum class Department (val fullName: String, val numEmployees: Int){
    HR("Human Resources", 5),
    IT("Info Tech", 34),
    ACCOUNTING("Accounting", 10),
    SALES("Sales", 20);   // <- one exception to the semicolon rule

    fun getDeptInfo() = "The $fullName department has $numEmployees"

}