package com.example.pedidosapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pedidosapp.dao.PedidoDao
import com.example.pedidosapp.model.Images
import com.example.pedidosapp.model.Pedido

@Database(
    entities = [Pedido::class, Images::class],
    version = 1,
    exportSchema = false
)
 abstract class PedidoDb: RoomDatabase() {

     abstract fun pedidoDao(): PedidoDao
}