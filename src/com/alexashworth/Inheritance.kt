package com.alexashworth

// Reminder:  Everything in Kotlin is Public and Final by default!

fun main(args: Array<String>) {
    val laserPrinter = LaserPrinter("Brother 1234", 500)
    laserPrinter.printModel()

    val specialLaserPrinter = SpecialLaserPrinter("Brother 2344", 600)
    specialLaserPrinter.printModel()

    val somethingElse = SomethingElse("Random String")

}

// Must be open to be extended, if abstract is present, we can take away open.
//open abstract class Printer(val modelName: String) {
abstract class Printer(val modelName: String) {

    // to allow this to be overridden, we must add the open keyword
    open fun printModel() = println("The model name is: $modelName")

    // abstract must be implemented below, open by default
    abstract fun bestSellingPrice(): Double

}

open class LaserPrinter(modelName: String, ppm: Int ): Printer(modelName) {
    // To override function from super class, we need the override keyword.
    // If we don't want print model to be overridden in lower classes, we must add final. override keyword is implicitly open
    final override fun printModel() = println("The model name of this laser printer is $modelName and the cost is ${bestSellingPrice()}")

    // must be implemented, must use override
    override fun bestSellingPrice(): Double = 129.99
}

class SpecialLaserPrinter(modelName: String, ppm: Int): LaserPrinter(modelName, ppm) {
    // can't override printModel() down here, but we can use it.

    // override above is implicitly open
    override fun bestSellingPrice(): Double = 158.44
}


// Primary and Secondary constructors
/*
    You can only call a super classes secondary constructor when no primary constructors are involved.
    If we have a primary constructor, everything has to defer to that instead.
    Best practice is to just use primary constructors.
 */
open class Something {
    val somePropery: String

    // Secondary constructors allow us to have a function body, whereas primary constructors don't.
    constructor(someParameter: String) {
        somePropery = someParameter
        println("Im in the parent's constructor")
    }
}

class SomethingElse: Something {
    // here we defer up to the secondary constructor using "super"
    constructor(someOtherParameter: String): super(someOtherParameter) {
        println("Im in the child's constructor")
    }
}

// data classes are closed off, and cannot be extended.  They are simply for state.