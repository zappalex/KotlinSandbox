package com.alexashworth

fun main(args: Array<String>) {

    println(labelMulitply(2,3, "the result is :"))

    // we can name parameters and put them in any order.  labeling can be helpful with a lot of params esp. of same type
    // officially referred to as "named arguments"
    println(simpleLabelMultipy(operand2 = 4, operand1 = 7))

    val moto1 = Motorcycle("Black", "Ducati")
    val moto2 = Motorcycle("Green", "Kawasaki")
    printMotoColors("=== Moto Colors ====", moto1, moto2)

    // If we want to use an array with a vararg, we cannot simply pass.  We must unpack with the "Spread" operator, as below.
    var motoArray = arrayOf(moto1, moto2)
    printMotoColors("=== Colors using Array ===", *motoArray )

    // we can also create an array of prior arrays, but in order for it to be 2d, we must unpack the arrays
    var combinedArray = arrayOf(*motoArray, *motoArray)
    printMotoColors("=== Combined Array ===", *combinedArray)

    println("=== Extension Function ========")
    val testStr = "lowercase"
    println(testStr.upperFirstLetter())
    val intToSquare = 4
    println(intToSquare.square())
}

// function with braces referred to as "Block Body"
fun labelMulitply (operand1: Int, operand2: Int, label: String ) : String {
    return ("$label ${operand1 * operand2}" )
}

// if we are simply returning, we can simplify further.  Also - the compiler can infer type here.
// function with = known as a expression body
fun simpleLabelMultipy(operand1: Int, operand2: Int, label: String = "result:") = "$label ${operand1 * operand2}"

/*
    To pass an unknown amount of params, we use vararg.  This can only be used once in a parameter list, but can
    be used with other params.  If other params are not named, it must come last.
 */
data class Motorcycle(val color: String, val make: String)

fun printMotoColors (label: String, vararg motos: Motorcycle) {
    println(label)
    for (moto in motos) {
        println(moto.color)
    }
}

// Extension functions
/*
    We can create extension functions, that appear to be of a certain class.
    Below, since we are using String, we don't need to pass it as an argument.
    In the function, we refer to the string as "this"
 */
fun String.upperFirstLetter(): String {
    return this.substring(0,1).toUpperCase() + this.substring(1)
}

fun Int.square(): Int {
    return this * this
}



