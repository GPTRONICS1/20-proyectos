package com.example.secuencial03

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import com.example.secuencial03.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el área de la figura compuesta
    fun calcularArea(view: View) {
        // Obtén las referencias de los EditText
        val etA = findViewById<EditText>(R.id.etA)
        val etB = findViewById<EditText>(R.id.etB)
        val etC = findViewById<EditText>(R.id.etC)

        // Convierte los valores de los EditText a números
        val aText = etA.text.toString()
        val bText = etB.text.toString()
        val cText = etC.text.toString()

        if (aText.isNotEmpty() && bText.isNotEmpty() && cText.isNotEmpty()) {
            try {
                val a = aText.toDouble()
                val b = bText.toDouble()
                val c = cText.toDouble()

                // Calcula el área del triángulo (base B y altura A - C)
                val areaTriangulo = (b * (a - c)) / 2

                // Calcula el área del rectángulo (base B y altura C)
                val areaRectangulo = b * c

                // Calcula el área total
                val areaTotal = areaTriangulo + areaRectangulo

                // Muestra el resultado
                Toast.makeText(this, "El área total es: $areaTotal", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
