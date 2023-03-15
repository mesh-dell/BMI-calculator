package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Comment
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow

lateinit var etHeight: EditText
lateinit var etWeight: EditText
lateinit var btnCalculate: Button
lateinit var tvResult: TextView
lateinit var tvComment: TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)
        tvComment = findViewById(R.id.tvComment)

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

                //generating comments
                if(bmi < 16)
                {
                    tvComment.text = "(Severe Thinness)"
                    tvComment.setTextColor(Color.parseColor("#FD0402"))
                }
                else if(bmi in 16.0..17.0)
                {
                    tvComment.text = "(Moderate Thinness)"
                    tvComment.setTextColor(Color.parseColor("#D3462C"))
                }
                else if(bmi in 17.0..18.5)
                {
                    tvComment.text = "(Mild Thinness)"
                    tvComment.setTextColor(Color.parseColor("#EAA015"))
                }
                else if(bmi in 18.5..25.0)
                {
                    tvComment.text = "(Normal)"
                    tvComment.setTextColor(Color.parseColor("#2EDB41"))
                }
                else if(bmi in 18.5..25.0)
                {
                    tvComment.text = "(Normal)"
                    tvComment.setTextColor(Color.parseColor("#2EDB41"))
                }
                else if(bmi in 25.0..30.0)
                {
                    tvComment.text = "(Overweight)"
                    tvComment.setTextColor(Color.parseColor("#EAA015"))
                }
                else if(bmi in 30.0..35.0)
                {
                    tvComment.text = "(Obese class I)"
                    tvComment.setTextColor(Color.parseColor("#D3462C"))
                }
                else if(bmi in 35.0..40.0)
                {
                    tvComment.text = "(Obese class II)"
                    tvComment.setTextColor(Color.parseColor("#FD0402"))
                }
                else if(bmi > 40)
                {
                    tvComment.text = "(Obese class III)"
                    tvComment.setTextColor(Color.parseColor("#A8000C"))
                }
            }

        }
    }
}