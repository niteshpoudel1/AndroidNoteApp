package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.screen.NoteScreen
import com.example.notesapp.screen.NoteView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteView: NoteView by viewModels()
            NotesApp(noteView)
        }
    }

    @Composable
    fun NotesApp(noteView: NoteView = viewModel()) {

        val notesList = noteView.getAllNotes()
        Surface(color = MaterialTheme.colorScheme.background) {
            NoteScreen(
                notes = notesList,
                addNote = {
                    noteView.addNote(it)
                },
                removeNote = {
                    noteView.removeNote(it)
                }
            )
        }
    }
}