package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository

/**
 * Use case pour insérer un candidat.
 */
class InsertCandidateUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case pour insérer un candidat.
     *
     * @param candidate Le candidat à insérer.
     */
    suspend fun execute(candidate: Candidate) {
        candidateRepository.insertCandidate(candidate)
    }
}