package com.gruvedrift.models

import org.jetbrains.exposed.sql.Table

data class Order (
    val id: Int,
    val picks: Int,
    val carts: List<MiningCart>,
    val orderingCustomer: String
)

object OrderTable : Table() {
    val id = integer("ID").autoIncrement()
    val picks = integer("PICKS")
    val orderingCustomer = varchar("ORDERING_CUSTOMER", 128)

    override val primaryKey = PrimaryKey(id)
}


val testOrders = listOf<Order>(
    Order(
        id = 0,
        picks = 0,
        carts = testMiningCarts,
        orderingCustomer = "Gimli Gloin"
    ),
    Order(
        id = 1,
        picks = 5,
        carts = testMiningCartsTwo,
        orderingCustomer = "Dig dug"
    )
)
