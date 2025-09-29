package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TipCalculator_Step3() }
    }
}

@Composable
fun TipCalculator_Step3() {
    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            var amount by remember { mutableStateOf("") }
            var dishes by remember { mutableStateOf("") }
            var tip by remember { mutableStateOf(0f) }  // 0..25

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

                Spacer(Modifier.height(16.dp))
                Text("Чаевые:")
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Text("0")
                    Slider(
                        value = tip,
                        onValueChange = { tip = it },
                        valueRange = 0f..25f,
                        steps = 24,
                        modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
                    )
                    Text("25")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview_Step3() { TipCalculator_Step3() }
