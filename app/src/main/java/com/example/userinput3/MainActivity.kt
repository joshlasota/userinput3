package com.example.userinput3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextMealCost = findViewById<EditText>(R.id.editTextMealCost)
        val spinnerTipPercentage = findViewById<Spinner>(R.id.spinnerTipPercentage)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            val mealCostText = editTextMealCost.text.toString()
            if (mealCostText.isNotEmpty()) {
                val mealCost = mealCostText.toDouble()
                val tipPercentage = spinnerTipPercentage.selectedItem.toString().replace("%", "").toDouble()
                val tipAmount = mealCost * (tipPercentage / 100)
                val totalAmount = mealCost + tipAmount

                textViewResult.text = "Tip Amount: \$${String.format("%.2f", tipAmount)}\nTotal Amount: \$${String.format("%.2f", totalAmount)}"
            } else {
                Toast.makeText(this, "Please enter meal cost", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
