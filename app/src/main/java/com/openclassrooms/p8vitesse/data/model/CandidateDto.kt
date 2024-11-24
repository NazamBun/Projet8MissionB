package com.openclassrooms.p8vitesse.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Définition de la classe qui représente un candidat dans la base de données
@Entity(tableName = "candidates")
data class CandidateDto (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val photoUrl: String?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: String,
    val salaryExpectation: Int,
    val notes: String,
    val isFavorite: Boolean
)