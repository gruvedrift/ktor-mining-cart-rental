package com.gruvedrift.models

import org.jetbrains.exposed.sql.Table

data class MiningCart(
    val id: Int,
    val storageCapacity: StorageSize,
)


object MiningCartTable : Table() {
    val id = integer("id").autoIncrement()
    val orderId = integer("order_id").references(OrderTable.id).nullable()
    val storageCapacity = integer("storageCapacity")

    override val primaryKey = PrimaryKey(id)
}

enum class StorageSize(val capacity: Int) {
    SMALL(100),
    MEDIUM (250),
    LARGE(400),
    X_LARGE(600);

    companion object  {
       fun getByCapacity(capacity: Int): StorageSize? =
           values().find { it.capacity == capacity}
    }
}

val testMiningCarts = listOf(
    MiningCart(0, StorageSize.SMALL),
    MiningCart(1, StorageSize.MEDIUM),
    MiningCart(2, StorageSize.LARGE),
    MiningCart(3, StorageSize.X_LARGE),
)
val testMiningCartsTwo = listOf(
    MiningCart(4, StorageSize.SMALL),
    MiningCart(5, StorageSize.LARGE),
    MiningCart(6, StorageSize.LARGE),
    MiningCart(7, StorageSize.SMALL),
)
