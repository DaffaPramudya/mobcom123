//package com.example.basicscodelab
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
//
//// CalculatorScreen.kt
//@Composable
//fun CalculatorScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Display
//        Text(
//            text = "0",
//            fontSize = 32.sp,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp)
//                .background(Color(0xFFEEEEEE))
//                .padding(16.dp),
//            textAlign = TextAlign.End
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            // 🔹 Kolom kiri (angka, titik, +/−)
//            Column(
//                modifier = Modifier.weight(3f),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("%", Modifier.weight(1f))
//                    CalculatorButton("÷", Modifier.weight(1f))
//                    CalculatorButton("×", Modifier.weight(1f))
//                    CalculatorButton("-", Modifier.weight(1f))
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("7", Modifier.weight(1f))
//                    CalculatorButton("8", Modifier.weight(1f))
//                    CalculatorButton("9", Modifier.weight(1f))
//                    CalculatorButton("+", Modifier.weight(1f))
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("4", Modifier.weight(1f))
//                    CalculatorButton("5", Modifier.weight(1f))
//                    CalculatorButton("6", Modifier.weight(1f))
//                    CalculatorButton("(", Modifier.weight(1f))
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("1", Modifier.weight(1f))
//                    CalculatorButton("2", Modifier.weight(1f))
//                    CalculatorButton("3", Modifier.weight(1f))
//                    CalculatorButton(")", Modifier.weight(1f))
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton(".", Modifier.weight(1f)) // 0 dibuat lebar 2x
//                    CalculatorButton("0", Modifier.weight(1f))
//                    CalculatorButton("+/−", Modifier.weight(1.5f))
//                }
//            }
//
//            // 🔹 Kolom kanan (fungsi khusus & "=" besar)
//            Column(
//                modifier = Modifier.weight(1f),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                CalculatorButton("C", Modifier.fillMaxWidth())
//                CalculatorButton("AC", Modifier.fillMaxWidth())
//                CalculatorButton(
//                    "=", Modifier
//                        .fillMaxWidth()
//                        .height(195.dp) // penuh 2 baris
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun CalculatorButton(label: String, modifier: Modifier = Modifier) {
//    Button(
//        onClick = { /* TODO: action */ },
//        modifier = modifier
//            .height(60.dp),
//        shape = RoundedCornerShape(12.dp),
//        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
//    ) {
//        Text(text = label, fontSize = 20.sp, color = Color.Black)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CalculatorPreview() {
//    CalculatorScreen()
//}
//
//
//
