package com.example.secuencial20

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val resistencia = 4.0 // Resistencia fija en 4 ohmios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener las vistas
        val inputVoltage = findViewById<EditText>(R.id.input_voltage)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)
        val txtResult = findViewById<TextView>(R.id.txt_result)

        // Configurar el botón de calcular
        btnCalculate.setOnClickListener {
            val voltageStr = inputVoltage.text.toString()

            // Validar que el voltaje no esté vacío
            if (voltageStr.isNotEmpty()) {
                val voltage = voltageStr.toDouble()

                // Calcular la corriente usando I = V / R
                val corriente = voltage / resistencia

                // Calcular la potencia usando P = V * I
                val potencia = voltage * corriente

                // Mostrar el resultado
                txtResult.text = "Potencia: $potencia W"
            } else {
                // Mostrar error si no se ingresó voltaje
                txtResult.text = "Por favor ingrese un voltaje válido."
            }
        }
    }
}
