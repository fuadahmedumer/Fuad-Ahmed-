package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.*
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.theme.*

// ==========================================
// 1. STUDIES DASHBOARD SCREEN
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudiesDashboardScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Barnoota Diinii & Qur'aanaa",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("studies_back_button")
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
                .background(SurfaceSlate)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Intro Callout
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = TealLight,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        tint = TealDark,
                        modifier = Modifier.size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(14.dp))
                    Column {
                        Text(
                            text = "Sirna Barnoota Markazaa",
                            fontWeight = FontWeight.Bold,
                            color = TealDark,
                            fontSize = 15.sp
                        )
                        Text(
                            text = "Qaayidaa, Shuruuxa Salaataa, Hadiisaa fi Hifzii Qur'aanaa haala salphaan baradhaa.",
                            color = TextDark,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            StudyCategoryCard(
                title = "Qaayidaa Nuuraaniyyaa",
                subtitle = "Qajeelfama dubbisa Qur'aanaa jalqabaa (Boqonnaa 1-17)",
                badge = "17 Darsii",
                icon = Icons.Default.MenuBook,
                color = TealPrimary,
                testTag = "study_qaayidaa_card",
                onClick = { viewModel.navigateTo(Screen.Qaayidaa) }
            )

            Spacer(modifier = Modifier.height(14.dp))

            StudyCategoryCard(
                title = "Shuruuxa Salaataa",
                subtitle = "Seerotaa fi shuruuxa salaanni itti fudhatamu (9 Shuruux)",
                badge = "Shuruuxa 9",
                icon = Icons.Default.AccessTime,
                color = Color(0xFF3F51B5),
                testTag = "study_shuruuxa_card",
                onClick = { viewModel.navigateTo(Screen.Shuruuxa) }
            )

            Spacer(modifier = Modifier.height(14.dp))

            StudyCategoryCard(
                title = "Hadiisota Filatamoo (Al-Arba'in)",
                subtitle = "Hadiisota Rasuulaa (S.A.W) gaggabaaboo fi hiika isaanii",
                badge = "Hadiisa 10+",
                icon = Icons.Default.FormatQuote,
                color = Color(0xFFFF9800),
                testTag = "study_hadiisa_card",
                onClick = { viewModel.navigateTo(Screen.Hadiisa) }
            )

            Spacer(modifier = Modifier.height(14.dp))

            StudyCategoryCard(
                title = "Hifzii Qur'aanaa",
                subtitle = "To'annoo qoommaffaa (hafaza) Qur'aana barattootaa",
                badge = "Juz 1-30",
                icon = Icons.Default.Star,
                color = EmeraldGreen,
                testTag = "study_hifz_card",
                onClick = { viewModel.navigateTo(Screen.HifzProgress) }
            )
        }
    }
}

