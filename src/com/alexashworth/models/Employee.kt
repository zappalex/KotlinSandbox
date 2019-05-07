package com.alexashworth.models

class Employee (var name: String, val id: Int) {

    // Must be overridden to use "=="
    override fun equals(other: Any?): Boolean {
        if ( other is Employee) {
            return name == other.name
        }
        return false
    }

    // Below uses String template to sub values without concat or format
    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }


}