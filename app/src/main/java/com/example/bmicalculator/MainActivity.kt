package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

lateinit var etHeight: EditText
lateinit var etWeight: EditText
lateinit var btnCalculate: Button
lateinit var tvResult: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            if(etHeight.text.toString().isEmpty() || etWeight.text.toString().isEmpty())
            {
                Toast.makeText(this, "Fill empty parameters", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val height = etHeight.text.toString().toDouble()
                val weight = etWeight.text.toString().toDouble()
                val bmi = weight/ (height/100).pow(2.0)
                //rounding off to 2dp
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.DOWN
                val bmirounded = df.format(bmi)
                tvResult.text = "Your BMI is "+bmirounded.toString()+"kg/m^2"
            }

        }
    }
}