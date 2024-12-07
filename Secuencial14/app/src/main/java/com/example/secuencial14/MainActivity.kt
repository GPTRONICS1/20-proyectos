package com.example.secuencial14

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

    // Método para calcular el tiempo de viaje
    fun calcularTiempo(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etDistancia = findViewById<EditText>(R.id.etDistancia)
        val etVelocidad = findViewById<EditText>(R.id.etVelocidad)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén los valores introducidos por el usuario
        val distanciaText = etDistancia.text.toString()
        val velocidadText = etVelocidad.text.toString()

        // Verifica que los campos no estén vacíos
        if (distanciaText.isNotEmpty() && velocidadText.isNotEmpty()) {
            try {
                // Convierte los textos a números
                val distancia = distanciaText.toDouble()
                val velocidad = velocidadText.toDouble()

                // Verifica que la velocidad no sea cero
                if (velocidad > 0) {
                    // Calcula el tiempo en horas
                    val tiempo = distancia / velocidad

                    // Muestra el resultado
                    tvResultado.text = "Tiempo: ${String.format("%.2f", tiempo)} horas"
                } else {
                    Toast.makeText(this, "La velocidad debe ser mayor a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese números válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
