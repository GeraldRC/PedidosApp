package com.example.pedidosapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pedidosapp.dao.PedidoDao
import com.example.pedidosapp.model.Images
import com.example.pedidosapp.model.Pedido

@Database(
    entities = [Pedido::class, Images::class],
    version = 1,
    exportSchema = false
)
abstract class PedidoDb : RoomDatabase() {

    abstract fun pedidoDao(): PedidoDao

    companion object {

        @Volatile
        private var INSTANCE: PedidoDb? = null

        fun getDatabase(context: Context): PedidoDb {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PedidoDb::class.java,
                    "pedidos"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}