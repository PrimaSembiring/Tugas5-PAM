package com.example.profileapp.ui.screen

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profileapp.viewmodel.NoteViewModel
import androidx.compose.foundation.clickable

@Composable
fun NotesScreen(
    onClickDetail: (Int) -> Unit,
    onAdd: () -> Unit,
    viewModel: NoteViewModel = viewModel()
) {
    val notes by viewModel.notes.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd) {
                Text("+")
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            items(notes) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                        .clickable { onClickDetail(note.id) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(note.title)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(note.content, maxLines = 2)
                    }
                }
            }
        }
    }
}