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
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import java.util.Stack
//
//// CalculatorScreen.kt
//@Composable
//fun CalculatorScreen() {
//    var displayText by remember { mutableStateOf("0") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Display
//        Text(
//            text = displayText,
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
//            // 🔹 Kolom kiri
//            Column(
//                modifier = Modifier.weight(3f),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                // 🔹 Bagian fungsi ilmiah
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("sin") { displayText += "sin(" }
//                    CalculatorButton("cos") { displayText += "cos(" }
//                }
//
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("tan") { displayText += "tan(" }
//                    CalculatorButton("ln") { displayText += "ln(" }
//                }
//
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("asin") { displayText += "asin(" }
//                    CalculatorButton("acos") { displayText += "acos(" }
//                }
//
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("atan") { displayText += "atan(" }
//                    CalculatorButton("log") { displayText += "log(" }
//                }
//
//// 🔹 Baris baru untuk fungsi lainnya
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("√x") { displayText += "√(" }
//                    CalculatorButton("x!") { displayText += "!" }
//                }
//
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp)
//                ) {
//                    CalculatorButton("1/x") {
//                        displayText = try {
//                            val value = evaluateExpression(displayText)
//                            (1 / value).toString()
//                        } catch (e: Exception) {
//                            "Error"
//                        }
//                    }
//                    CalculatorButton("xʸ") { displayText += "^" }
//                }
//
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("%") { displayText += "%" }
//                    CalculatorButton("÷") { displayText += "÷" }
//                    CalculatorButton("×") { displayText += "×" }
//                    CalculatorButton("-") { displayText += "-" }
//                }
//
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("7") { displayText = appendNumber(displayText, "7") }
//                    CalculatorButton("8") { displayText = appendNumber(displayText, "8") }
//                    CalculatorButton("9") { displayText = appendNumber(displayText, "9") }
//                    CalculatorButton("+") { displayText += "+" }
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("4") { displayText = appendNumber(displayText, "4") }
//                    CalculatorButton("5") { displayText = appendNumber(displayText, "5") }
//                    CalculatorButton("6") { displayText = appendNumber(displayText, "6") }
//                    CalculatorButton("(") { displayText += "(" }
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("1") { displayText = appendNumber(displayText, "1") }
//                    CalculatorButton("2") { displayText = appendNumber(displayText, "2") }
//                    CalculatorButton("3") { displayText = appendNumber(displayText, "3") }
//                    CalculatorButton(")") { displayText += ")" }
//                }
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//                    CalculatorButton("0", Modifier.weight(2f)) { displayText = appendNumber(displayText, "0") }
//                    CalculatorButton(".") { displayText += "." }
//                    CalculatorButton("+/−") {
//                        displayText = if (displayText.startsWith("-")) {
//                            displayText.removePrefix("-")
//                        } else {
//                            "-$displayText"
//                        }
//                    }
//                }
//            }
//
//            // 🔹 Kolom kanan
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxHeight(),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                CalculatorButton("C", Modifier.fillMaxWidth()) {
//                    if (displayText.isNotEmpty()) {
//                        displayText = displayText.dropLast(1)
//                        if (displayText.isEmpty()) displayText = "0"
//                    }
//                }
//                CalculatorButton("AC", Modifier.fillMaxWidth()) {
//                    displayText = "0"
//                }
//                CalculatorButton("=", Modifier
//                    .fillMaxWidth()
//                    .height(195.dp)
//                ) {
//                    displayText = try {
//                        val result = evaluateExpression(displayText)
//                        result.toString()
//                    } catch (e: Exception) {
//                        "Error"
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun CalculatorButton(
//    label: String,
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit
//) {
//    Button(
//        onClick = onClick,
//        modifier = modifier.height(60.dp),
//        shape = RoundedCornerShape(12.dp),
//        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
//    ) {
//        Text(text = label, fontSize = 20.sp, color = Color.Black)
//    }
//}
//
//fun appendNumber(current: String, number: String): String {
//    return if (current == "0") number else current + number
//}
//
//fun evaluateExpression(expr: String): Double {
//    val tokens = tokenize(expr)
//    val rpn = infixToPostfix(tokens)
//    return evalPostfix(rpn)
//}
//
//fun tokenize(expr: String): List<String> {
//    val tokens = mutableListOf<String>()
//    var current = ""
//
//    var i = 0
//    while (i < expr.length) {
//        val c = expr[i]
//
//        // Angka atau titik
//        if (c.isDigit() || c == '.') {
//            current += c
//        }
//        // Huruf untuk fungsi
//        else if (c.isLetter()) {
//            if (current.isNotEmpty() && current.last().isLetter()) {
//                current += c
//            } else {
//                if (current.isNotEmpty()) {
//                    tokens.add(current)
//                    current = ""
//                }
//                current += c
//            }
//        }
//        // Operator dan tanda kurung
//        else {
//            if (current.isNotEmpty()) {
//                tokens.add(current)
//                current = ""
//            }
//            tokens.add(c.toString())
//        }
//        i++
//    }
//    if (current.isNotEmpty()) tokens.add(current)
//
//    return tokens
//}
//
//fun infixToPostfix(tokens: List<String>): List<String> {
//    val output = mutableListOf<String>()
//    val stack = Stack<String>()
//    val precedence = mapOf(
//        "+" to 1, "-" to 1,
//        "×" to 2, "÷" to 2, "%" to 2,
//        "^" to 3,
//        "sin" to 4, "cos" to 4, "tan" to 4,
//        "asin" to 4, "acos" to 4, "atan" to 4,
//        "√" to 4, "ln" to 4, "log" to 4, "!" to 4
//    )
//
//    for (token in tokens) {
//        when {
//            token.toDoubleOrNull() != null -> output.add(token)
//            token.matches(Regex("[a-zA-Z]+")) -> {   // fungsi
//                stack.push(token)
//            }
//            token in precedence.keys -> {
//                while (stack.isNotEmpty() && stack.peek() != "(" &&
//                    precedence[stack.peek()]!! >= precedence[token]!!) {
//                    output.add(stack.pop())
//                }
//                stack.push(token)
//            }
//            token == "(" -> stack.push(token)
//            token == ")" -> {
//                while (stack.isNotEmpty() && stack.peek() != "(") {
//                    output.add(stack.pop())
//                }
//                if (stack.isNotEmpty() && stack.peek() == "(") stack.pop()
//                // jika setelah ) ada fungsi di stack, keluarkan juga
//                if (stack.isNotEmpty() && stack.peek().matches(Regex("[a-zA-Z]+"))) {
//                    output.add(stack.pop())
//                }
//            }
//        }
//    }
//    while (stack.isNotEmpty()) output.add(stack.pop())
//    return output
//}
//
//fun evalPostfix(tokens: List<String>): Double {
//    val stack = Stack<Double>()
//    for (token in tokens) {
//        when {
//            token.toDoubleOrNull() != null -> stack.push(token.toDouble())
//
//            token in listOf("+", "-", "×", "÷", "%", "^") -> {
//                val b = stack.pop()
//                val a = stack.pop()
//                val res = when (token) {
//                    "+" -> a + b
//                    "-" -> a - b
//                    "×" -> a * b
//                    "÷" -> a / b
//                    "%" -> a % b
//                    "^" -> Math.pow(a, b)
//                    else -> 0.0
//                }
//                stack.push(res)
//            }
//
//            token in listOf("sin", "cos", "tan", "asin", "acos", "atan", "ln", "log", "√", "!") -> {
//                val a = stack.pop()
//                val res = when (token) {
//                    "sin" -> Math.sin(Math.toRadians(a))
//                    "cos" -> Math.cos(Math.toRadians(a))
//                    "tan" -> Math.tan(Math.toRadians(a))
//                    "asin" -> Math.toDegrees(Math.asin(a))
//                    "acos" -> Math.toDegrees(Math.acos(a))
//                    "atan" -> Math.toDegrees(Math.atan(a))
//                    "ln" -> Math.log(a)
//                    "log" -> Math.log10(a)
//                    "√" -> Math.sqrt(a)
//                    "!" -> factorial(a.toInt())
//                    else -> 0.0
//                }
//                stack.push(res)
//            }
//        }
//    }
//    return stack.pop()
//}
//
//fun factorial(n: Int): Double {
//    return if (n <= 1) 1.0 else n * factorial(n - 1)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CalculatorPreview() {
//    CalculatorScreen()
//}
//
//
