package com.alexashworth

fun main(args: Array<String>) {

}

class InterfaceTest: MySubInterface {
    override val number:Int = 45

    override fun myFunction(string: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mySubFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


/*
    With interfaces, we dont explicitly need to declare them open, they are open by default.
 */
interface MyInterface {
    // We can have member functions, which will need to be overridden as well
    val number: Int

    // To have a concrete property that is initialized, we must have a get, we cannot directly assign.
    val number2:Int
        get() = 45

    fun myFunction(string: String): String
}

interface MySubInterface : MyInterface {
    fun mySubFunction(num: Int): String

}
