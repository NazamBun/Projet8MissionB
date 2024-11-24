package com.openclassrooms.p8vitesse.domain.model

data class Candidate(
    val id: Long,
    val photoUrl: String?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: String,
    val salaryExpectation: Double,
    val notes: String,
    val isFavorite: Boolean
)

