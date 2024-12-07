package com.example.secuancial02
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el área de la circunferencia, asociado al botón mediante onClick en el XML
    fun calcularArea(view: View) {
        // Obtén la referencia del EditText para el radio
        val etRadio = findViewById<EditText>(R.id.etRadio)

        // Convierte el valor del EditText a número
        val radioText = etRadio.text.toString()

        if (radioText.isNotEmpty()) {
            try {
                val radio = radioText.toDouble()

                // Definimos el valor de PI
                val PI = 3.1416

                // Calcula el área de la circunferencia
                val area = PI * radio.pow(2)

                // Muestra el resultado
                Toast.makeText(this, "El área de la circunferencia es: $area", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un valor numérico válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo del radio", Toast.LENGTH_LONG).show()
        }
    }
}
