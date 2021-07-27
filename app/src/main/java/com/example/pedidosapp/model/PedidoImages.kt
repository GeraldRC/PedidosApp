package com.example.pedidosapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class PedidoImages(
    @Embedded val pedido: Pedido,
    @Relation(
        parentColumn = "pedidoId",
        entityColumn = "pedido"
    )
    val images: List<Images>
)
