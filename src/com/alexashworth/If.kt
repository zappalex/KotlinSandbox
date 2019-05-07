package com.alexashworth

/*
    The If statement in kotlin is also an expression, and can evaluate to a value.
    The ternary operator does not exist, and is not needed because the if statement can now
    act in that manner itself.
 */

fun main(args: Array<String>) {

    // Equivalent of ternary operator in java
    val someCondition = 5 > 3
    val num = if(someCondition) 50 else 40
    println( "num = $num")

    // You can use blocks of code as well here, as long as the return value is last.
    // we must also include the else, or this will break.
    val anotherNum = if (someCondition) {
        println("condition met")
        50
    } else {
        println("condition not met")
        40
    }
    println("anotherNum = $anotherNum")
}

