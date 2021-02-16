package com.example.additioncalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.add_button).setOnClickListener { addNumbers(it) }
    }

    private fun addNumbers(view: View) {
        Log.i("ADDITION", getString(R.string.LOG_ADD_BUTTON_CLICK))

        val editFirstNumber = findViewById<EditText>(R.id.first_number_edit)
        val editSecondNumber = findViewById<EditText>(R.id.second_number_edit)
        val resultTextView = findViewById<TextView>(R.id.result_text)

        try {
            if (editFirstNumber.text.isNotEmpty() && editSecondNumber.text.isNotEmpty()) {
                val firstNumber: Int = editFirstNumber.text.toString().toInt()
                val secondNumber: Int = editSecondNumber.text.toString().toInt()
                val sum: Int = firstNumber + secondNumber
                resultTextView.text = "The sum is " + sum + "."
                Log.i("ADDITION", resultTextView.text.toString())
                resultTextView.visibility = View.VISIBLE
            } else {
                Log.i("ADDITION", getString(R.string.LOG_ADD_NUMBER_FIELDS_EMPTY))
                Toast.makeText(this, getString(R.string.TOAST_ADD_NUMBER_FIELDS_EMPTY), Toast.LENGTH_SHORT).show()
            }
        } catch (e: NumberFormatException) { // Handle number format exception
            Log.i("ADDITION", getString(R.string.LOG_ADD_NUMBER_OUT_OF_RANGE))
            Toast.makeText(this, getString(R.string.TOAST_ADD_NUMBER_OUT_OF_RANGE), Toast.LENGTH_SHORT).show()
        }

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}