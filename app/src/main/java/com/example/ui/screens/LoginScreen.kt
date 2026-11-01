package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.data.Screen
import com.example.data.UserRole
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.theme.TealDark
import com.example.ui.theme.TealLight
import com.example.ui.theme.TealPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    var phoneNumber by remember { mutableStateOf("0911223344") }
    var selectedRole by remember { mutableStateOf(UserRole.ADMIN_USTAAZ) }
    var showRegisterDialog by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Seensa Appii (Login)",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("login_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = TealPrimary
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = TealLight,
                modifier = Modifier.size(72.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.PhoneAndroid,
                        contentDescription = null,
                        tint = TealDark,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Lakkoofsa Bilbilaan Seensa",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = TealDark
                ),
                textAlign = TextAlign.Center
            )

            Text(
                text = "Markaza Subulu-Salaam - Galmee fi To'annoo",
                style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
            )

            // Role Selector Chips
            Text(
                text = "Gahee Keessan Filadhaa / Select Role:",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FilterChip(
                    selected = selectedRole == UserRole.ADMIN_USTAAZ,
                    onClick = {
                        selectedRole = UserRole.ADMIN_USTAAZ
                        phoneNumber = "0911223344"
                    },
                    label = { Text("Bulchaa (Ustaaz Fu'aad)") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AdminPanelSettings,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("role_chip_admin")
                )

                FilterChip(
                    selected = selectedRole == UserRole.STUDENT,
                    onClick = {
                        selectedRole = UserRole.STUDENT
                        phoneNumber = "0922334455"
                    },
                    label = { Text("Barataa (Student)") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.School,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("role_chip_student")
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Phone textfield
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Lakkoofsa Bilbilaa") },
                placeholder = { Text("09XXXXXXXX") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Bilbila",
                        tint = TealPrimary
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("phone_input")
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            Button(
                onClick = {
                    viewModel.setUserRole(selectedRole)
                    // If Admin, go to AdminDashboard; if Student, can still view studies & dashboard
                    viewModel.navigateTo(Screen.AdminDashboard)
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = TealPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .testTag("login_submit_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Login,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Seeni / Login",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Register option for new student
            TextButton(
                onClick = { showRegisterDialog = true },
                modifier = Modifier.testTag("register_new_student_button")
            ) {
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = null,
                    tint = TealPrimary,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Barataa Haaraa? As tuquun Galmaa'aa",
                    color = TealPrimary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    if (showRegisterDialog) {
        RegisterStudentDialog(
            onDismiss = { showRegisterDialog = false },
            onRegister = { name, phone, course, gender ->
                viewModel.registerNewStudent(name, phone, course, gender)
                showRegisterDialog = false
            }
        )
    }
}

@Composable
fun RegisterStudentDialog(
    onDismiss: () -> Unit,
    onRegister: (name: String, phone: String, course: String, gender: String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var selectedCourse by remember { mutableStateOf("Qaayidaa Nuuraaniyyaa") }
    var selectedGender by remember { mutableStateOf("Dhiira") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "Galmee Barataa Haaraa",
                fontWeight = FontWeight.Bold,
                color = TealDark
            )
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Odeeffannoo barataa guutuudhaan gaaffii galmee ergaa:",
                    style = MaterialTheme.typography.bodySmall
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Maqaa Barataa Guutuu") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("register_name_input")
                )

                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Lakkoofsa Bilbilaa") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("register_phone_input")
                )

                Text(
                    "Gosa Barnootaa:",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                )

                listOf(
                    "Qaayidaa Nuuraaniyyaa",
                    "Hifzii Qur'aanaa",
                    "Hadiisa & Fiqa"
                ).forEach { course ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        RadioButton(
                            selected = selectedCourse == course,
                            onClick = { selectedCourse = course }
                        )
                        Text(course, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                Text(
                    "Saala / Gender:",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
                )

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedGender == "Dhiira",
                            onClick = { selectedGender = "Dhiira" }
                        )
                        Text("Dhiira")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedGender == "Dubara",
                            onClick = { selectedGender = "Dubara" }
                        )
                        Text("Dubara")
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (name.isNotBlank()) {
                        onRegister(name, phone, selectedCourse, selectedGender)
                    }
                },
                enabled = name.isNotBlank(),
                colors = ButtonDefaults.buttonColors(containerColor = TealPrimary),
                modifier = Modifier.testTag("register_submit_btn")
            ) {
                Text("Ergi / Submit")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Dhiisi")
            }
        }
    )
}
