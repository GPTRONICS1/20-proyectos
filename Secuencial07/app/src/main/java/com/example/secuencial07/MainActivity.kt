package com.example.secuencial07

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

    // Método para calcular el sueldo semanal
    fun calcularSueldoSemanal(view: View) {
        // Obtén las referencias de los EditText
        val etHorasTrabajadas = findViewById<EditText>(R.id.etHorasTrabajadas)
        val etPagoPorHora = findViewById<EditText>(R.id.etPagoHora)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario y conviértelos a números
        val horasTrabajadasText = etHorasTrabajadas.text.toString()
        val pagoPorHoraText = etPagoPorHora.text.toString()

        if (horasTrabajadasText.isNotEmpty() && pagoPorHoraText.isNotEmpty()) {
            try {
                val horasTrabajadas = horasTrabajadasText.toDouble()
                val pagoPorHora = pagoPorHoraText.toDouble()

                // Calcula el sueldo semanal
                val sueldoSemanal = horasTrabajadas * pagoPorHora

                // Muestra el resultado
                tvResultado.text = "Sueldo Semanal: $sueldoSemanal"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores numéricos válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
