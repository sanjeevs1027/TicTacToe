package edu.workshop.kotlin.game

import edu.workshop.kotlin.game.database.setupDatabase
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.module() {
    setupDatabase()
    routing {
        get("/") {
            call.respondText("<h2>Cool!! You are all set for the workshop \uD83D\uDC4D</h2>", ContentType.Text.Html)
        }
    }
}


