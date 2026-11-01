package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.Screen
import com.example.data.UserRole
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminDashboardScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val students by viewModel.students.collectAsState()
    val userRole by viewModel.userRole.collectAsState()
    val pendingCount = students.count { !it.isApproved }
    val approvedCount = students.count { it.isApproved }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Admin Dashboard",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Ustaaz Fu'aad Ahmad | Subulu-Salaam",
                            fontSize = 12.sp,
                            color = TealLight
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateTo(Screen.Splash) },
                        modifier = Modifier.testTag("admin_home_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Mosque,
                            contentDescription = "Gara Jalqabaa",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    // Quick Role Switch Icon
                    AssistChip(
                        onClick = {
                            val nextRole = if (userRole == UserRole.ADMIN_USTAAZ) UserRole.STUDENT else UserRole.ADMIN_USTAAZ
                            viewModel.setUserRole(nextRole)
                        },
                        label = {
                            Text(
                                if (userRole == UserRole.ADMIN_USTAAZ) "Admin" else "Barataa",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        colors = AssistChipDefaults.assistChipColors(
                            containerColor = Color.White.copy(alpha = 0.2f)
                        ),
                        border = null,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .testTag("role_toggle_chip")
                    )
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
                .background(SurfaceSlate)
        ) {
            // Header Profile & Greeting Card
            Card(
                shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = TealPrimary),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 18.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = GoldAccent,
                            modifier = Modifier.size(52.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = "Ustaaz Fu'aad",
                                    tint = Color.White,
                                    modifier = Modifier.size(34.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Baga Nagaan Dhuftan!",
                                color = TealLight,
                                fontSize = 13.sp
                            )
                            Text(
                                text = if (userRole == UserRole.ADMIN_USTAAZ) "Ustaaz Fu'aad Ahmad" else "Barataa Markazaa",
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 18.sp
                            )
                            Text(
                                text = "Markaza Barnoota Qur'aanaa Subulu-Salaam",
                                color = Color.White.copy(alpha = 0.85f),
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Summary Stats Ribbon
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White.copy(alpha = 0.15f))
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        StatItem(label = "Barattoota", value = "$approvedCount")
                        Divider(
                            modifier = Modifier
                                .height(24.dp)
                                .width(1.dp),
                            color = Color.White.copy(alpha = 0.3f)
                        )
                        StatItem(label = "Hayyama Eegan", value = "$pendingCount", highlight = pendingCount > 0)
                        Divider(
                            modifier = Modifier
                                .height(24.dp)
                                .width(1.dp),
                            color = Color.White.copy(alpha = 0.3f)
                        )
                        StatItem(label = "Argama Har'aa", value = "96%")
                    }
                }
            }

            // Dashboard Grid Cards (Matching the 6 Flutter cards)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .testTag("admin_dashboard_grid")
            ) {
                item {
                    DashboardGridCard(
                        title = "Hayyama Galmee",
                        subtitle = if (pendingCount > 0) "$pendingCount eeggataa jira" else "Qophii",
                        icon = Icons.Default.Approval,
                        color = Color(0xFFFF9800), // Orange
                        badgeCount = pendingCount,
                        testTag = "card_approval",
                        onClick = { viewModel.navigateTo(Screen.Approval) }
                    )
                }

                item {
                    DashboardGridCard(
                        title = "Hifzii & Barnoota",
                        subtitle = "Qaayidaa, Shuruuxa & Hadiisa",
                        icon = Icons.Default.MenuBook,
                        color = Color(0xFF2196F3), // Blue
                        testTag = "card_studies",
                        onClick = { viewModel.navigateTo(Screen.Studies) }
                    )
                }

                item {
                    DashboardGridCard(
                        title = "Argama (Attendance)",
                        subtitle = "To'annoo guyyaa har'aa",
                        icon = Icons.Default.HowToReg,
                        color = Color(0xFF4CAF50), // Green
                        testTag = "card_attendance",
                        onClick = { viewModel.navigateTo(Screen.Attendance) }
                    )
                }

                item {
                    DashboardGridCard(
                        title = "Gabaasa (Reports)",
                        subtitle = "Istaatistiksii waliigalaa",
                        icon = Icons.Default.BarChart,
                        color = Color(0xFF9C27B0), // Purple
                        testTag = "card_reports",
                        onClick = { viewModel.navigateTo(Screen.Reports) }
                    )
                }

                item {
                    DashboardGridCard(
                        title = "Chat & Friends",
                        subtitle = "Maroo fi Marii Barattootaa",
                        icon = Icons.Default.Chat,
                        color = Color(0xFF3F51B5), // Indigo
                        testTag = "card_chat",
                        onClick = { viewModel.navigateTo(Screen.Chat) }
                    )
                }

                item {
                    DashboardGridCard(
                        title = "Deeggarsa (Donation)",
                        subtitle = "CBE, Telebirr & Sadaqaa",
                        icon = Icons.Default.VolunteerActivism,
                        color = Color(0xFFE53935), // Red
                        testTag = "card_donation",
                        onClick = { viewModel.navigateTo(Screen.Donation) }
                    )
                }
            }
        }
    }
}

@Composable
fun StatItem(label: String, value: String, highlight: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = if (highlight) GoldAccent else Color.White
        )
        Text(
            text = label,
            fontSize = 11.sp,
            color = Color.White.copy(alpha = 0.85f)
        )
    }
}

@Composable
fun DashboardGridCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    color: Color,
    badgeCount: Int = 0,
    testTag: String,
    onClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp)
            .clickable(onClick = onClick)
            .testTag(testTag)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
        ) {
            // Badge for pending counter if any
            if (badgeCount > 0) {
                Badge(
                    containerColor = Color(0xFFE53935),
                    contentColor = Color.White,
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Text("$badgeCount", fontWeight = FontWeight.Bold, fontSize = 11.sp)
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = CircleShape,
                    color = color.copy(alpha = 0.15f),
                    modifier = Modifier.size(54.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = icon,
                            contentDescription = title,
                            tint = color,
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = TextDark
                    ),
                    maxLines = 1
                )

                Text(
                    text = subtitle,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = TextMuted,
                        fontSize = 10.sp
                    ),
                    maxLines = 1
                )
            }
        }
    }
}
