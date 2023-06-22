package exam

import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration

class ExamRepositoryImpl: ExamRepository {
    private val _exams = mutableListOf<Exam>()
    override val exams: List<Exam>
        get() = _exams.toList()

    override fun getExam(name: String): Exam? = _exams.find { it.courseName == name
    }

    override fun createExam(name: String, moment: LocalDateTime, duration: Duration) {
        require(!_exams.any { it.courseName == name })
        _exams.add(Exam(moment, name))
    }

}