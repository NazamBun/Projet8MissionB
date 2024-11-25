package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository

/**
 * Use case pour mettre à jour un candidat.
 */
class UpdateCandidateUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case pour mettre à jour un candidat.
     *
     * @param candidate Le candidat à mettre à jour.
     */
    suspend fun execute(candidate: Candidate) {
        candidateRepository.updateCandidate(candidate)
    }
}