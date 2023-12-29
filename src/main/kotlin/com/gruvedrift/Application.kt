package com.gruvedrift

import com.gruvedrift.dao.DatabaseSingleton
import com.gruvedrift.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseSingleton.init()
    configureTemplating()
    configureCartRouting()
    configureOrderRouting()
}
