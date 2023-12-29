package com.gruvedrift.dao

import com.gruvedrift.models.MiningCartTable
import com.gruvedrift.models.OrderTable
import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

/*
* Read config from file with HOCON interface
* */
object DatabaseSingleton {
    fun init(){

        val environment = System.getProperty("app.environment") ?: ""
        val configFileName = if (environment == "prod") "application-prod.conf" else "application.conf"
        val config = HoconApplicationConfig(ConfigFactory.load(configFileName))

        val driverClassName = config.property("storage.driverClassName").getString()
        val jdbcURL = config.property("storage.jdbcURL").getString()
        val database = Database.connect(url = jdbcURL, driver = driverClassName)

        transaction(database) {
            SchemaUtils.create(OrderTable)
            SchemaUtils.create(MiningCartTable)
        }
    }
    suspend fun <T> dbQuery(block: suspend () -> T): T  =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}
