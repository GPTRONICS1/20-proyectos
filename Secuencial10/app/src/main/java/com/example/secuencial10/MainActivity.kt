package com.example.secuencial10


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular la edad
    fun calcularEdad(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etAnioNacimiento = findViewById<EditText>(R.id.etAnioNacimiento)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén el año de nacimiento introducido por el usuario
        val anioNacimientoText = etAnioNacimiento.text.toString()

        // Verifica que el campo no esté vacío
        if (anioNacimientoText.isNotEmpty()) {
            try {
                // Convierte el texto a un número
                val anioNacimiento = anioNacimientoText.toInt()

                // Obtén el año actual
                val anioActual = Calendar.getInstance().get(Calendar.YEAR)

                // Calcula la edad
                val edad = anioActual - anioNacimiento

                // Muestra el resultado
                tvResultado.text = "Edad: $edad años"
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un año válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo", Toast.LENGTH_LONG).show()
        }
    }
}
