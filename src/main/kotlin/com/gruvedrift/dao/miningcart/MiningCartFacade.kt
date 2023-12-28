package com.gruvedrift.dao.miningcart

import com.gruvedrift.models.MiningCart

interface MiningCartFacade {
    suspend fun cartById(id: Int): MiningCart?
    suspend fun createCart(capacity: Int): MiningCart?
    suspend fun allCarts(): List<MiningCart>
    suspend fun allCartsByCapacity(capacity: Int): List<MiningCart>?
    suspend fun deleteCart(id: Int): Boolean
    suspend fun putCartInOrder(orderId: Int): Boolean
}
