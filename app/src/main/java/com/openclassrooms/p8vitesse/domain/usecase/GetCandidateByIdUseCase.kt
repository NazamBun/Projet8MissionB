package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case pour récupérer un candidat par son ID.
 */
class GetCandidateByIdUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case.
     *
     * @param candidateId L'ID du candidat à récupérer.
     * @return Un Flow contenant le candidat, ou null s'il n'est pas trouvé.
     */
    fun execute(candidateId: Long): Flow<Candidate?> {
        return candidateRepository.getCandidateById(candidateId)
    }
}