package com.alexashworth

// By default, all classes are public and final
val CONSTANT_EXAMPLE = 500

fun main(args: Array<String>) {
    /*
    Kotlin generates default accessors and setters when we declare a class.
    Below, it looks like we are setting them directly, but under the covers, the
    getter and setter methods are being called.  It is not possible in kotlin to
    directly change the variable from the outside, as in Java.

    We can access them here because they are defaulted to public
     */
    println("=== Objects ==================")

    val emp = Employee("Josh")
    println(emp.firstName)

    val emp2 = Employee2("Brendan")
    println(emp2.firstName)

    val emp3 = Employee3("Josie")
    println(emp3.firstName)

    val emp4 = Employee4("Jenna", false)
    println( "${emp4.firstName}, ${emp4.fullTime}")

    val emp5 = Employee5("Joe")
    println( "${emp5.firstName}, ${emp5.fullTime}")

    /*
    In Kotlin the getter and setter must have the same visibility.  We cannot have private members that
    are accessible through public getter and setter methods.

    Basically, if you want a member to be able to be modified from the outside, it must be public.
    */
    println("=== Getters and Setters ================")

    val emp6 = Employee6("Charles")
    println(emp6.fullTime)
    emp6.fullTime = false

    // Data Class
    println("=== Data Class ===================")

    val car1 = Car("red", "jetta", 1995)
    val car2 = Car("black", "gti", 2019)
    println(car1.toString())
    println(car2.toString())
    println(car1==car2)

    // we can copy as well, modifying certain values if needed
    val car3 = car1.copy(year = 1996)
    println(car3.toString())

}

// When constructor defined outside braces, it is the primary constructor
class Employee constructor(firstName: String) {

    val firstName: String

    // Not a constructor, used in conjunction with primary constructor.  Kinda the body for the constructor
    init {
        this.firstName = firstName
    }
}

// This is a simplification of what is going on above.
class Employee2 constructor(firstName: String) {
    val firstName: String = firstName
}

// Default Implementation
/*
    - If you are simply assigning values to members, we can use default implementation
    - if you would like to change visibility of constructor to something other than public, it must
      be included here, otherwise, it can be taken out.

 */
//class Employee3 protected constructor(val firstName: String) {}
class Employee3 (val firstName: String) {}


// Using secondary constructor
/*
- Since the primary constructor is passing firstName, it is declared and we need to pass it to secondary.
- Secondary constructors will not declare properties for us like primary.
We must define and default the value at the object level
*/
class Employee4 (val firstName: String) {
    var fullTime: Boolean = false
    constructor( firstName: String, fullTime: Boolean) : this(firstName) {
        this.fullTime = fullTime
    }
}

// We can shorten this by defaulting fullTime in the primary constructor
class Employee5 (val firstName: String, var fullTime: Boolean = false) {}


// If you need to modify the setter or getter, you can but you need to declare the property inside the class.
class Employee6 (val firstName: String, fullTime: Boolean = false) {
    // if you want custom set or get, it must come immediately after definition
    var fullTime = fullTime
    get() {
        println("Running the custom GET method for Employee 6")
        // here field is the actual value.  this is the only place where we can access it.
        return field
    }

    set(value) {
        println("Running the custom SET method for Employee 6")
        field = value
    }
}

/*
 If you simply need a class to store state ( only fields, getters, setters) you can use a Data Class
 Data Class comes with pre-build toString, Equals, and Copy functions as utilities.  You can override them
 as well

 Rules:
 - Primary constructor must at least have 1 declared property
 - Cannot be abstract
  */
data class Car(val color: String, val model: String, val year: Int) {
}

