package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository
import kotlinx.coroutines.flow.Flow

class GetAllCandidatesUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case.
     *
     * @return Un Flow contenant la liste de tous les candidats.
     */
    fun execute(): Flow<List<Candidate>> {
        return candidateRepository.getAllCandidates()
    }
}