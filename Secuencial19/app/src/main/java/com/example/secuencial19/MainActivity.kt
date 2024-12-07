package com.example.secuencial19


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val OTROS_GASTOS_DIARIOS = 100.0  // Otros gastos $100 por día

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Método para calcular el monto total del cheque
    fun calcularCheque(view: View) {
        // Obtén las referencias de los EditText y TextView
        val etCostoHotel = findViewById<EditText>(R.id.etCostoHotel)
        val etCostoComida = findViewById<EditText>(R.id.etCostoComida)
        val etDias = findViewById<EditText>(R.id.etDias)
        val tvDesglose = findViewById<TextView>(R.id.tvDesglose)

        // Obtén los valores introducidos por el usuario
        val costoHotelText = etCostoHotel.text.toString()
        val costoComidaText = etCostoComida.text.toString()
        val diasText = etDias.text.toString()

        // Verifica que los campos no estén vacíos
        if (costoHotelText.isNotEmpty() && costoComidaText.isNotEmpty() && diasText.isNotEmpty()) {
            try {
                // Convierte los textos a valores numéricos
                val costoHotel = costoHotelText.toDouble()
                val costoComida = costoComidaText.toDouble()
                val dias = diasText.toInt()

                // Verifica que los valores sean válidos
                if (costoHotel >= 0 && costoComida >= 0 && dias > 0) {
                    // Calcula los costos totales
                    val totalHotel = costoHotel * dias
                    val totalComida = costoComida * dias
                    val totalOtrosGastos = OTROS_GASTOS_DIARIOS * dias
                    val totalCheque = totalHotel + totalComida + totalOtrosGastos

                    // Muestra el desglose del monto
                    tvDesglose.text = """
                        Desglose del Monto:
                        - Hotel: $${String.format("%.2f", totalHotel)}
                        - Comida: $${String.format("%.2f", totalComida)}
                        - Otros Gastos: $${String.format("%.2f", totalOtrosGastos)}
                        - Total del Cheque: $${String.format("%.2f", totalCheque)}
                    """.trimIndent()
                } else {
                    Toast.makeText(this, "Los valores deben ser mayores o iguales a cero", Toast.LENGTH_LONG).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, ingrese valores válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_LONG).show()
        }
    }
}
