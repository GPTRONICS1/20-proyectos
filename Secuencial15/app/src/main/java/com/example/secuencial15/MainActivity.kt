package com.example.secuencial15

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

    // Método para calcular el costo de la llamada
    fun calcularCosto(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etDuracionLlamada = findViewById<EditText>(R.id.etDuracionLlamada)
        val etCostoPorMinuto = findViewById<EditText>(R.id.etCostoPorMinuto)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val duracionText = etDuracionLlamada.text.toString()
        val costoText = etCostoPorMinuto.text.toString()

        // Verifica que los campos no estén vacíos
        if (duracionText.isNotEmpty() && costoText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val duracion = duracionText.toDouble()
                val costoPorMinuto = costoText.toDouble()

                // Verifica que la duración y el costo sean mayores a cero
                if (duracion >= 0 && costoPorMinuto >= 0) {
                    // Calcula el costo total
                    val costoTotal = duracion * costoPorMinuto

                    // Muestra el resultado
                    tvResultado.text = "Costo: $${String.format("%.2f", costoTotal)}"
                } else {
                    Toast.makeText(this, "La duración y el costo deben ser mayores o iguales a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
