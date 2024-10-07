package com.roberto.tiendadepartamental

data class Producto(
    var codigo: Int = 0,
    var marca: String = "none",
    var descripcion: String = "none",
    var talla: Int = 0, // 1: Talla Chica, 2: Talla Mediana, 3: Talla Grande
    var costo: Double = 0.0,
    var cantidad: Int = 0
)
