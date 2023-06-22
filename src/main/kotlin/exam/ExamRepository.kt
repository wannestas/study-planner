package exam

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

interface ExamRepository {
    val exams: List<Exam>
    fun getExam(name: String): Exam?
    fun createExam(name: String, moment: LocalDateTime, duration: Duration = 3.hours)
}