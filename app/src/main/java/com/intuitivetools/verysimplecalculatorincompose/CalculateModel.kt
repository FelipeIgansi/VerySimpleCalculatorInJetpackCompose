package com.intuitivetools.verysimplecalculatorincompose

class CalculatorModel {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        if (b == 0) {
            throw ArithmeticException("Division by zero is not allowed")
        }
        return a / b
    }
}
