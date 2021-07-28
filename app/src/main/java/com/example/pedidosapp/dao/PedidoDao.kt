package com.example.pedidosapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.pedidosapp.model.Pedido
import com.example.pedidosapp.model.PedidoImages
import kotlinx.coroutines.flow.Flow


@Dao
interface PedidoDao {

    @Transaction
    @Query("SELECT * FROM Pedido")
    fun getAll(): Flow<List<PedidoImages>>

    @Transaction
    @Query("SELECT * FROM PEDIDO WHERE PEDIDO.pedidoId = :id")
    suspend fun getPedidoById(id: Int): PedidoImages

    @Insert
    suspend fun insert(pedido: Pedido)


}