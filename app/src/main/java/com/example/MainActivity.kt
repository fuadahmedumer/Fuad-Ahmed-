package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.Screen
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.screens.*
import com.example.ui.theme.SubuluSalaamTheme

class MainActivity : ComponentActivity() {
    private val viewModel: SubuluSalaamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SubuluSalaamTheme {
                val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
                val snackbarMessage by viewModel.snackbarMessage.collectAsStateWithLifecycle()
                val snackbarHostState = remember { SnackbarHostState() }

                LaunchedEffect(snackbarMessage) {
                    snackbarMessage?.let { msg ->
                        snackbarHostState.showSnackbar(msg)
                        viewModel.clearSnackbar()
                    }
                }

                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AnimatedContent(
                        targetState = currentScreen,
                        label = "screen_transition",
                        modifier = Modifier.padding(innerPadding)
                    ) { targetScreen ->
                        when (targetScreen) {
                            is Screen.Splash -> SplashScreen(viewModel)
                            is Screen.Login -> LoginScreen(viewModel)
                            is Screen.AdminDashboard -> AdminDashboardScreen(viewModel)
                            is Screen.Approval -> ApprovalScreen(viewModel)
                            is Screen.Studies -> StudiesDashboardScreen(viewModel)
                            is Screen.Qaayidaa -> QaayidaaScreen(viewModel)
                            is Screen.QaayidaaDetail -> QaayidaaDetailScreen(targetScreen.lessonId, viewModel)
                            is Screen.Shuruuxa -> ShuruuxaScreen(viewModel)
                            is Screen.Hadiisa -> HadiisaScreen(viewModel)
                            is Screen.HadiisaDetail -> HadiisaDetailScreen(targetScreen.hadithId, viewModel)
                            is Screen.HifzProgress -> HifzProgressScreen(viewModel)
                            is Screen.Attendance -> AttendanceScreen(viewModel)
                            is Screen.Reports -> ReportsScreen(viewModel)
                            is Screen.Chat -> ChatScreen(viewModel)
                            is Screen.Donation -> DonationScreen(viewModel)
                            else -> AdminDashboardScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}
