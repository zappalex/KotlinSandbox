package com.alexashworth

fun main(args: Array<String>) {

    // simply run a lambda
    run { println("im in a lambda")}

    // simple lambda with no return, passing two values in.
    val product = { x:Int, y:Int -> x*y}
    println("${product(2,3)}")

    // here is another way to define, with a signature.
    val product2:(Int, Int) -> Int = { x,y -> x*y}
    println("${product2(2,3)}")

    val numbers = listOf(5,1,2,4)
    val n = numbers.count{ x -> x > 3}
    // or, if there's only one parameter being passed...
    val m = numbers.count{it > 3}

    // Closure, where we caputure a variable and manipulate it, can be used outside.
    var sum = 0
    numbers.forEach { sum+= it }

    // Higher Order Functions are those that take a function as a parameter
    var maxvalue = max(numbers, {x,y -> x < y})
    println(maxvalue)

}

// Higher Order Function, taking in a collection, and a function
fun <T> max(collection:Collection<T>, less: (T,T) -> Boolean): T? {
    var max:T? = null
    for( x in collection) {
        if (max == null || less(max, x)) {
            max = x
        }
    }
    return max
}