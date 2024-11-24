package com.openclassrooms.p8vitesse.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.openclassrooms.p8vitesse.data.model.CandidateDto

// Définition du DAO pour gérer l'accès aux données des candidats dans la base de données
@Dao
interface CandidateDao {

    // Insérer un nouveau candidat dans la base de données
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCandidate(candidate: CandidateDto)

    // Mettre à jour les informations d'un candidat
    @Update
    suspend fun updateCandidate(candidate: CandidateDto)

    // Supprimer un candidat spécifique de la base de données
    @Delete
    suspend fun deleteCandidate(candidate: CandidateDto)

    // Récupérer tous les candidats
    @Query("SELECT * FROM candidates")
    suspend fun getAllCandidates(): List<CandidateDto>

    // Récupérer tous les candidats favoris
    @Query("SELECT * FROM candidates WHERE isFavorite = 1")
    suspend fun getFavoriteCandidates(): List<CandidateDto>

    // Récupérer un candidat par son ID
    @Query("SELECT * FROM candidates WHERE id = :candidateId")
    suspend fun getCandidateById(candidateId: Long): CandidateDto?
}