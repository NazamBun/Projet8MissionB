package com.openclassrooms.p8vitesse.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.openclassrooms.p8vitesse.data.model.CandidateDto
import kotlinx.coroutines.flow.Flow

/**
 * DAO pour accéder aux données des candidats dans la base de données Room.
 * Cette interface fournit des méthodes pour insérer, mettre à jour, récupérer et supprimer des candidats.
 */@Dao
interface CandidateDao {

    /**
     * Insère un candidat dans la base de données.
     * Si un candidat avec le même ID existe déjà, il sera remplacé.
     *
     * @param candidate Le candidat à insérer.
     * @return L'ID du candidat inséré.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCandidate(candidate: CandidateDto): Long

    /**
     * Met à jour les informations d'un candidat.
     *
     * @param candidate Le candidat à mettre à jour.
     */
    @Update
    suspend fun updateCandidate(candidate: CandidateDto)

    /**
     * Supprime un candidat spécifique de la base de données.
     *
     * @param candidate Le candidat à supprimer.
     */
    @Delete
    suspend fun deleteCandidate(candidate: CandidateDto)

    /**
     * Récupère tous les candidats de la base de données.
     * Cette méthode retourne un Flow pour permettre de suivre les changements en temps réel.
     *
     * @return Un Flow qui émet la liste des candidats.
     */
    @Query("SELECT * FROM candidates")
    fun getAllCandidates(): Flow<List<CandidateDto>>

    /**
     * Récupère tous les candidats favoris de la base de données.
     * Cette méthode retourne un Flow pour permettre de suivre les changements en temps réel.
     *
     * @return Un Flow qui émet la liste des candidats favoris.
     */
    @Query("SELECT * FROM candidates WHERE isFavorite = 1")
    fun getFavoriteCandidates(): Flow<List<CandidateDto>>

    /**
     * Récupère un candidat par son ID de la base de données.
     * Cette méthode retourne un Flow pour permettre de suivre les changements du candidat en temps réel.
     *
     * @param candidateId L'ID du candidat à récupérer.
     * @return Un Flow qui émet le candidat avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    @Query("SELECT * FROM candidates WHERE id = :candidateId")
    fun getCandidateById(candidateId: Long): Flow<CandidateDto?>
}