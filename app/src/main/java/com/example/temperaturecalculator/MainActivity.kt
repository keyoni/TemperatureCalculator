package com.example.temperaturecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var temperatureConvert = ""
        spOptions.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                temperatureConvert = adapterView?.getItemAtPosition(position).toString()
            }

        }
        btnConvert.setOnClickListener {
            var userTemperature = etTemperature.text.toString().toDouble()
            var finalTemp: Double;
            if(temperatureConvert == "F -> C") {
                finalTemp = ((userTemperature - 32) * (5.0/9.0))
            }else {
                finalTemp = ((userTemperature * (9.0/5.0) + 32))
            }
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            finalTemp = df.format(finalTemp).toDouble()
            tvResult.text = finalTemp.toString()
        }
    }

}