@Composable
fun StudyCategoryCard(
    title: String,
    subtitle: String,
    badge: String,
    icon: ImageVector,
    color: Color,
    testTag: String,
    onClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag(testTag)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = color.copy(alpha = 0.15f),
                modifier = Modifier.size(52.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = color,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = TextDark
                    )
                }
                Text(
                    text = subtitle,
                    fontSize = 12.sp,
                    color = TextMuted,
                    modifier = Modifier.padding(top = 2.dp, bottom = 4.dp)
                )
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = color.copy(alpha = 0.1f)
                ) {
                    Text(
                        text = badge,
                        color = color,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                contentDescription = "Bani",
                tint = TextMuted,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

// ==========================================
// 2. QAAYIDAA NUURAANIYYAA SCREEN (17 LESSONS)
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QaayidaaScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Qaayidaa Nuuraaniyyaa",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("qaayidaa_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = TealPrimary)
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
        ) {
            items(SampleData.qaayidaaLessons, key = { it.id }) { lesson ->
                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.selectQaayidaaLesson(lesson.id) }
                        .testTag("qaayidaa_lesson_${lesson.id}")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = CircleShape,
                            color = TealPrimary,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = "${lesson.id}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = lesson.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = TextDark
                            )
                            Text(
                                text = lesson.subtitle,
                                fontSize = 12.sp,
                                color = TextMuted
                            )
                            Surface(
                                shape = RoundedCornerShape(6.dp),
                                color = TealLight,
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                Text(
                                    text = lesson.arabicSample,
                                    color = TealDark,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                                )
                            }
                        }

                        IconButton(
                            onClick = { viewModel.selectQaayidaaLesson(lesson.id) },
                            modifier = Modifier.testTag("play_lesson_${lesson.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayCircleFilled,
                                contentDescription = "Dhaggeeffadhu",
                                tint = TealPrimary,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// 3. QAAYIDAA LESSON DETAIL (INTERACTIVE LETTERS)
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QaayidaaDetailScreen(
    lessonId: Int,
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val lesson = SampleData.qaayidaaLessons.find { it.id == lessonId }
        ?: SampleData.qaayidaaLessons.first()

    var selectedLetter by remember { mutableStateOf(lesson.letters.firstOrNull() ?: "") }
    var isAudioPlaying by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Darsii ${lesson.id}",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("qaayidaa_detail_back")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = TealPrimary)
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
                .padding(16.dp)
        ) {
            // Lesson Header
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = TealLight),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = lesson.title,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 17.sp,
                        color = TealDark
                    )
                    Text(
                        text = lesson.description,
                        fontSize = 13.sp,
                        color = TextDark,
                        modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = { isAudioPlaying = !isAudioPlaying },
                            colors = ButtonDefaults.buttonColors(containerColor = TealPrimary)
                        ) {
                            Icon(
                                imageVector = if (isAudioPlaying) Icons.Default.Pause else Icons.Default.VolumeUp,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(if (isAudioPlaying) "Dhaabi..." else "Qiraatii Dhaggeeffadhu")
                        }

                        if (selectedLetter.isNotBlank()) {
                            Text(
                                text = "Filatame: $selectedLetter",
                                fontWeight = FontWeight.Bold,
                                color = TealDark,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Qubeewwan Darsii Kanaa (Tuquun Shaakalaa):",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Letters Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(lesson.letters) { letter ->
                    val isSelected = selectedLetter == letter
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) GoldAccent else Color.White
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 6.dp else 2.dp),
                        modifier = Modifier
                            .height(72.dp)
                            .clickable {
                                selectedLetter = letter
                            }
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Text(
                                text = letter,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.Black else TealDark,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Navigation to next lesson if available
            if (lesson.id < 17) {
                Button(
                    onClick = { viewModel.selectQaayidaaLesson(lesson.id + 1) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = TealPrimary)
                ) {
                    Text("Darsii Itti Aanu (Boqonnaa ${lesson.id + 1})")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

// ==========================================
// 4. SHURUUXA SALAATAA SCREEN (9 CONDITIONS)
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShuruuxaScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    var expandedItemNumber by remember { mutableIntStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Shuruuxa Salaataa (9)",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("shuruuxa_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3F51B5))
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
        ) {
            item {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = Color(0xFFE8EAF6),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Shuruuxni Salaataa 9 dha:",
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.ExtraBold,
                                color = Color(0xFF1A237E)
                            )
                        )
                        Text(
                            text = "Salaanni akka fudhatama qabaatuuf ulaagaalee saglan kana salaata dura guutuun dirqama.",
                            style = MaterialTheme.typography.bodySmall.copy(color = TextDark),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            items(SampleData.shuruuxaItems, key = { it.number }) { item ->
                val isExpanded = expandedItemNumber == item.number

                Card(
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            expandedItemNumber = if (isExpanded) 0 else item.number
                        }
                        .testTag("shuruux_item_${item.number}")
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = Color(0xFF3F51B5),
                                modifier = Modifier.size(36.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = "${item.number}",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 15.sp
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = item.titleOromoo,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = TextDark
                                )
                                Text(
                                    text = item.titleArabic,
                                    fontSize = 13.sp,
                                    color = Color(0xFF3F51B5),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Icon(
                                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                contentDescription = null,
                                tint = TextMuted
                            )
                        }

                        AnimatedVisibility(visible = isExpanded) {
                            Column(modifier = Modifier.padding(top = 12.dp)) {
                                Divider(color = Color(0xFFE0E0E0))
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = item.description,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    color = TextDark
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color(0xFFFFF8E1),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(modifier = Modifier.padding(8.dp)) {
                                        Text(
                                            text = "Ragaa (Daliila): ",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 12.sp,
                                            color = GoldDark
                                        )
                                        Text(
                                            text = item.evidence,
                                            fontSize = 12.sp,
                                            color = TextDark
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// 5. HADIISOTA FILATAMOO (AL-ARBA'IN) SCREEN
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HadiisaScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    var searchQuery by remember { mutableStateOf("") }
    val filteredHadiths = remember(searchQuery) {
        if (searchQuery.isBlank()) SampleData.hadithList
        else SampleData.hadithList.filter {
            it.title.contains(searchQuery, ignoreCase = true) ||
            it.oromooTranslation.contains(searchQuery, ignoreCase = true) ||
            it.arabicText.contains(searchQuery)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Hadiisota Filatamoo",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("hadiisa_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFF9800))
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
            // Search field
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Hadiisa barbaadaa...") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color(0xFFFF9800))
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(imageVector = Icons.Default.Clear, contentDescription = "Haquu")
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredHadiths, key = { it.id }) { hadith ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.selectHadith(hadith.id) }
                            .testTag("hadith_card_${hadith.id}")
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = hadith.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp,
                                    color = Color(0xFFE65100)
                                )
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFFFFF3E0)
                                ) {
                                    Text(
                                        text = "#${hadith.id}",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 11.sp,
                                        color = Color(0xFFE65100),
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Arabic snippet
                            Text(
                                text = hadith.arabicText,
                                fontSize = 15.sp,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight.Medium,
                                color = TealDark,
                                textAlign = TextAlign.Right,
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = hadith.oromooTranslation,
                                fontSize = 13.sp,
                                lineHeight = 19.sp,
                                color = TextDark
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = hadith.narrator,
                                    fontSize = 11.sp,
                                    color = TextMuted
                                )
                                Text(
                                    text = "Guutuu Dubbisi →",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFE65100)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// ==========================================
// 6. HADITH DETAIL SCREEN
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HadiisaDetailScreen(
    hadithId: Int,
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val hadith = SampleData.hadithList.find { it.id == hadithId }
        ?: SampleData.hadithList.first()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        hadith.title,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("hadith_detail_back")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFF9800))
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Arabic Calligraphy Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Arabiffaan / باللغة العربية:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = hadith.arabicText,
                        fontSize = 20.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = TealDark,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Afaan Oromoo Translation Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Hiika Afaan Oromootiin:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextMuted
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = hadith.oromooTranslation,
                        fontSize = 15.sp,
                        lineHeight = 24.sp,
                        color = TextDark
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Divider(color = Color(0xFFEEEEEE))
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Ragaa fi Gabaasaa:",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = TextMuted
                    )
                    Text(
                        text = hadith.narrator,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp,
                        color = Color(0xFFE65100)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Lesson / Barumsa
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Lightbulb, contentDescription = null, tint = GoldDark)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Barumsa Hadiisa Kana Irraa Argannu:",
                            fontWeight = FontWeight.Bold,
                            color = GoldDark,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = hadith.keyLesson,
                        fontSize = 13.sp,
                        color = TextDark
                    )
                }
            }
        }
    }
}

