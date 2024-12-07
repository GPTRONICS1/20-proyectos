package com.example.secuencial12

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

    // Método para calcular el presupuesto
    fun calcularPresupuesto(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etArea = findViewById<EditText>(R.id.etArea)
        val etTarifa = findViewById<EditText>(R.id.etTarifa)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val areaText = etArea.text.toString()
        val tarifaText = etTarifa.text.toString()

        // Verifica que los campos no estén vacíos
        if (areaText.isNotEmpty() && tarifaText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val area = areaText.toDouble()
                val tarifa = tarifaText.toDouble()

                // Calcula el presupuesto total
                val presupuestoTotal = area * tarifa

                // Muestra el resultado
                tvResultado.text = "Presupuesto: $presupuestoTotal"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
