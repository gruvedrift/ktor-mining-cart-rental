package com.gruvedrift.dao.miningcart

import com.gruvedrift.models.MiningCart
import com.gruvedrift.models.StorageSize

class MiningCartFacadeImpl : MiningCartFacade {
    override suspend fun allCarts(): List<MiningCart> {
        TODO("Not yet implemented")
    }

    override suspend fun allCartsByCapacity(capacity: StorageSize): List<MiningCart>? {
        TODO("Not yet implemented")
    }

    override suspend fun cartById(id: Int): MiningCart? {
        TODO("Not yet implemented")
    }

    override suspend fun createCart(capacity: StorageSize): MiningCart? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCart(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun putCartInOrder(orderId: Int): Boolean {
        TODO("Not yet implemented")
    }
}
