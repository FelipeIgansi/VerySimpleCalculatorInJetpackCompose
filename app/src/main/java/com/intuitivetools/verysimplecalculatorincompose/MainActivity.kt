package com.intuitivetools.verysimplecalculatorincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.intuitivetools.verysimplecalculatorincompose.ui.theme.VerySimpleCalculatorInComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var calculateModel: CalculatorModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerySimpleCalculatorInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    callPreview()
                    calculateModel = CalculatorModel()
                }
            }
        }
    }
}

private const val add = "+"
private const val subtraction = "-"
private const val mutiply = "x"
private const val divide = "/"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(viewModel: CalculatorViewModel) {

    val keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
        keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = viewModel.firstNumber,
                onValueChange = { value ->
                    viewModel.firstNumber = value
                },
                label = { Text("Primeiro valor") },
                keyboardOptions = keyboardOptions,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        if (viewModel.btnCalculateStatus) viewModel.btnCalculateStatus = false
                        viewModel.setaOperacao(add)
                    },
                    modifier = Modifier.width(80.dp),
                    enabled = viewModel.btnCalculateStatus
                ) {
                    Text(add)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (viewModel.btnCalculateStatus) viewModel.btnCalculateStatus = false
                        viewModel.setaOperacao(subtraction)
                    },
                    enabled = viewModel.btnCalculateStatus,
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(subtraction)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (viewModel.btnCalculateStatus) viewModel.btnCalculateStatus = false
                        viewModel.setaOperacao(mutiply)
                    },
                    enabled = viewModel.btnCalculateStatus,
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(mutiply)
                }

                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = {
                        if (viewModel.btnCalculateStatus) viewModel.btnCalculateStatus = false
                        viewModel.setaOperacao(divide)
                    },
                    enabled = viewModel.btnCalculateStatus,
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(divide)
                }
            }

            OutlinedTextField(
                value = viewModel.secondNumber,
                onValueChange = { value ->
                    viewModel.secondNumber = value
                },
                label = { Text("Segundo valor") },
                keyboardOptions = keyboardOptions,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Button(
                onClick = {
                    viewModel.realizaCalculo()
                    if (!viewModel.btnCalculateStatus) viewModel.btnCalculateStatus = true
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Text("Soma")
            }
            Text(
                text = "${viewModel.result}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = textModifier(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun textModifier() = Modifier
    .height(55.dp)
    .padding(10.dp)
    .fillMaxWidth()

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VerySimpleCalculatorInComposeTheme {
        callPreview()
    }
}

@Composable
private fun callPreview() {
    Greeting(viewModel = CalculatorViewModel())
}