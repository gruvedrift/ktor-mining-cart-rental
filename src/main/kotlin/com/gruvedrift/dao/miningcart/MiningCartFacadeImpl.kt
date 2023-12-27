package com.gruvedrift.dao.miningcart

import com.gruvedrift.dao.DatabaseSingleton.dbQuery
import com.gruvedrift.models.MiningCart
import com.gruvedrift.models.MiningCartTable
import com.gruvedrift.models.StorageSize
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.lang.IllegalArgumentException

/* Not really a facade as in per definition. But the logic in the code is simple enough. */
class MiningCartFacadeImpl : MiningCartFacade {

    private fun resultRowToMiningCart(row: ResultRow): MiningCart {
        val capacity = row[MiningCartTable.storageCapacity]
        val storageSize = StorageSize.getByCapacity(capacity) ?: throw IllegalArgumentException("Illegal storage size: $capacity")
        return MiningCart(id = row[MiningCartTable.id], storageCapacity = storageSize)
    }
    override suspend fun allCarts(): List<MiningCart> = dbQuery {
        MiningCartTable.selectAll().map { resultRowToMiningCart(it) }
    }

    override suspend fun allCartsByCapacity(capacity: Int): List<MiningCart>? = dbQuery {
        MiningCartTable.select {
            MiningCartTable.storageCapacity eq capacity
        }.map { resultRowToMiningCart(it) }
    }

    override suspend fun cartById(id: Int): MiningCart? = dbQuery {
        MiningCartTable.select { MiningCartTable.id eq id }
            .map { resultRowToMiningCart(it) }
            .singleOrNull()
    }
    override suspend fun createCart(capacity: Int): MiningCart?  = dbQuery {
        MiningCartTable.insert{
            it[storageCapacity] = capacity
        }.resultedValues?.singleOrNull()?.let { resultRowToMiningCart(it) }
    }

    override suspend fun deleteCart(id: Int): Boolean = dbQuery {
        MiningCartTable.deleteWhere{ MiningCartTable.id eq id  } > 0
    }

    override suspend fun putCartInOrder(orderId: Int): Boolean {
        TODO("Not yet implemented")
        // Find order with orderId
        // Update cart FK : ORDER_ID
    }
}

val cartDao: MiningCartFacade = MiningCartFacadeImpl().apply {
    runBlocking {
        if (allCarts().isEmpty()) {
            createCart(100)
            createCart(250)
            createCart(400)
            createCart(600)
        }
    }
}
