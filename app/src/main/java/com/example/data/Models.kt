package com.example.data

sealed class Screen {
    object Splash : Screen()
    object Login : Screen()
    object Register : Screen()
    object AdminDashboard : Screen()
    object Approval : Screen()
    object Studies : Screen()
    object Qaayidaa : Screen()
    data class QaayidaaDetail(val lessonId: Int) : Screen()
    object Shuruuxa : Screen()
    object Hadiisa : Screen()
    data class HadiisaDetail(val hadithId: Int) : Screen()
    object Attendance : Screen()
    object Reports : Screen()
    object Chat : Screen()
    object Donation : Screen()
    object HifzProgress : Screen()
}

enum class UserRole {
    ADMIN_USTAAZ,
    STUDENT
}

data class Student(
    val id: String,
    val name: String,
    val phone: String,
    val course: String, // "Qaayidaa", "Hifzii Qur'aanaa", "Hadiisa & Fiqa"
    val registrationDate: String,
    val isApproved: Boolean = false,
    val gender: String = "Dhiira",
    val hifzSurah: String = "Suuratul Baqara (Aayata 1-50)",
    val progressPercent: Float = 0.45f
)

data class AttendanceRecord(
    val studentId: String,
    val studentName: String,
    val course: String,
    val isPresent: Boolean,
    val timeMarked: String = "08:30 AM",
    val note: String = ""
)

data class QaayidaaLesson(
    val id: Int,
    val title: String,
    val subtitle: String,
    val arabicSample: String,
    val description: String,
    val letters: List<String>
)

data class ShuruuxItem(
    val number: Int,
    val titleOromoo: String,
    val titleArabic: String,
    val description: String,
    val evidence: String
)

data class HadithItem(
    val id: Int,
    val title: String,
    val arabicText: String,
    val oromooTranslation: String,
    val narrator: String,
    val keyLesson: String
)

data class ChatMessage(
    val id: String,
    val senderName: String,
    val message: String,
    val timestamp: String,
    val isFromAdmin: Boolean,
    val isMe: Boolean
)

data class DonationAccount(
    val bankName: String,
    val accountNumber: String,
    val accountHolder: String,
    val branch: String,
    val isTelebirr: Boolean = false
)
