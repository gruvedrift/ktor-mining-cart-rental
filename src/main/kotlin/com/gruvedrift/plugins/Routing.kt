package com.gruvedrift.plugins

import com.gruvedrift.dao.miningcart.cartDao
import com.gruvedrift.models.testOrders
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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
            post("/new"){
                val capacity = call.receiveText().toInt()
                val cartEntity = cartDao.createCart(capacity)
                call.respond("Created cart: $cartEntity")
            }
        }
    }
}
