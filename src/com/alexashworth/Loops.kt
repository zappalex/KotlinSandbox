package com.alexashworth

fun main(args: Array<String>) {

    /*
        For loops use ranges.  You can include them, or create a variable.
        The range is inclusive.
     */
    val range = 1..3
    val charRange = 'a'..'z'

    // val in range
    println("=== val in range ===================")
    println(3 in range)
    println('z' in charRange)

    // we can use range functions as well
    val reverseRange = 5.downTo(1)

    // we can do this directly in the loop
    println("=== downTo ===================")
    for (i in 20 downTo 16) {
        println(i)
    }

    // skip every 3 in range
    val stepRange = 3..15
    val stepThree = stepRange.step(3)
    println("=== step  ===================")
    for (n in stepThree) {
        println(n)
    }

    // we can combine in the following manner
    println("=== step defined in loop ===================")
    for (i in 1..16 step 4) {
        println(i)
    }

    // reverse existing
    val reverseRange2 = range.reversed()
    println("=== reverse ===================")
    for (i in reverseRange2) {
        println(i)
    }

    // We can iterate through strings, because they have an iterator as well.
    for (i in "sheep") {
        //println(i)
    }

    // if we do not want the end number in the loop, we can use the until keyword
    println("=== iterate until ===================")
    for (i in 1 until 4) {
        println(i)
    }

    // Looping through array
    val seasons = arrayOf("Spring", "Summer", "Fall", "Winter")
    println("=== loop through array ===================")
    for (season in seasons) {
        println(season)
    }

    // we can print all in an array as well
    //seasons.forEach { println(it) }

    // we can also loop through with an index
    println("=== loop through array with index ===================")
    for(index in seasons.indices) {
        println("${seasons[index]} is season number $index")
    }


    // we can do not in
    val notASeason = "whatever" !in seasons

    // you can name a loop
    poopLoop@ for (i in 1..3) {
        // no - op
    }


}

