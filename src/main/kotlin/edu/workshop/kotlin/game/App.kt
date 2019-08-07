package edu.workshop.kotlin.game

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(Netty, 8080) {
        routing {
            get("/") {
                call.respondText("<h2>Cool!! You are all set for the workshop \uD83D\uDC4D</h2>", ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}