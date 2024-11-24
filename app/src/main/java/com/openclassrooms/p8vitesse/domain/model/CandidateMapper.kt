package com.openclassrooms.p8vitesse.domain.model

import com.openclassrooms.p8vitesse.data.model.CandidateDto

/**
 * Extensions pour convertir entre Candidate (domain) et CandidateDto (data).
 */

// Conversion de Candidate (domain) vers CandidateDto (data)
fun Candidate.toDto(): CandidateDto {
    return CandidateDto (
        id = this.id,
        photoUrl = this.photoUrl,
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        email = this.email,
        birthDate = this.birthDate,
        salaryExpectation = this.salaryExpectation,
        notes = this.notes,
        isFavorite = this.isFavorite
    )
}

// Conversion de CandidateDto (data) vers Candidate (domain)
fun CandidateDto.toDomain(): Candidate {
    return Candidate(
        id = this.id,
        photoUrl = this.photoUrl,
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        email = this.email,
        birthDate = this.birthDate,
        salaryExpectation = this.salaryExpectation,
        notes = this.notes,
        isFavorite = this.isFavorite
    )
}