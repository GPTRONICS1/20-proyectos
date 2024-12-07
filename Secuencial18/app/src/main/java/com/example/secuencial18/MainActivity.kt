package com.example.secuencial18


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val AHORRO_PORCENTAJE = 0.15  // 15% de ahorro
    private val SEMANAS_POR_MES = 4        // 4 semanas por mes
    private val MESES_POR_AÑO = 12         // 12 meses por año

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el ahorro anual
    fun calcularAhorro(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etSueldo = findViewById<EditText>(R.id.etSueldo)
        val tvAhorroAnual = findViewById<TextView>(R.id.tvAhorroAnual)

        // Obtén el valor introducido por el usuario
        val sueldoText = etSueldo.text.toString()

        // Verifica que el campo no esté vacío
        if (sueldoText.isNotEmpty()) {
            try {
                // Convierte el texto a un número
                val sueldo = sueldoText.toDouble()

                // Verifica que el sueldo sea mayor o igual a cero
                if (sueldo >= 0) {
                    // Calcula el ahorro anual
                    val ahorroSemanal = sueldo * AHORRO_PORCENTAJE
                    val ahorroAnual = ahorroSemanal * SEMANAS_POR_MES * MESES_POR_AÑO

                    // Muestra el resultado
                    tvAhorroAnual.text = "Ahorro Anual: $${String.format("%.2f", ahorroAnual)}"
                } else {
                    Toast.makeText(this, "El sueldo debe ser mayor o igual a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un sueldo válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo de sueldo", Toast.LENGTH_LONG).show()
        }
    }
}
