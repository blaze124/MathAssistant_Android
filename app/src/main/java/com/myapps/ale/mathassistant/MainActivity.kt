package com.myapps.ale.mathassistant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spnOperation.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.spnOppElements))

        btnCalculate.setOnClickListener() {
            calculate()
        }
    }

    fun calculate () {
        var op1 = txtOp1.text.toString().toFloatOrNull()
        var op2 = txtOp2.text.toString().toFloatOrNull()
        var res = txtRes.text.toString().toFloatOrNull()

        var opValue = resources.getStringArray(R.array.spnOppValues)[spnOperation.selectedItemPosition]

        if(op1 == null)
            op1 = Float.MIN_VALUE

        if(op2 == null)
            op2 = Float.MIN_VALUE

        if(res == null)
            res = Float.MIN_VALUE

        var isOk = resultCheck(op1 , op2, res, opValue)

        Toast.makeText(this, if (isOk) "OK" else "NOK", Toast.LENGTH_SHORT).show()
    }

    fun resultCheck(op1: Float, op2: Float, op3: Float, ope: String): Boolean {
        var res = false
        when (ope){
            "+" -> res = (op1 + op2 == op3)
            "-" -> res = (op1 - op2 == op3)
            "*" -> res = (op1 * op2 == op3)
            "/" -> res = (op1 / op2 == op3)
        }
        return res
    }
}
