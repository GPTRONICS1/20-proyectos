package com.example.secuencial08


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

    // Método para calcular las pulgadas a partir de los metros
    fun calcularPulgadas(view: View) {
        // Obtén la referencia del EditText para los metros
        val etMetros = findViewById<EditText>(R.id.etMetros)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Obtén el valor introducido por el usuario y conviértelo a número
        val metrosText = etMetros.text.toString()

        if (metrosText.isNotEmpty()) {
            try {
                val metros = metrosText.toDouble()

                // Calcula la cantidad de pulgadas
                val pulgadas = metros / 0.0254

                // Muestra el resultado
                tvResultado.text = "Pulgadas: %.2f".format(pulgadas)
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un valor numérico válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo de metros", Toast.LENGTH_LONG).show()
        }
    }
}
