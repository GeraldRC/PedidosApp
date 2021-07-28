package com.example.pedidosapp.repo

import androidx.annotation.WorkerThread
import com.example.pedidosapp.dao.PedidoDao
import com.example.pedidosapp.model.Pedido
import com.example.pedidosapp.model.PedidoImages
import kotlinx.coroutines.flow.Flow

class PedidoRepository(private val pedidoDao: PedidoDao){

    val allPedidos: Flow<List<PedidoImages>> = pedidoDao.getAll()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(pedido: Pedido){
        pedidoDao.insert(pedido)
    }

}