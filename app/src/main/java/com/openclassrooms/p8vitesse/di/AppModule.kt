package com.openclassrooms.p8vitesse.di

import android.content.Context
import androidx.room.Room
import com.openclassrooms.p8vitesse.data.local.dao.CandidateDao
import com.openclassrooms.p8vitesse.data.local.database.AppDatabase
import com.openclassrooms.p8vitesse.data.repository.CandidateRepositoryImpl
import com.openclassrooms.p8vitesse.domain.repository.CandidateRepository
import com.openclassrooms.p8vitesse.domain.usecase.DeleteCandidateUseCase
import com.openclassrooms.p8vitesse.domain.usecase.GetAllCandidatesUseCase
import com.openclassrooms.p8vitesse.domain.usecase.GetCandidateByIdUseCase
import com.openclassrooms.p8vitesse.domain.usecase.GetFavoriteCandidatesUseCase
import com.openclassrooms.p8vitesse.domain.usecase.InsertCandidateUseCase
import com.openclassrooms.p8vitesse.domain.usecase.UpdateCandidateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCandidateDao(appDatabase: AppDatabase): CandidateDao {
        return appDatabase.candidateDao()
    }

    @Provides
    @Singleton
    fun provideCandidateRepository(candidateDao: CandidateDao): CandidateRepository {
        return CandidateRepositoryImpl(candidateDao)
    }

    @Provides
    @Singleton
    fun provideGetAllCandidatesUseCase(candidateRepository: CandidateRepository): GetAllCandidatesUseCase {
        return GetAllCandidatesUseCase(candidateRepository)
    }

    @Provides
    @Singleton
    fun provideGetFavoriteCandidatesUseCase(candidateRepository: CandidateRepository): GetFavoriteCandidatesUseCase {
        return GetFavoriteCandidatesUseCase(candidateRepository)
    }

    @Provides
    @Singleton
    fun provideGetCandidateByIdUseCase(candidateRepository: CandidateRepository): GetCandidateByIdUseCase {
        return GetCandidateByIdUseCase(candidateRepository)
    }

    @Provides
    @Singleton
    fun provideInsertCandidateUseCase(candidateRepository: CandidateRepository): InsertCandidateUseCase {
        return InsertCandidateUseCase(candidateRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateCandidateUseCase(candidateRepository: CandidateRepository): UpdateCandidateUseCase {
        return UpdateCandidateUseCase(candidateRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteCandidateUseCase(candidateRepository: CandidateRepository): DeleteCandidateUseCase {
        return DeleteCandidateUseCase(candidateRepository)
    }
}