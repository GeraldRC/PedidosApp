package com.example.pedidosapp

import android.app.Application
import androidx.room.Room
import com.example.pedidosapp.db.PedidoDb

class PedidoApp: Application() {

    val room: PedidoDb = Room.databaseBuilder(this,PedidoDb::class.java,"pedidos")
        .build()
}