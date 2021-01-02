package com.example.eyetester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

var randRoll = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randButton:Button = findViewById(R.id.button1)
        val subButton:Button = findViewById(R.id.button2)
        val txtname:EditText = findViewById(R.id.TextNumber)
        randButton.setOnClickListener {
            rollDice()
        }
        subButton.setOnClickListener {
            val name = txtname.text.toString().toInt()
            if (randRoll == name){
                val resultTextView: TextView = findViewById(R.id.finalMessage)
                resultTextView.text = "Your eyesight is perfect!"

            }
            else{
                val resultTextView: TextView = findViewById(R.id.finalMessage)
                resultTextView.text = "Please go see a doctor!"
            }
        }
    }

     fun rollDice() {
        val rand = Rand(50)
        randRoll = rand.rolla()
        val toast = Toast.makeText(this, randRoll.toString(), Toast.LENGTH_SHORT)
        toast.show()
    }
}

class Rand(val num: Int){
    fun rolla():Int{
        return (1..num).random()
    }
}