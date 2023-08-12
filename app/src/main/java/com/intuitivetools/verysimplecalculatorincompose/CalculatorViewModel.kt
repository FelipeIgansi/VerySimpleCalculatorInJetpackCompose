package com.intuitivetools.verysimplecalculatorincompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    var firstNumber by mutableStateOf("")
    var secondNumber by mutableStateOf("")
    var result by mutableStateOf("")
    var btnCalculateStatus by mutableStateOf(true)
    private var qualOperacao by mutableStateOf("")
    private var calculateModel = CalculatorModel()

    fun setaOperacao(operacao:String){
        qualOperacao = operacao
    }

    fun realizaCalculo(){
        when(qualOperacao){
            "+"->{result = calculateModel.add(firstNumber.toInt(), secondNumber.toInt()).toString()}
            "-"->{result = calculateModel.subtract(firstNumber.toInt(), secondNumber.toInt()).toString()}
            "x"->{result = calculateModel.multiply(firstNumber.toInt(), secondNumber.toInt()).toString()}
            "/"->{result = calculateModel.divide(firstNumber.toInt(), secondNumber.toInt()).toString()}
        }
    }
}