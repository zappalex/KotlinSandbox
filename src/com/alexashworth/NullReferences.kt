package com.alexashworth

fun main(args: Array<String>) {

    // To assign null, we must explicitly state the type, and include the ? specifying that the variable is nullable
    val nullStr: String? = null

    // Even if we have something that is nullable, and we know it wont be null, kotlin still will not compile
    val nullStr2: String? = "Definitely not null this time"
    // When trying to use the nullable string, many utility methods simply will not be available to us, as below.
    //nullStr2.toUpperCase() <- won't work.

    // In order to use these methods, we must first check for null.  The compiler will sense this and allow use.
    // Method 1
    if (nullStr2 != null) {
        nullStr2.toUpperCase();
    }

    // Method 2 w/ Safe Call Operator ( preferred )
    nullStr2?.toUpperCase()
    println("nullStr2 evaultates to : $nullStr2")


    // Chaining Safety operators = we can avoid lengthy null checks when chaining this way
    //val countryCode: String? = bankBranch?.address?.country?.countryCode

    // We can DEFAULT our value when the expression evaluates to null -> "Elvis Operator" - notice how we do not use operator on defaultedString
    val defaultedStr = nullStr ?: "This is the default text if nullStr is null"
    println("defaultedStr evaluates to : $defaultedStr")

    /* We can also use the "safe cast operator" to make sure we are casting correctly.  If
        we use this and it returns a null, we must use the safety operator on the variable going forward.
     */
    val testArray: Any = arrayOf(1, 2, 3, 4)
    val nullStr3 = testArray as? String
    println("nullStr3 evaluates to : ${nullStr3?.toUpperCase()}")

    /*
    Not Null Assertion
    If we have a value that uses the safety operator, but we know for a fact that it will not be null,
    we can use the not null assertion.  We may use this because we are sure, or we can use it to force
    an exception to be thrown if a certain variable is null.  If we use the non null assertion, we will
    no longer need the safety operator when using the variable.
     */
    val possiblyNullStr: String? = null
    val nonNullStr = possiblyNullStr!!
    // This will throw an exception
    println(nonNullStr)

    /*
    Passing nullable type to not null function
    Show below is the brute force approach with the !! (not recommended)
    Followed by best practice using the let command, because we need to check if null before executing.
     */
    printText(possiblyNullStr!!)
    //if string is not null, execute expression.  expression is a lambda and "it" refers to the variable that may be null.
    possiblyNullStr?.let { printText(it) }

    // Null compared with Not Null - the structural equals operator is safe here, and we can check null against not null
    if (defaultedStr == nullStr) {
        // do something
    }

    // Nulls with arrays
    // When using primitive arrays, the entire array is initialized to that value, there is no danger of it containing nulls.
    // Here we create an array of nullable ints
    val nullableInts = arrayOfNulls<Int>(6)


}

fun printText( text: String) {
    println(text)
}