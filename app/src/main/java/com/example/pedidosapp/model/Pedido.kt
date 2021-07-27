package com.example.pedidosapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Pedido(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val rut: String,
    val pedido: Int,
    val cantPro: Int,
    val cantEnt: Int,
    val fecha: String,
    val hora: String,
    val detalle: String,
)
