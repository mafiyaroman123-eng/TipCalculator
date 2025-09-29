package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TipCalculator_Step2() }
    }
}

@Composable
fun TipCalculator_Step2() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            var amount by remember { mutableStateOf("") }
            var dishes by remember { mutableStateOf("") }

            Column(Modifier.padding(16.dp)) {
                Text("Сумма заказа:")
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    modifier = Modifier.width(170.dp)
                )

                Spacer(Modifier.height(12.dp))

                Text("Количество блюд:")
                OutlinedTextField(
                    value = dishes,
                    onValueChange = { dishes = it.filter { ch -> ch.isDigit() } },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(110.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview_Step2() { TipCalculator_Step2() }
