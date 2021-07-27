package com.example.pedidosapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Images(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val pedido: Int,
    val ruta: String
)
