package com.example.secuencial11

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    // Tarifa por hora de estacionamiento
    private val tarifaPorHora = 20.0 // Cambia la tarifa según sea necesario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el cobro
    fun calcularCobro(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etHoras = findViewById<EditText>(R.id.etHoras)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén las horas introducidas por el usuario
        val horasText = etHoras.text.toString()

        // Verifica que el campo no esté vacío
        if (horasText.isNotEmpty()) {
            try {
                // Convierte el texto a un número
                val horas = horasText.toDouble()

                // Redondea hacia arriba para fracciones de hora
                val horasCompletas = ceil(horas)

                // Calcula el cobro total
                val cobroTotal = horasCompletas * tarifaPorHora

                // Muestra el resultado
                tvResultado.text = "Cobro: $cobroTotal"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un número válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo", Toast.LENGTH_LONG).show()
        }
    }
}
