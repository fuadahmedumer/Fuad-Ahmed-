package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.ArrayDeque

class SubuluSalaamViewModel : ViewModel() {

    private val screenStack = ArrayDeque<Screen>().apply {
        push(Screen.Splash)
    }

    private val _currentScreen = MutableStateFlow<Screen>(Screen.Splash)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    private val _userRole = MutableStateFlow(UserRole.ADMIN_USTAAZ)
    val userRole: StateFlow<UserRole> = _userRole.asStateFlow()

    private val _students = MutableStateFlow(SampleData.initialStudents)
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    private val _attendanceList = MutableStateFlow<List<AttendanceRecord>>(emptyList())
    val attendanceList: StateFlow<List<AttendanceRecord>> = _attendanceList.asStateFlow()

    private val _chatMessages = MutableStateFlow(SampleData.initialChatMessages)
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    private val _selectedLesson = MutableStateFlow<QaayidaaLesson?>(null)
    val selectedLesson: StateFlow<QaayidaaLesson?> = _selectedLesson.asStateFlow()

    private val _selectedHadith = MutableStateFlow<HadithItem?>(null)
    val selectedHadith: StateFlow<HadithItem?> = _selectedHadith.asStateFlow()

    private val _snackbarMessage = MutableStateFlow<String?>(null)
    val snackbarMessage: StateFlow<String?> = _snackbarMessage.asStateFlow()

    init {
        initAttendance()
    }

    private fun initAttendance() {
        val initialAttendance = _students.value.filter { it.isApproved }.map { student ->
            AttendanceRecord(
                studentId = student.id,
                studentName = student.name,
                course = student.course,
                isPresent = true,
                timeMarked = "08:30 AM"
            )
        }
        _attendanceList.value = initialAttendance
    }

    fun navigateTo(screen: Screen) {
        screenStack.push(screen)
        _currentScreen.value = screen
    }

    fun navigateBack(): Boolean {
        if (screenStack.size > 1) {
            screenStack.pop()
            _currentScreen.value = screenStack.peek() ?: Screen.Splash
            return true
        }
        return false
    }

    fun setUserRole(role: UserRole) {
        _userRole.value = role
    }

    fun approveStudent(studentId: String) {
        val student = _students.value.find { it.id == studentId }
        _students.update { list ->
            list.map {
                if (it.id == studentId) it.copy(isApproved = true) else it
            }
        }
        // Add to attendance list if not already there
        if (student != null && _attendanceList.value.none { it.studentId == studentId }) {
            _attendanceList.update { list ->
                list + AttendanceRecord(
                    studentId = student.id,
                    studentName = student.name,
                    course = student.course,
                    isPresent = true
                )
            }
        }
        _snackbarMessage.value = "Galmi ${student?.name ?: "barataa"} hayyamameera!"
    }

    fun rejectStudent(studentId: String) {
        val student = _students.value.find { it.id == studentId }
        _students.update { list ->
            list.filterNot { it.id == studentId }
        }
        _snackbarMessage.value = "Galmi ${student?.name ?: "barataa"} haqameera!"
    }

    fun registerNewStudent(name: String, phone: String, course: String, gender: String) {
        val newStudent = Student(
            id = "std_${System.currentTimeMillis()}",
            name = name,
            phone = phone,
            course = course,
            registrationDate = "Har'a (Amma)",
            isApproved = false,
            gender = gender,
            hifzSurah = if (course.contains("Hifzii")) "Juz 30 (Al-Faatihaa)" else "Darsii 1",
            progressPercent = 0.05f
        )
        _students.update { listOf(newStudent) + it }
        _snackbarMessage.value = "Gaaffiin galmee milkaa'inaan ergameera! Ustaaz Fu'aad biraa hayyama eegaa."
    }

    fun toggleAttendance(studentId: String) {
        _attendanceList.update { list ->
            list.map {
                if (it.studentId == studentId) it.copy(isPresent = !it.isPresent) else it
            }
        }
    }

    fun markAllPresent() {
        _attendanceList.update { list ->
            list.map { it.copy(isPresent = true) }
        }
        _snackbarMessage.value = "Barattoonni hundi akka argamanitti galmeeffamaniiru!"
    }

    fun selectQaayidaaLesson(lessonId: Int) {
        val lesson = SampleData.qaayidaaLessons.find { it.id == lessonId }
        _selectedLesson.value = lesson
        navigateTo(Screen.QaayidaaDetail(lessonId))
    }

    fun selectHadith(hadithId: Int) {
        val hadith = SampleData.hadithList.find { it.id == hadithId }
        _selectedHadith.value = hadith
        navigateTo(Screen.HadiisaDetail(hadithId))
    }

    fun sendChatMessage(text: String) {
        if (text.isBlank()) return
        val isMeAdmin = _userRole.value == UserRole.ADMIN_USTAAZ
        val myName = if (isMeAdmin) "Ustaaz Fu'aad Ahmad" else "Barataa"
        val newMsg = ChatMessage(
            id = "msg_${System.currentTimeMillis()}",
            senderName = myName,
            message = text.trim(),
            timestamp = "Amma",
            isFromAdmin = isMeAdmin,
            isMe = true
        )
        _chatMessages.update { it + newMsg }

        // If user is a student, generate an automatic helpful reply from Ustaaz Fu'aad
        if (!isMeAdmin) {
            viewModelScope.launch {
                kotlinx.coroutines.delay(1200)
                val reply = ChatMessage(
                    id = "msg_${System.currentTimeMillis() + 1}",
                    senderName = "Ustaaz Fu'aad Ahmad",
                    message = "Barakallaahu fiikum! Ergaan kee nu gaheera. Darsii fi qiraatii irratti jabaadhaa.",
                    timestamp = "Amma",
                    isFromAdmin = true,
                    isMe = false
                )
                _chatMessages.update { it + reply }
            }
        }
    }

    fun recordDonation(amount: String, donorName: String, bank: String) {
        _snackbarMessage.value = "Galatoomaa! Sadaqaa Birr $amount deeggartaniif Rabbiin ajira fi barakaa isiniif haa kennu."
    }

    fun copyToClipboardSuccess(accountNumber: String) {
        _snackbarMessage.value = "Lakkoofsi herregaa ($accountNumber) garagalfameera!"
    }

    fun clearSnackbar() {
        _snackbarMessage.value = null
    }
}
