package com.alexashworth

fun main(args: Array<String>) {
    val someClass = SomeClass();
    println(someClass.accessPrivateVar())

    println(SomeOtherClass.accessPrivateVar())

}

/*
    Since static is not included in kotlin, it is impossible to access functions
    or members of the class without instantiating the class.
 */
class SomeClass {
    private val privateVar = 6
    fun accessPrivateVar() = println("I'm accessing privateVar: $privateVar")

}

/*
    - To get class data without having to instantiate the class, we use companion objects.
    - You can think of everything inside the declaration as static.
    - companion object can be named, it is not below.
    - companion object can also act like a factory
 */
class SomeOtherClass {
    companion object {
        private var privateVar = 8
        fun accessPrivateVar() = "I'm accessing privateVar: $privateVar"
    }

}