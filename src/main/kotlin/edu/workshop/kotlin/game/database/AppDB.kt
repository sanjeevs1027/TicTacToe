package edu.workshop.kotlin.game.database

import io.ktor.application.Application
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

val Application.database get() = environment.config.propertyOrNull("ktor.db.database")?.getString() ?: "tictactoe"
val Application.dbHost get() = environment.config.propertyOrNull("ktor.db.host")?.getString() ?: "localhost"
val Application.dbPort get() = environment.config.propertyOrNull("ktor.db.port")?.getString() ?: "5432"
val Application.dbUser get() = environment.config.propertyOrNull("ktor.db.user")?.getString() ?: ""
val Application.dbPassword get() = environment.config.propertyOrNull("ktor.db.password")?.getString() ?: ""



fun Application.setupDatabase() {
    Database.connect("jdbc:postgresql://$dbHost:$dbPort/$database", driver = "org.postgresql.Driver",
            user = dbUser, password = dbPassword)
    transaction {
        addLogger(StdOutSqlLogger)

    }
}

