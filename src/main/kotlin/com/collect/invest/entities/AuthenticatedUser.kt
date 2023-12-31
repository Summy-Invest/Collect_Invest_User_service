package com.collect.invest.entities

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticatedUser(
    val id: Long,
    val name: String
)
