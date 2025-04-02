package com.bomboclat.kwasoo

import java.util.UUID

data class Subject(
    val id: String = UUID.randomUUID().toString(), // Unique ID
    val name: String,
    val code: String,
    val gradeLevel: String? = null, // Optional
    val roomNumber: String,
    val time: String
)
