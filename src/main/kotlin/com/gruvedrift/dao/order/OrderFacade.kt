package com.gruvedrift.dao.order

import com.gruvedrift.models.MiningCart
import com.gruvedrift.models.Order

interface OrderFacade {
    suspend fun createOrder( picks: Int, carts: List<MiningCart>, orderingCustomer: String): Order?
    suspend fun getOrder(id: Int): Order?
    suspend fun allOrders(): List<Order>
    suspend fun deleteOrder(id: Int): Boolean
    suspend fun editOrder(id: Int, picks: Int, carts: List<MiningCart>, orderingCustomer: String): Boolean
    suspend fun completeOrder(id: Int): Boolean
}
