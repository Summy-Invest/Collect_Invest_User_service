package com.collect.invest.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.collect.invest.entities.*
import com.collect.invest.validation.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    val emailValid = EmailValidator()
    val passwordValid = PasswordValidator()

    routing {
        post("/createUser") {
            val user = call.receive<User>()
            if (!emailValid.validate(user.email)) {
                call.respondText(text = Json.encodeToString(Message("message", "Incorrect email")),
                    contentType = ContentType.Application.Json,
                    status = HttpStatusCode.BadRequest
                )
            }
            else if (!passwordValid.validate(user.password)) {
                call.respondText(text = Json.encodeToString(Message("message", "Incorrect password")),
                    contentType = ContentType.Application.Json,
                    status = HttpStatusCode.BadRequest
                )
            }
            else {
                call.respondText(text = Json.encodeToString(Message("message", "User is signed up")),
                    contentType = ContentType.Application.Json,
                    status = HttpStatusCode.OK
                )
            }
        }
    }
}