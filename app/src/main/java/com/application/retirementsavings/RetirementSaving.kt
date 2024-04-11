package com.application.retirementsavings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RetirementSaving : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retirement_saving)

        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        val bundle : Bundle? = intent.extras

        val salary = bundle?.getDouble("salary")
        val yearsOfSaving = bundle?.getInt("yearsOfSaving")
        val name = bundle?.getString("name")
        val surname = bundle?.getString("surname")
        val age = bundle?.getInt("age")
        val userGender = bundle?.getBoolean("gender")

        // calculate the savings amount
        var total = 0.0
        var yearTotal: Double
        var gender:String

        if(!userGender.toString().toBoolean()){
            gender = "Mr."
        } else {
            gender = "Mrs."
        }

        var count = 1
        var message = "Hi $gender ${surname.toString()}\nHere is the progression of your savings:\n"
        while(count <= yearsOfSaving.toString().toInt()){
            if(count % 2 == 0){
                yearTotal = salary.toString().toDouble() * 0.075
            } else {
                yearTotal = salary.toString().toDouble() * 0.0775
            }

            total += yearTotal
            message += "Year ${count}: R${yearTotal}\n"
            count++
        }

        // display the total
        message += "\nYour total is R${total}"
        tvOutput.text = message



    }
}