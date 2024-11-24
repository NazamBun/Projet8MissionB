package com.openclassrooms.p8vitesse.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.openclassrooms.p8vitesse.data.local.dao.CandidateDao
import com.openclassrooms.p8vitesse.data.model.CandidateDto

// Définition de la base de données Room pour l'application
@Database(entities = [CandidateDto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    // Fournir un accès à CandidateDao pour interagir avec les candidats
    abstract fun candidateDao(): CandidateDao
}