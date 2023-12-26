package com.gruvedrift.dao.miningcart

import com.gruvedrift.models.MiningCart
import com.gruvedrift.models.MiningCartTable
import com.gruvedrift.models.StorageSize
import org.jetbrains.exposed.sql.Min
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.selectAll
import java.lang.IllegalArgumentException

class MiningCartFacadeImpl : MiningCartFacade {

    private fun resultRowToMiningCart(row: ResultRow): MiningCart {
        val capacity = row[MiningCartTable.storageCapacity]
        val storageSize = StorageSize.getByCapacity(capacity) ?: throw IllegalArgumentException("Illegal storage size: $capacity")
        return MiningCart(id = 1, storageCapacity = storageSize)
    }
    override suspend fun allCarts(): List<MiningCart> {
        return MiningCartTable.selectAll().map { resultRowToMiningCart(it) }
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
