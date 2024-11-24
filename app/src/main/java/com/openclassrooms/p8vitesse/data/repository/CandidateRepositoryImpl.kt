package com.openclassrooms.p8vitesse.data.repository

import com.openclassrooms.p8vitesse.data.local.dao.CandidateDao
import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.model.toDomain
import com.openclassrooms.p8vitesse.domain.model.toDto
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Implémentation du CandidateRepository, utilisant CandidateDao pour accéder aux données des candidats.
 */
class CandidateRepositoryImpl(private val candidateDao: CandidateDao) : CandidateRepository {

    /**
     * Insère un candidat.
     *
     * @param candidate Le candidat à insérer.
     */
    override suspend fun insertCandidate(candidate: Candidate) {
        val candidateDto = candidate.toDto()
        candidateDao.insertCandidate(candidateDto)
    }

    /**
     * Met à jour un candidat.
     *
     * @param candidate Le candidat à mettre à jour.
     */
    override suspend fun updateCandidate(candidate: Candidate) {
        val candidateDto = candidate.toDto()
        candidateDao.updateCandidate(candidateDto)
    }

    /**
     * Récupère tous les candidats.
     *
     * @return Un Flow qui émet la liste des candidats.
     */
    override fun getAllCandidates(): Flow<List<Candidate>> {
        return candidateDao.getAllCandidates().map { list ->
            list.map { it.toDomain() }
        }
    }

    /**
     * Récupère tous les candidats favoris.
     *
     * @return Un Flow qui émet la liste des candidats favoris.
     */
    override fun getFavoriteCandidates(): Flow<List<Candidate>> {
        return candidateDao.getFavoriteCandidates().map { list ->
            list.map { it.toDomain() }
        }
    }

    /**
     * Récupère un candidat par son ID.
     *
     * @param candidateId L'ID du candidat à récupérer.
     * @return Un Flow qui émet le candidat avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    override fun getCandidateById(candidateId: Long): Flow<Candidate?> {
        return candidateDao.getCandidateById(candidateId).map { candidateDto ->
            candidateDto?.toDomain()
        }
    }

    /**
     * Supprime un candidat.
     *
     * @param candidate Le candidat à supprimer.
     */
    override suspend fun deleteCandidate(candidate: Candidate) {
        val candidateDto = candidate.toDto()
        candidateDao.deleteCandidate(candidateDto)
    }
}
