package com.alexashworth

import java.math.BigDecimal

// The when statement is essentially the Switch statement replacement, but on steroids.

fun main(args: Array<String>) {


    val num = 200
    // There is no break statement, under the covers kotlin does it for us.  No falling through.
    when (num) {
        100 -> println("100")
        200 -> println("200")
        300 -> println("300")
        else -> println("No match")
    }

    // we can use ranges, multiple values, and expressions
    val num2 = 45
    when (num) {
        in 1..100 -> println("in range of 100")
        200, 250 -> println("200 or 250")
        num2 + 55 -> println("300")
        400 -> println("400")
        else -> println("No match")
    }

    // We can also do a while by type.
    val obj: Any = "I'm a string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val something: Any = obj

    when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.remainder(BigDecimal(10.5)))
        is Int -> println("${something -22}")
    }


    /*
        We can use the when statement as an expression
        If no else, it will not work.  We must ALWAYS return something.
        We can execute code blocks, but as with If, we must have our return value last.
     */
    val modifiedValue = when (something) {
        is String -> {
            println("Its a goddamn string this time")
            something.toUpperCase()
        }
        is BigDecimal -> something.remainder(BigDecimal(10.5))
        is Int -> "${something -22}"
        else -> something
    }
    println(modifiedValue)

    // ENUMS
    // if when is exhaustive through enum, we don't need an else
    val timeOfYear = Season.WINTER
    val str = when(timeOfYear) {
        Season.SPRING -> "Flowers are blooming"
        Season.SUMMER -> "It's Hot as hell"
        Season.FALL -> "Leaves are falling"
        Season.WINTER -> "It's cold"
    }
    println(str)

    // We can use a when as replacement for a long if else, passing no value.
    val testNum = 5
    val testNum2 = 17
    when {
        testNum > testNum2 -> println("$testNum is greater than $testNum2")
        testNum < testNum2 -> println("$testNum is less than $testNum2")
        else -> println("No Result")
    }

    val result =  when {
        testNum > testNum2 -> "$testNum is greater than $testNum2"
        testNum < testNum2 -> "$testNum is less than $testNum2"
        else -> "No Result"
    }
    println(result)

}

enum class Season{
    SPRING,
    SUMMER,
    FALL,
    WINTER
}