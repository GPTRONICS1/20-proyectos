package com.example.secuencial16


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

    // Método para calcular el pago
    fun calcularPago(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etMetrosCubicos = findViewById<EditText>(R.id.etMetrosCubicos)
        val etCostoPorMetroCubico = findViewById<EditText>(R.id.etCostoPorMetroCubico)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val metrosCubicosText = etMetrosCubicos.text.toString()
        val costoText = etCostoPorMetroCubico.text.toString()

        // Verifica que los campos no estén vacíos
        if (metrosCubicosText.isNotEmpty() && costoText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val metrosCubicos = metrosCubicosText.toDouble()
                val costoPorMetroCubico = costoText.toDouble()

                // Verifica que los metros cúbicos y el costo sean mayores o iguales a cero
                if (metrosCubicos >= 0 && costoPorMetroCubico >= 0) {
                    // Calcula el pago total
                    val pagoTotal = metrosCubicos * costoPorMetroCubico

                    // Muestra el resultado
                    tvResultado.text = "Pago: $${String.format("%.2f", pagoTotal)}"
                } else {
                    Toast.makeText(this, "Los metros cúbicos y el costo deben ser mayores o iguales a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
