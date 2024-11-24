package com.openclassrooms.p8vitesse.domain.repository

import com.openclassrooms.p8vitesse.domain.model.Candidate
import kotlinx.coroutines.flow.Flow

/**
 * Interface définissant les méthodes pour interagir avec les données des candidats.
 * Cela inclut la récupération, l'ajout, la mise à jour et la suppression des candidats.
 */
interface CandidateRepository {

    /**
     * Insère un candidat.
     *
     * @param candidate Le candidat à insérer.
     */
    suspend fun insertCandidate(candidate: Candidate)

    /**
     * Met à jour un candidat.
     *
     * @param candidate Le candidat à mettre à jour.
     */
    suspend fun updateCandidate(candidate: Candidate)

    /**
     * Récupère tous les candidats.
     *
     * @return Un Flow qui émet la liste des candidats.
     */
    fun getAllCandidates(): Flow<List<Candidate>>

    /**
     * Récupère tous les candidats favoris.
     *
     * @return Un Flow qui émet la liste des candidats favoris.
     */
    fun getFavoriteCandidates(): Flow<List<Candidate>>

    /**
     * Récupère un candidat par son ID.
     *
     * @param candidateId L'ID du candidat à récupérer.
     * @return Un Flow qui émet le candidat avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    fun getCandidateById(candidateId: Long): Flow<Candidate?>

    /**
     * Supprime un candidat.
     *
     * @param candidate Le candidat à supprimer.
     */
    suspend fun deleteCandidate(candidate: Candidate)
}