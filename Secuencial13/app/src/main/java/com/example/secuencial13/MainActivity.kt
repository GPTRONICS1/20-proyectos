package com.example.secuencial13

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

    // Método para calcular el costo del boleto
    fun calcularCosto(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etKilometros = findViewById<EditText>(R.id.etKilometros)
        val etCostoPorKilometro = findViewById<EditText>(R.id.etCostoPorKilometro)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val kilometrosText = etKilometros.text.toString()
        val costoPorKilometroText = etCostoPorKilometro.text.toString()

        // Verifica que los campos no estén vacíos
        if (kilometrosText.isNotEmpty() && costoPorKilometroText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val kilometros = kilometrosText.toDouble()
                val costoPorKilometro = costoPorKilometroText.toDouble()

                // Calcula el costo total del boleto
                val costoTotal = kilometros * costoPorKilometro

                // Muestra el resultado
                tvResultado.text = "Costo del Boleto: $costoTotal"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
