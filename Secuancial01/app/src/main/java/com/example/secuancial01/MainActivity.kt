package com.example.secuancial01

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el área del rectángulo, asociado al botón mediante onClick en el XML
    fun calcularArea(view: View) {
        // Obtén las referencias de los EditText
        val etBase = findViewById<EditText>(R.id.etBase)
        val etAltura = findViewById<EditText>(R.id.etAltura)

        // Convierte los valores de los EditText a números
        val baseText = etBase.text.toString()
        val alturaText = etAltura.text.toString()

        if (baseText.isNotEmpty() && alturaText.isNotEmpty()) {
            try {
                val base = baseText.toDouble()
                val altura = alturaText.toDouble()

                // Calcula el área del rectángulo
                val area = base * altura

                // Muestra el resultado
                Toast.makeText(this, "El área es: $area", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, "Por favor, complete ambos campos", Toast.LENGTH_LONG).show()
        }
    }
}
