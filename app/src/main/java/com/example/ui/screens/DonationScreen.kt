package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.DonationAccount
import com.example.data.SampleData
import com.example.ui.SubuluSalaamViewModel
import com.example.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonationScreen(
    viewModel: SubuluSalaamViewModel,
    modifier: Modifier = Modifier
) {
    BackHandler {
        viewModel.navigateBack()
    }

    val context = LocalContext.current
    var selectedAmount by remember { mutableStateOf("250") }
    var showBlessingDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Deeggarsa Markazaa (Sadaqaa)",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = { viewModel.navigateBack() },
                        modifier = Modifier.testTag("donation_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Deebi'i",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE53935))
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
                .padding(20.dp)
        ) {
            // Hadith on Sadaqaa Header
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = Color(0xFFFFEBEE),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "«مَا نَقَصَتْ صَدَقَةٌ مِنْ مَالٍ»",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFC62828),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "“Sadaqaan qabeenya irraa homaa hin hir'iftu; barakaa fi ajira dachaa dabalchiifti malee.”",
                        fontSize = 12.sp,
                        color = TextDark,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Markaza Subulu-Salaam deeggaruuf karaalee armaan gadii fayyadamaa:",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = TextDark
                )
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Donation Accounts
            SampleData.donationAccounts.forEach { account ->
                DonationAccountCard(
                    account = account,
                    onCopy = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("Herrega Markazaa", account.accountNumber)
                        clipboard.setPrimaryClip(clip)
                        viewModel.copyToClipboardSuccess(account.accountNumber)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Select Donation Amount
            Text(
                text = "Hanga Deeggarsaa (ETB / Birr):",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = TextDark
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("100", "250", "500", "1000", "2000").forEach { amount ->
                    FilterChip(
                        selected = selectedAmount == amount,
                        onClick = { selectedAmount = amount },
                        label = { Text("$amount Birr", fontWeight = FontWeight.Bold) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFFE53935),
                            selectedLabelColor = Color.White
                        ),
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Main Donate Button matching Flutter
            Button(
                onClick = {
                    viewModel.recordDonation(selectedAmount, "Deeggaraa", "CBE/Telebirr")
                    showBlessingDialog = true
                },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .testTag("donate_submit_button")
            ) {
                Icon(
                    imageVector = Icons.Default.VolunteerActivism,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(22.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Deeggarsa Kaa'i / Donate ($selectedAmount Birr)",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }

    if (showBlessingDialog) {
        AlertDialog(
            onDismissRequest = { showBlessingDialog = false },
            icon = {
                Surface(
                    shape = CircleShape,
                    color = Color(0xFFFFEBEE),
                    modifier = Modifier.size(56.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.VolunteerActivism,
                            contentDescription = null,
                            tint = Color(0xFFE53935),
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            },
            title = {
                Text(
                    "Galatoomaa! Jazaakallaahu Kheeyran",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Text(
                    "Deeggarsa keessaniif Rabbii ajira isiin haa kennu! Sadaqaa Birr $selectedAmount gootaniif Rabbiin qabeenya keessan keessatti barakaa haa buusu.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            confirmButton = {
                Button(
                    onClick = { showBlessingDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Aamiin / Eeyyee")
                }
            }
        )
    }
}

@Composable
fun DonationAccountCard(
    account: DonationAccount,
    onCopy: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                color = if (account.isTelebirr) Color(0xFFE1F5FE) else Color(0xFFFFF3E0),
                modifier = Modifier.size(46.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = if (account.isTelebirr) Icons.Default.PhoneAndroid else Icons.Default.AccountBalance,
                        contentDescription = null,
                        tint = if (account.isTelebirr) Color(0xFF0288D1) else Color(0xFFE65100),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = account.bankName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = TextDark
                )
                Text(
                    text = "Lakkoofsa: ${account.accountNumber}",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = TealDark,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                Text(
                    text = "Maqaa: ${account.accountHolder}",
                    fontSize = 12.sp,
                    color = TextMuted
                )
            }

            IconButton(
                onClick = onCopy,
                modifier = Modifier.testTag("copy_acc_${account.bankName.take(4)}")
            ) {
                Surface(
                    shape = CircleShape,
                    color = TealLight,
                    modifier = Modifier.size(36.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.ContentCopy,
                            contentDescription = "Garagālchi",
                            tint = TealDark,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}
