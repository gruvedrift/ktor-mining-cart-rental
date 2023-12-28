package com.gruvedrift.plugins

import com.gruvedrift.dao.miningcart.cartDao
import com.gruvedrift.models.testOrders
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureOrderRouting() {
    routing {
        route("orders") {
            get("/test") {
                call.respond("Test \n ${testOrders[0]}")
            }
        }
    }
}

fun Application.configureCartRouting(){
    routing {
        route("carts"){
            get("{id}") {
                val id = call.parameters.getOrFail("id").toInt()
                call.respond("${cartDao.cartById(id)}")
            }

            get("all"){
                call.respond("${cartDao.allCarts()}")
            }

            get("all") {
                val capacityParam = call.receiveText().toInt()
                call.respond("All carts in stock:\n${cartDao.allCartsByCapacity(capacityParam)}")
            }

            post("/new"){
                val capacity = call.receiveText().toInt()
                call.respond("Created cart: ${cartDao.createCart(capacity)}")
            }
            delete("delete"){
                val id = call.receiveText().toInt()
                call.respond("Deleted with id: $id: ${cartDao.deleteCart(id)}")
            }
        }
    }
}
