package com.application.retirementsavings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Text variables
        val etName = findViewById<EditText>(R.id.etName).text
        val etSurname = findViewById<EditText>(R.id.etSurname).text
        val etAge = findViewById<EditText>(R.id.etAge).text
        val swGender = findViewById<Switch>(R.id.switchGender)
        val etSalary = findViewById<EditText>(R.id.etSalary).text
        val etYearsOfSaving = findViewById<EditText>(R.id.etYearsOfSaving).text
        val tvResult = findViewById<TextView>(R.id.tvResult)
        // button variables
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val btnClear = findViewById<Button>(R.id.btnClear)

        // clear all fields on the screen
        btnClear.setOnClickListener(){
            etName.clear()
            etSurname.clear()
            etAge.clear()
            etSalary.clear()
            etYearsOfSaving.clear()
        }

        btnGenerate.setOnClickListener(){
            if(etAge.toString().toInt()  > 10 && etAge.toString().toInt() < 20){
                val intent = Intent (this, RetirementSaving::class.java)
                intent.putExtra("name", etName.toString())
                intent.putExtra("surname", etSurname.toString())
                intent.putExtra("age", etAge.toString().toInt())
                intent.putExtra("salary", etSalary.toString().toDouble())
                intent.putExtra("yearsOfSaving", etYearsOfSaving.toString().toInt())
                intent.putExtra("gender", swGender.isChecked.toString().toBoolean())
                startActivity(intent)
            } else {
                tvResult.text = "You have entered ${etYearsOfSaving}, which is not within our range.\nPlease enter a number between 10 and 20! "
            }
        }














    }
}