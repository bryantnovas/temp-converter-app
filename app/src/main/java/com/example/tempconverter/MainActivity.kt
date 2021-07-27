package com.example.tempconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertButton: Button = findViewById(R.id.convert)
        val resetButton: Button = findViewById(R.id.reset)
        val celciusInput: EditText = findViewById(R.id.celcius)
        val farenheitInput: EditText = findViewById(R.id.farenheit)

        convertButton.setOnClickListener {
            val currentlyFocused: String = resources.getResourceEntryName(currentFocus!!.id);
            if(currentlyFocused == "celcius" ){
               var calc = toFarenheit(celciusInput.text.toString())
                farenheitInput.setText(calc)
            }
            else if(currentlyFocused == "farenheit"){
                var calc = toCelcius(farenheitInput.text.toString())
                celciusInput.setText(calc)
            }
        }

        resetButton.setOnClickListener{
            celciusInput.setText("")
            farenheitInput.setText("")
        }
    }

    private fun toCelcius(txt: String): String {
        return if(txt != "") {
            val input = txt.toFloat()
            val result = (input - 32) * .5556f
            result.toString()
        } else {
            ""
        }
    }

    private fun toFarenheit(txt: String): String {
        return if(txt != "") {
            val input = txt.toFloat()
            val result: Float = (input * 1.8f) + 32
            result.toString()
        } else {
            ""
        }
    }


}