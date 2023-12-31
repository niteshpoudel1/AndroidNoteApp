package com.example.notesapp.di

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NoteDatabase
import com.example.notesapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun provideNotesDao(
        noteDatabase: NoteDatabase
    ):NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ):NoteDatabase = Room.databaseBuilder(
        name = "notes_db",
        context = context,
        klass = NoteDatabase::class.java
    ).fallbackToDestructiveMigration().build()
}