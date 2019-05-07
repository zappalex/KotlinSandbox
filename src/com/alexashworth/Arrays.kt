package com.alexashworth

import com.alexashworth.java.DummyJavaClass

fun main(args: Array<String>) {
    // No special array type, Array is a class - a collections class

    // If you already know the elements...
    val names = arrayOf("Joe", "Wendy", "Clarence")

    // Type is inferred, and if casting is required, we have two routes
    val longs1 = arrayOf(1L, 45L, 67L)
    val longs2 = arrayOf<Long>(1, 45, 67)

    // we can access values with old indexing syntax
    println(names[2])

    // Declare Array of fixed size
    val evenNumbers = Array(4) { i -> i * 2 }
    for (number in evenNumbers) {
        println(number)
    }

    /*
    NOTE: If we initialize an array without the data, we must specify type, because type
    inference is only possible with data present.

    NOTE: We can create an array as val, but we can only initialize it one.  we can, however, still
    chance data.  If array needs to be reassigned, we must use var
     */
    val immutableArray: Array<Int>
    immutableArray = arrayOf(1, 2, 3, 4)
    for (item in immutableArray) {
        println(item)
    }

    immutableArray[0] = 10
    for (item in immutableArray) {
        println(item)
    }
    // we can't do this -> immutableArray = arrayOf(1, 4, 5, 6)

    // We can do a mixed array as well, this will be of type ANY
    val mixedArray = arrayOf("Joey", 34, 'h')

    /*
     Using a java method that is taking a primitive, we cannot automatically pass the Array class, as we did with a single primitive.
     We must use a subclass of Array that is an array of a primitive type.  This will give us a performance boost as well, and can be
     used outside of ths functionality if we know the type of the Array.  Each primitive type will have a corresponding array subclass
      */
    val testIntArray = intArrayOf(3, 4, 5, 67)
    DummyJavaClass().printArray(testIntArray)

    // Additionally, with primitive arrays, we can declare an array of type and size, and it will default to 0 at creation.
    // We cannot do this with the array class.
    val primitiveArray = IntArray(5) // int array of size 5, defaulted to 0
    //val nonPrimitiveArray: Array<Int>(5) <-- Illegal

    // Converting primitive array to Array
    val nonPrimitiveArray: Array<Int> = primitiveArray.toTypedArray()

}
