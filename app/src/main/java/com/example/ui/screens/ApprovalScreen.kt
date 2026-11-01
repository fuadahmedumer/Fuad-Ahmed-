package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Student
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApprovalScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val students by viewModel.students.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) }
    var showAddDialog by remember { mutableStateOf(false) }

    val pendingStudents = students.filter { !it.isApproved }
    val approvedStudents = students.filter { it.isApproved }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Hayyama Barattoota Haaraa",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("approval_back_button")
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
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddDialog = true },
                containerColor = TealPrimary,
                contentColor = Color.White,
                modifier = Modifier.testTag("fab_add_student")
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Barataa Dabali")
            }
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
        ) {
            // Tabs
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                contentColor = TealPrimary
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Eeggataa Jiran", fontWeight = FontWeight.Bold)
                            if (pendingStudents.isNotEmpty()) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Badge(containerColor = Color(0xFFFF9800), contentColor = Color.White) {
                                    Text("${pendingStudents.size}", fontSize = 10.sp)
                                }
                            }
                        }
                    },
                    modifier = Modifier.testTag("tab_pending")
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Hayyamamaniiru", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(6.dp))
                            Badge(containerColor = EmeraldGreen, contentColor = Color.White) {
                                Text("${approvedStudents.size}", fontSize = 10.sp)
                            }
                        }
                    },
                    modifier = Modifier.testTag("tab_approved")
                )
            }

            val displayedList = if (selectedTab == 0) pendingStudents else approvedStudents

            if (displayedList.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = if (selectedTab == 0) Icons.Default.CheckCircle else Icons.Default.PeopleOutline,
                            contentDescription = null,
                            tint = TextMuted,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (selectedTab == 0) "Gaaffiin galmee eeggatu hin jiru!" else "Barattoonni hayyamaman hin jiran.",
                            style = MaterialTheme.typography.bodyLarge.copy(color = TextMuted),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(displayedList, key = { it.id }) { student ->
                        StudentApprovalCard(
                            student = student,
                            isPending = selectedTab == 0,
                            onApprove = { viewModel.approveStudent(student.id) },
                            onReject = { viewModel.rejectStudent(student.id) }
                        )
                    }
                }
            }
        }
    }

    if (showAddDialog) {
        RegisterStudentDialog(
            onDismiss = { showAddDialog = false },
            onRegister = { name, phone, course, gender ->
                viewModel.registerNewStudent(name, phone, course, gender)
                showAddDialog = false
            }
        )
    }
}

@Composable
fun StudentApprovalCard(
    student: Student,
    isPending: Boolean,
    onApprove: () -> Unit,
    onReject: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = if (isPending) Color(0xFFFFF3E0) else EmeraldContainer,
                modifier = Modifier.size(46.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        tint = if (isPending) Color(0xFFFF9800) else EmeraldGreen,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = student.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = TextDark
                )
                Text(
                    text = "${student.course} • ${student.phone}",
                    fontSize = 12.sp,
                    color = TextMuted
                )
                Text(
                    text = if (isPending) "Gaaffii galmee eegaa jira..." else "Galmi hayyamameera • ${student.registrationDate}",
                    fontSize = 11.sp,
                    color = if (isPending) Color(0xFFD32F2F) else EmeraldGreen
                )
            }

            if (isPending) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onApprove,
                        modifier = Modifier.testTag("approve_btn_${student.id}")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = EmeraldGreen.copy(alpha = 0.15f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Hayyami",
                                    tint = EmeraldGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }

                    IconButton(
                        onClick = onReject,
                        modifier = Modifier.testTag("reject_btn_${student.id}")
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = CrimsonError.copy(alpha = 0.15f),
                            modifier = Modifier.size(36.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Haqi",
                                    tint = CrimsonError,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            } else {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = EmeraldContainer,
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Text(
                        text = "Hayyamameera",
                        color = EmeraldGreen,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}
