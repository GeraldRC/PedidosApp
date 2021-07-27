package com.example.pedidosapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.pedidosapp.model.Pedido
import com.example.pedidosapp.model.PedidoImages


@Dao
interface PedidoDao {

    @Transaction
    @Query("SELECT * FROM Pedido")
    fun getAll(): List<PedidoImages>

    @Transaction
    @Query("SELECT * FROM PEDIDO WHERE PEDIDO.pedidoId = :id")
    fun getPedidoById(id: Int): PedidoImages

    @Insert
    fun insert(pedido: Pedido)


}