// ==========================================
// 7. HIFZII QUR'AANAA SCREEN
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HifzProgressScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val students by viewModel.students.collectAsState()
    val hifzStudents = students.filter { it.isApproved && it.course.contains("Hifzii") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Hifzii Qur'aanaa",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("hifz_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = EmeraldGreen)
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SurfaceSlate)
        ) {
            item {
                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = EmeraldContainer,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = EmeraldGreen,
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Sadarkaa Hifzii Barattootaa",
                                fontWeight = FontWeight.Bold,
                                color = EmeraldGreen,
                                fontSize = 15.sp
                            )
                            Text(
                                text = "Guddinna qoommaffaa Qur'aanaa barattoota Markaza Subulu-Salaam.",
                                fontSize = 12.sp,
                                color = TextDark
                            )
                        }
                    }
                }
            }

            items(hifzStudents, key = { it.id }) { student ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = EmeraldGreen.copy(alpha = 0.15f),
                                modifier = Modifier.size(42.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = null,
                                        tint = EmeraldGreen
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
                                    text = "Sadarkaa: ${student.hifzSurah}",
                                    fontSize = 12.sp,
                                    color = EmeraldGreen,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Text(
                                text = "${(student.progressPercent * 100).toInt()}%",
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = EmeraldGreen
                            )
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        LinearProgressIndicator(
                            progress = { student.progressPercent },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                                .clip(RoundedCornerShape(4.dp)),
                            color = EmeraldGreen,
                            trackColor = EmeraldContainer
                        )
                    }
                }
            }
        }
    }
}
