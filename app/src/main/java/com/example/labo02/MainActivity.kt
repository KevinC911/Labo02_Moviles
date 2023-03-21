package com.example.labo02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var bmiText: TextView
    private lateinit var statusText: TextView
    private lateinit var rangeText: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
        onClickListeners()
    }

    private fun bind(){
        weightEdit = findViewById(R.id.weight_edittxt)
        heightEdit = findViewById(R.id.height_edittxt)
        bmiText = findViewById(R.id.BMI_text)
        statusText = findViewById(R.id.status_text)
        rangeText = findViewById(R.id.range_text)
        calculateButton = findViewById(R.id.calculate_action)
    }

    private fun onClickListeners(){
        calculateButton.setOnClickListener {
            val weight = weightEdit.text.toString()
            var height = heightEdit.text.toString()
            var total = weight.toDouble() / (height.toDouble()*height.toDouble())
            if (height != "" && weight != "") {
                bmiText.text = total.toString()
            }
            else bmiText.text = "Some data is missing"
        }
    }
}