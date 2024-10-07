package com.roberto.tiendadepartamental

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    private lateinit var datos: TextView
    private lateinit var objProducto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        datos = findViewById(R.id.txtDatos)
        objProducto = Producto()

        // Obtener los datos del Intent
        intent.extras?.let {
            objProducto = Producto(
                codigo = it.getInt("codigo"),
                descripcion = it.getString("descripcion", "Sin descripción"),
                marca = it.getString("marca", "Sin marca"),
                talla = it.getInt("talla", 0),
                costo = it.getDouble("costo", 0.0),
                cantidad = it.getInt("cantidad", 0)
            )
        }

        // Definir la talla en formato de texto
        val talla = when (objProducto.talla) {
            1 -> "Talla Chica"
            2 -> "Talla Mediana"
            3 -> "Talla Grande"
            else -> "Talla Desconocida"
        }

        // Usar la cadena definida en strings.xml
        datos.text = getString(
            R.string.producto_detalle,
            objProducto.codigo,
            objProducto.descripcion,
            objProducto.marca,
            talla,
            objProducto.costo,
            objProducto.cantidad
        )
    }

    fun regresar(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}
