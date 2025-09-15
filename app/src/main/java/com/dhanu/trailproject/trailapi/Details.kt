package com.dhanu.trailproject.trailapi

import kotlinx.serialization.Serializable


@Serializable
data class Details(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)