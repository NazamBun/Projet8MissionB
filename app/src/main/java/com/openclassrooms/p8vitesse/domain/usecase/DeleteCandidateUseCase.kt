package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository

/**
 * Use case pour supprimer un candidat.
 */
class DeleteCandidateUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case pour supprimer un candidat.
     *
     * @param candidate Le candidat à supprimer.
     */
    suspend fun execute(candidate: Candidate) {
        candidateRepository.deleteCandidate(candidate)
    }
}