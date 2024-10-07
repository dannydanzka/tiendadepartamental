package com.roberto.tiendadepartamental

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var codigo: EditText
    private lateinit var descripcion: EditText
    private lateinit var costo: EditText
    private lateinit var cantidad: EditText
    private lateinit var marcas: ListView
    private lateinit var tallas: RadioGroup
    private lateinit var objProducto: Producto
    private var marcaSel: String = "Hermes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarComponentes()

        // Arreglo de marcas
        val lstMarcas = listOf("Hermes", "Dior", "Gucci", "Chanel", "Prada")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, lstMarcas)
        marcas.adapter = adaptador

        // Escuchar selección de la lista
        marcas.setOnItemClickListener { parent, _, position, _ ->
            marcaSel = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "Marca: $marcaSel", Toast.LENGTH_LONG).show()
        }
    }

    private fun inicializarComponentes() {
        codigo = findViewById(R.id.edtCodigo)
        descripcion = findViewById(R.id.edtDescripcion)
        costo = findViewById(R.id.edtCosto)
        cantidad = findViewById(R.id.edtCantidad)
        marcas = findViewById(R.id.ltvMarca)
        tallas = findViewById(R.id.rgpTallas)
        objProducto = Producto()
    }

    fun onClick(v: View?) {
        when (v?.id) {
            R.id.ibtnAgregar -> agregar()
            R.id.ibtnMostrar -> mostrar()
            R.id.ibtnLimpiar -> limpiar()
        }
    }

    private fun agregar() {
        if (codigo.text.isNotBlank() && descripcion.text.isNotBlank()) {
            objProducto = Producto(
                codigo = codigo.text.toString().toInt(),
                descripcion = descripcion.text.toString(),
                marca = marcaSel,
                talla = when {
                    findViewById<RadioButton>(R.id.rbtChica).isChecked -> 1
                    findViewById<RadioButton>(R.id.rbtMediana).isChecked -> 2
                    findViewById<RadioButton>(R.id.rbtGrande).isChecked -> 3
                    else -> 0
                },
                costo = costo.text.toString().toDouble(),
                cantidad = cantidad.text.toString().toInt()
            )
            Toast.makeText(this, "Producto registrado.", Toast.LENGTH_LONG).show()
            limpiar()
        } else {
            Toast.makeText(this, "Debe capturar datos.", Toast.LENGTH_LONG).show()
        }
    }

    private fun mostrar() {
        val intent = Intent(this, DetalleActivity::class.java).apply {
            putExtra("codigo", objProducto.codigo)
            putExtra("descripcion", objProducto.descripcion)
            putExtra("marca", objProducto.marca)
            putExtra("talla", objProducto.talla)
            putExtra("costo", objProducto.costo)
            putExtra("cantidad", objProducto.cantidad)
        }
        startActivity(intent)
    }

    private fun limpiar() {
        codigo.text = null
        descripcion.text = null
        costo.text = null
        cantidad.text = null
        tallas.clearCheck()
        codigo.requestFocus()
    }
}
