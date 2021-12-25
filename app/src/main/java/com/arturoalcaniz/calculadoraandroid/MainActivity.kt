package com.arturoalcaniz.calculadoraandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var btnSum: Button by Delegates.notNull()
    private var btnSplit: Button by Delegates.notNull()
    private var btnMul: Button by Delegates.notNull()
    private var btnSub: Button by Delegates.notNull()
    private var textOperations: TextView by Delegates.notNull()
    private var textNumber1: EditText by Delegates.notNull()
    private var textNumber2: EditText by Delegates.notNull()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSum = findViewById(R.id.buttonSum)
        btnSplit = findViewById(R.id.buttonSplit)
        btnMul = findViewById(R.id.buttonMult)
        btnSub = findViewById(R.id.buttonSub)
        textOperations = findViewById(R.id.textOperations)
        textNumber1 = findViewById(R.id.textNumber1)
        textNumber2 = findViewById(R.id.textNumber2)

        btnSum.setOnClickListener {
            try {
                this.textOperations.text = sum(
                    textNumber1.text.toString().toDouble(), textNumber2.text.toString().toDouble()
                ).toString()
            }catch (e: NumberFormatException) {
                basicAlert()
            }
        }

        btnSub.setOnClickListener {
            try {
                this.textOperations.text = sub(
                    textNumber1.text.toString().toDouble(), textNumber2.text.toString().toDouble()
                ).toString()
            }catch (e: NumberFormatException) {
                basicAlert()
            }
        }

        btnMul.setOnClickListener {
            try {
                this.textOperations.text = mul(
                    textNumber1.text.toString().toDouble(), textNumber2.text.toString().toDouble()
                ).toString()
            }catch (e: NumberFormatException) {
                basicAlert()
            }
        }

        btnSplit.setOnClickListener {
            try {
                this.textOperations.text = split(
                    textNumber1.text.toString().toDouble(), textNumber2.text.toString().toDouble()
                ).toString()
            }catch (e: NumberFormatException) {
                basicAlert()
            }
        }

    }

    private fun basicAlert(){

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Accion no permitida")
            setMessage("Formato de los campos numericos incorrecto")
            show()
            setCancelable(true)
        }


    }

    private fun sum(number1: Double, number2: Double): Double {
        return number1+number2
    }

    private fun sub(number1: Double, number2: Double): Double {
        return number1-number2
    }

    private fun split(number1: Double, number2: Double): Double {
        return number1/number2
    }

    private fun mul(number1: Double, number2: Double): Double {
        return number1*number2
    }
}