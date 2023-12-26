package com.gruvedrift.dao.miningcart

import com.gruvedrift.models.MiningCart
import com.gruvedrift.models.StorageSize

interface MiningCartFacade {

    suspend fun allCarts(): List<MiningCart>

    suspend fun allCartsByCapacity(capacity: StorageSize): List<MiningCart>?

    suspend fun cartById(id: Int): MiningCart?

    suspend fun createCart(capacity: StorageSize): MiningCart?

    suspend fun deleteCart(id: Int): Boolean

    suspend fun putCartInOrder(orderId: Int): Boolean
}
