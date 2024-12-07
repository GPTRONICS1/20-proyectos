package com.example.secuencial17


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val DESCUENTO_PORCENTAJE = 0.20  // 20% de descuento
    private val IVA_PORCENTAJE = 0.15         // 15% de IVA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el precio final
    fun calcularPrecioFinal(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etPrecioArticulo = findViewById<EditText>(R.id.etPrecioArticulo)
        val tvPrecioConDescuento = findViewById<TextView>(R.id.tvPrecioConDescuento)
        val tvPrecioFinal = findViewById<TextView>(R.id.tvPrecioFinal)

        // Obtén el valor introducido por el usuario
        val precioArticuloText = etPrecioArticulo.text.toString()

        // Verifica que el campo no esté vacío
        if (precioArticuloText.isNotEmpty()) {
            try {
                // Convierte el texto a un número
                val precioArticulo = precioArticuloText.toDouble()

                // Verifica que el precio sea mayor o igual a cero
                if (precioArticulo >= 0) {
                    // Calcula el precio con descuento
                    val precioConDescuento = precioArticulo * (1 - DESCUENTO_PORCENTAJE)

                    // Calcula el precio final con IVA
                    val precioFinal = precioConDescuento * (1 + IVA_PORCENTAJE)

                    // Muestra los resultados
                    tvPrecioConDescuento.text = "Precio con Descuento: $${String.format("%.2f", precioConDescuento)}"
                    tvPrecioFinal.text = "Precio Final: $${String.format("%.2f", precioFinal)}"
                } else {
                    Toast.makeText(this, "El precio debe ser mayor o igual a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese un precio válido", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete el campo de precio", Toast.LENGTH_LONG).show()
        }
    }
}
