package com.alexashworth

/*
    Similar to Try - Catch in Java, but can be used as an expression.
    Kotlin does not distinguish between checked and unchecked exceptions.
 */


fun main(args: Array<String>) {
    println("Get number ${getNumber("22")}")
}

fun getNumber(str: String): Int  {
    return try {
        Integer.parseInt(str)
    }
    catch (e: NumberFormatException) {
        0
    }
    finally {
        println("I'm in the finally block")
        // We do not return from here, just execute code
        // We can only specify values to return from try or catch
        // Finally executes first, then try or catch.
    }
}