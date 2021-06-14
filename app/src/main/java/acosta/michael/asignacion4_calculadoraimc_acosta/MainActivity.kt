package acosta.michael.asignacion4_calculadoraimc_acosta

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    var value = 0.0
    var category = " "
    var w = 0.0
    var h = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val imc: TextView = findViewById(R.id.imc)
        val range: TextView = findViewById(R.id.range)
        val calculate: Button = findViewById(R.id.calculate)

        imc.visibility = View.INVISIBLE
        range.visibility = View.INVISIBLE

        calculate.setOnClickListener {

            h = parsee(height)
            w = parsee(weight)

            if (h != 1.0 || w != 1.0) {
                value = (w / (h * h))

                if (value < 18.5){
                    category = "Underweight"
                    range.setBackgroundResource(R.color.colorGreenish)
                } else if (value >= 18.5 && value < 25){
                    category = "Healthy weight"
                    range.setBackgroundResource(R.color.colorGreen)
                } else if (value >= 25 && value < 30){
                    category = "Overweight"
                    range.setBackgroundResource(R.color.colorYellow)
                } else if (value >= 30 && value < 35){
                    category = "moderately obesity"
                    range.setBackgroundResource(R.color.colorOrange)
                    range.setTextColor(Color.WHITE)
                } else if (value >= 35 && value < 40){
                    category = "Severely obesity"
                    range.setBackgroundResource(R.color.colorRed)
                    range.setTextColor(Color.WHITE)
                } else {
                    category = "morbid obesity"
                    range.setBackgroundResource(R.color.colorBrown)
                    range.setTextColor(Color.WHITE)
                }

                imc.setText(String.format("%s %.2f","IMC: ",value))
                range.setText(category)

                imc.visibility = View.VISIBLE
                range.visibility = View.VISIBLE
            } else {
                imc.visibility = View.VISIBLE
                imc.setText("Please don´t leave box without data")
            }

        }

    }

    fun parsee(s: EditText): Double {
        if (s.text.toString() == "") {
            return 1.0
        } else {
            return s.text.toString().toDouble()
        }
    }

}