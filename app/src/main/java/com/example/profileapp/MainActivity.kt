package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profileapp.viewmodel.ProfileViewModel
import com.example.profileapp.ui.screen.ProfileScreen
import com.example.profileapp.ui.screen.EditProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: ProfileViewModel = viewModel()
            val state by viewModel.uiState.collectAsState()

            var currentScreen by remember { mutableStateOf("profile") }

            MaterialTheme(
                colorScheme = if (state.isDarkMode)
                    darkColorScheme()
                else
                    lightColorScheme()
            ) {

                if (currentScreen == "profile") {
                    ProfileScreen(
                        viewModel = viewModel,
                        onEditClick = { currentScreen = "edit" }
                    )
                } else {
                    EditProfileScreen(
                        viewModel = viewModel,
                        onBack = { currentScreen = "profile" }
                    )
                }
            }
        }
    }
}