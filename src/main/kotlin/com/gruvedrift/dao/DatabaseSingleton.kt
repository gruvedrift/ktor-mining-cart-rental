package com.gruvedrift.dao

import com.gruvedrift.models.MiningCartTable
import com.gruvedrift.models.OrderTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseSingleton {
    fun init(){
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./dbdir/db"
        val database = Database.connect(url = jdbcURL, driver = driverClassName)

        transaction(database) {
            SchemaUtils.create(OrderTable)
            SchemaUtils.create(MiningCartTable)
        }
    }
}