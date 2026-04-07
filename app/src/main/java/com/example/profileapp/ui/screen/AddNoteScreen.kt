package com.example.profileapp.ui.screen

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profileapp.viewmodel.NoteViewModel
import com.example.profileapp.ui.components.MyTextField

@Composable
fun AddNoteScreen(
    onBack: () -> Unit,
    viewModel: NoteViewModel = viewModel()
) {

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Tambah Note")

        MyTextField(
            value = title,
            onValueChange = { title = it },
            label = "Judul"
        )

        Spacer(modifier = Modifier.height(8.dp))

        MyTextField(
            value = content,
            onValueChange = { content = it },
            label = "Isi"
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            viewModel.addNote(title, content)
            onBack()
        }) {
            Text("Simpan")
        }
    }
}