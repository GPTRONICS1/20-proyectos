package com.example.secuencial09

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el costo del agua
    fun calcularCosto(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etLargo = findViewById<EditText>(R.id.etLargo)
        val etAncho = findViewById<EditText>(R.id.etAncho)
        val etProfundidad = findViewById<EditText>(R.id.etProfundidad)
        val etCostoPorMetroCubico = findViewById<EditText>(R.id.etCostoPorMetroCubico)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val largoText = etLargo.text.toString()
        val anchoText = etAncho.text.toString()
        val profundidadText = etProfundidad.text.toString()
        val costoText = etCostoPorMetroCubico.text.toString()

        // Verifica que los campos no estén vacíos
        if (largoText.isNotEmpty() && anchoText.isNotEmpty() && profundidadText.isNotEmpty() && costoText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val largo = largoText.toDouble()
                val ancho = anchoText.toDouble()
                val profundidad = profundidadText.toDouble()
                val costoPorMetroCubico = costoText.toDouble()

                // Calcula el volumen de la alberca (en metros cúbicos)
                val volumen = largo * ancho * profundidad

                // Calcula el costo total
                val costoTotal = volumen * costoPorMetroCubico

                // Muestra el resultado
                tvResultado.text = "Costo Total: $%.2f".format(costoTotal)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
