package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            val height = etHeight.text.toString().toDouble()
            val weight = etWeight.text.toString().toDouble()
            var bmi = weight/ (height/100).pow(2.0)
            tvResult.text = "Your BMI is "+bmi.toString()+"kg/m2"
        }
    }
}