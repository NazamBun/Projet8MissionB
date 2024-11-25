package com.openclassrooms.p8vitesse.domain.usecase

import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository
import kotlinx.coroutines.flow.Flow

/**
 * Use case pour récupérer tous les candidats favoris.
 */
class GetFavoriteCandidatesUseCase(private val candidateRepository: CandidateRepository) {
    /**
     * Exécute le use case.
     *
     * @return Un Flow contenant la liste des candidats favoris.
     */
    fun execute(): Flow<List<Candidate>> {
        return candidateRepository.getFavoriteCandidates()
    }
}