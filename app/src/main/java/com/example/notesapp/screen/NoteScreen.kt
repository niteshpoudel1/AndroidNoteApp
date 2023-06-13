package com.example.notesapp.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.components.NoteButton
import com.example.notesapp.components.NoteInputText
import com.example.notesapp.data.NoteDataSource
import com.example.notesapp.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    addNote: (Note) -> Unit,
    removeNote: (Note) -> Unit,

    ) {
    var title by remember {
        mutableStateOf("")
    }
    var noteContent by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(4.dp)
    ) {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                )
            },
            navigationIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            },
            actions = {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
            },
        )
        Divider(color = Color.Black, thickness = 0.8.dp)
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NoteInputText(
                text = title, label = "Title", onTextChange = {
                    if (it.all { Char -> Char.isLetterOrDigit() || Char.isWhitespace() }) title = it
                }, modifier = Modifier.padding(20.dp)
            )

            NoteInputText(
                text = noteContent, label = "Add note", maxlines = Int.MAX_VALUE, onTextChange = {
                    if (it.all { Char -> Char.isLetterOrDigit() || Char.isWhitespace() }) noteContent =
                        it
                }, modifier = Modifier.padding(20.dp)
            )

            NoteButton(
                modifier = Modifier.padding(10.dp),
                text = "Save",
                onClick = {
                    if (title.isNotEmpty() && noteContent.isNotEmpty()) {
                        addNote(
                            Note(
                                title = title, noteContent = noteContent
                            )
                        )
                        title = ""
                        noteContent = ""
                        Toast.makeText(context, "Note Added", Toast.LENGTH_LONG).show()
                    }
                },
            )
        }
        Divider(color = Color.Black, thickness = 0.8.dp)
        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note) {
                    Log.d("nitesh", "NoteScreen: Hello")
                    removeNote(note)
                }
            }
        }

    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier, note: Note, onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
            .padding(5.dp),
        color = Color(0xFFDFE6EB)
    ) {
        Column(
            modifier = Modifier
                .clickable { onNoteClicked(note) }
                .padding(horizontal = 14.dp, vertical = 6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = note.title, style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = note.noteContent, style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "${note.entryDate}", style = MaterialTheme.typography.labelSmall
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NoteDataSource().loadNotes(), addNote = {}, removeNote = {})
}
