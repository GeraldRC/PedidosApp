package com.example.pedidosapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pedidosapp.model.Pedido


@Dao
interface PedidoDao {

    @Query("SELECT * FROM Pedido")
     fun getAll(): List<Pedido>

    @Insert
     fun insert(pedido: Pedido)


}