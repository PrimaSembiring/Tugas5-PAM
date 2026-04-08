package com.example.profileapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.profileapp.viewmodel.NoteViewModel

@Composable
fun NoteDetailScreen(
    noteId: Int,
    viewModel: NoteViewModel,
    onBack: () -> Unit,
    onEdit: (Int) -> Unit
) {

    val note = viewModel.getNoteById(noteId)

    Column(Modifier.padding(16.dp)) {

        Text(note?.title ?: "Not Found")

        Spacer(modifier = Modifier.height(10.dp))

        Text(note?.content ?: "")

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = onBack) {
                Text("Kembali")
            }

            Button(onClick = { onEdit(noteId) }) {
                Text("Edit")
            }
        }
    }
}