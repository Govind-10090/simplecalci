package com.example.newcali

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //input fields
        val input1 = findViewById<TextInputEditText>(R.id.input1)
        val input2 = findViewById<TextInputEditText>(R.id.input2)

        //Buttons
        val btnAdd = findViewById<MaterialButton>(R.id.btnAdd)
        val btnSubtract = findViewById<MaterialButton>(R.id.btnSubtract)
        val btnMultiply = findViewById<MaterialButton>(R.id.btnMultiply)
        val btnDivide = findViewById<MaterialButton>(R.id.btnDivide)

        //Result
        val resultText = findViewById<MaterialTextView>(R.id.resultText)

        //Button click Listeners
        btnAdd.setOnClickListener {
            val result = performOperation(input1, input2, "+")
            resultText.text = "Result: $result"
        }

        btnSubtract.setOnClickListener {
            val result = performOperation(input1, input2, "-")
            resultText.text = "Result: $result"
        }

        btnMultiply.setOnClickListener {
            val result = performOperation(input1, input2, "*")
            resultText.text = "Result: $result"
        }

        btnDivide.setOnClickListener {
            val result = performOperation(input1, input2, "/")
            resultText.text = "Result: $result"
        }
    }
    private fun performOperation(input1:TextInputEditText,input2:TextInputEditText,operation:String):String{
        val num1 = input1.text.toString().toDoubleOrNull()
        val num2 = input2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return "Error"
        }
        return when (operation) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "/" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Division by zero is not allowed", Toast.LENGTH_SHORT).show()
                    "Error"
                } else {
                    (num1 / num2).toString()
                }
            }
            else -> "Error"
        }
    }

}




