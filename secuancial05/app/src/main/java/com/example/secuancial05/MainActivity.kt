package com.example.secuancial05

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secuancial05.R
import kotlin.math.PI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el área de la figura, asociado al botón mediante onClick en el XML
    fun calcularArea(view: View) {
        // Obtén las referencias de los EditText
        val etH = findViewById<EditText>(R.id.etH) // Hipotenusa
        val etR = findViewById<EditText>(R.id.etR) // Radio y uno de los catetos

        // Convierte los valores de los EditText a números
        val hText = etH.text.toString()
        val rText = etR.text.toString()

        if (hText.isNotEmpty() && rText.isNotEmpty()) {
            try {
                val h = hText.toDouble() // Hipotenusa
                val r = rText.toDouble() // Radio

                // Cálculo de áreas
                val areaTriangulo = 2 * (0.5 * r * Math.sqrt(h * h - r * r)) // Área de dos triángulos rectángulos
                val areaSemicirculo = 0.5 * PI * r * r // Área de la semicircunferencia

                // Área total
                val areaTotal = areaTriangulo + areaSemicirculo

                // Muestra el resultado
                Toast.makeText(this, "El área total es: $areaTotal", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_LONG).show()
        }
    }
}
