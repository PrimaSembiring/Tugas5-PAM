package com.example.profileapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profileapp.viewmodel.NoteViewModel

@Composable
fun NoteDetailScreen(
    noteId: Int,
    onBack: () -> Unit,
    viewModel: NoteViewModel = viewModel()
) {

    val note = viewModel.getNoteById(noteId)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(note?.title ?: "Note tidak ditemukan")

        Spacer(modifier = Modifier.height(10.dp))

        Text(note?.content ?: "")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}