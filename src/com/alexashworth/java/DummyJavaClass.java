package com.alexashworth.java;

public class DummyJavaClass {
    public String isVacationTime( boolean onVacation) {
        return onVacation ? "I'm on vacation" : "I'm working";
    }

    public void printArray ( int[] array) {
        for ( int item : array) {
            System.out.println(item);
        }
    }
}
